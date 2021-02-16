package collection.ekkelCollection;

import java.util.*;

public class ListFeatures {
	public static void main(String[] args) {
		Random rand = new Random(47);
		List<Integer> integer = new ArrayList<Integer>();
		for(int i = 0; i < 10 ; i++) {
		integer.add(i);
		}
		for(Integer i: integer) {
			System.out.print(i + ", ");
		}
		System.out.println("\n");
		System.out.println("1: " + integer);
		Integer h = new Integer(1);
		integer.add(h);
		// С автоматическим изменением размера
		System.out.println("2: " + integer);
		System.out.println("3: " + integer.contains(h)); 
		//remove идет по списку, находит первый сопвавшийся обьект и удаляет его.После завершается.
		integer.remove(h);
		System.out.println("1: " + integer);
		// Удаление заданного объекта 		
		Integer p = integer.get(2);
		System.out.println("4: " + p + " " + integer.indexOf(p));
		Integer two = new Integer(2); 
		System.out.println("5: " + integer.indexOf(two)); 
		System.out.println("6: " + integer.remove(two));
		// Удаление заданного объекта: 
		System.out.println("7: " + integer.remove(p));
		System.out.println("8: " + integer);
		integer.add(3, 2); 
		// Вставка по индексу
		System.out.println("9: " + integer);
		List<Integer> sub = integer.subList(1, 4);
		System.out.println("sub список: " + sub);
		System.out.println("10: " + integer.containsAll(sub));
		Collections.sort(sub);
		// Сортировка "на месте"
		System.out.println("nocne сортировки: " + sub);
		// Для containsAll() порядок не важен:
		System.out.println("ll: " + integer.containsAll(sub));
		System.out.println("11,1: " + integer);
		Collections.shuffle(sub, rand); 
		// Перемешивание 
		System.out.println("nocne перемешивания: " + sub); 
		System.out.println("12: " + integer.containsAll(sub));
		List<Integer> copy = new ArrayList<Integer>(integer);
		sub = Arrays.asList(integer.get(1), integer.get(4)); 
		System.out.println("sub: " + sub);
		copy.retainAll(sub);
		System.out.println("13: " + copy);
		copy = new ArrayList<Integer>(integer);
		// Копирование
		try {
		copy.remove(new Integer(1));
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("in the method remove() out onf bound!");
		}
		// Удаление по индексу 
		System.out.println("14: " + copy);
		copy.removeAll(sub);
		// Удаление заданных объектов
		System.out.println("15: " + copy);
		try {
		copy.set(1, 777);
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("in the method add(index,value) out onf bound!");
		}		
		// Замена элемента 
		System.out.println("16: " + copy);
		copy.addAll(2, sub);
		// Вставка списка в середину
		System.out.println("17: " + copy);
		System.out.println("18: " + integer.isEmpty());
		integer.clear(); 
		// Удаление всех элементов
		System.out.println("19: " + integer);
		System.out.println("20: " + integer.isEmpty());
		integer.addAll(copy);
		System.out.println("21:  " + integer);
		Object[] ob = integer.toArray();
		System.out.println("22: " + ob[3]);
		Object[] pa = integer.toArray(); 
		System.out.println("23: " +pa + "  " +  Arrays.deepToString(pa));
		
	}
}
