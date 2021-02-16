package generics.wildCardTest;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {		
		Shape rec = new Rectangle();
		Shape cir = new Circle();
		Circle circle = new Circle();
		
		List<Shape> listShape = new ArrayList<>();
		listShape.add(rec);
		listShape.add(cir);
		listShape.add(circle);
		
		List<Circle> listCirc = new ArrayList<>();
	//	listCirc.add(cir); // не сработает тк тип Shape
		listCirc.add(circle);
	
		Canvas can = new Canvas();
		//ковааариантность!
		can.draw(rec);
		can.draw(cir);
		can.draw(circle);

		can.drawAll(listShape);
		/*
		 * тк в методе drawAll() указан аргумент, List<Shape> то вызвать List<Circle> не возможно.
		 * Обобщения ИНВАРИАНТНЫ 
		 */
	//	can.drawAll(listCirc);
		
		//with bounded WildCard
		can.drawAll(listShape);
		
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		List<? extends Number> nums = ints;
		/*
		 * Если контейнер объявлен с wildcard ? extends, то можно только читать значения.
		 *  В список нельзя ничего добавить, кроме null.
		 */
		nums.add(null);
		System.out.println(ints.get(2));
		System.out.println(nums.get(2));
		
		testExt(listShape);
	}		
	
	public static void testExt (List<? extends Shape> lisWild) {
		for(Shape sh : lisWild) { // тк мы не знаем каакой тип у <?>, мы не можем его присваивать переменной shape, для этого используем <? extends Shape>
			System.out.println(sh);
			sh.figure();
		}
	}
	
	
	public static void testSup (List<? super Shape> lisWild) {  // Shape  не включительно
		for(Object sh : lisWild) { 
			System.out.println(sh);
		//	sh.figure();  //у object нет данного метода, поэтому compile-time error
		}
	}
	
	
	
	
	
	
	
	
	
}
