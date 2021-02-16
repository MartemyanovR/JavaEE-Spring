package generics;

import java.util.ArrayList;
import java.util.List;

public class WildCard {
	
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		List<? extends Number> nums = ints;
		/*
		 * Если контейнер объявлен с wildcard ? extends, то можно только читать значения.
		 *  В список нельзя ничего добавить, кроме null.
		 */
		nums.add(null);  //мы не можем ничего добавить, тк на момент компиляции нам не известно какой тип у "?"
		System.out.println(ints.get(2));
		System.out.println(nums.get(2));
		
		List<? super Integer> numsW = ints;
		numsW.add(new Integer(1));
		System.out.println(numsW.get(1));

	}
	
		
	//Нельзя прочитать элемент из контейнера с wildcard ? super, кроме объекта класса Object
	public static <T> T getFirst(List<? super T> list) {
		// return list.get(0); // compile-time error				   
		return null; 
		}
	
	public static <T> Object getFirstObj(List<? super T> list) {
		//	list.add(new Object());  
		   return list.get(0);
		}
	
	
}
