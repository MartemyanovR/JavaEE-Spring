package rTTI;

import polimorphism.*;

/**
 * 5. Реализуйте в <tt>Shapes.java</tt> метод <b>rotate(Shape)</b>, который проверяет, не относится ли фигура к классу
 * {@link Circle} (и если относится - не выполняет ли операцию).
 * <p>
 * 6. Измените пример <tt>Shapes.java</tt> так, чтобы он мог "выделять" (установкой внутреннеого флага) все фигуры
 * некоторого типа. Метод {@link Object#toString()} каждого класса, производного от {@link Shape}, должен указывать
 * находится ли данная фигура в "выделенном" состоянии.
 */

public class Shapes {
	public static void rotate(final Shape sh) {
		if (sh instanceof Cycle)  sh.draw(); 
		else throw new UnsupportedOperationException(); 
	}		
	public static void main(String[] args) {		
		RndomShapeGenerator  rengen = new RndomShapeGenerator(5);
		/*Rhomboid romb =  new Rhomboid(); 
		Shape shR = romb;
		System.out.println(shR); System.out.println(romb instanceof Shape);	System.out.println(romb instanceof Rhomboid);
		romb = (Rhomboid) shR;
		Cycle cc = new Cycle();
		/*try { cc = (Cycle) shR;
		} catch(ClassCastException e) {	e.printStackTrace(); }
		*/
		Shape[] shape = new Shape[9];
		for(int i = 0; i<shape.length; i++)
			shape[i] = rengen.next();
		for(Shape sh : shape) {			
			try {
				rotate(sh);
			} catch(UnsupportedOperationException e) {
				System.out.println(sh.getClass().getName() + " not supported, can't be rotate");
				sh.isSelect();
				System.out.println(sh);
			}
		}
	}
}
