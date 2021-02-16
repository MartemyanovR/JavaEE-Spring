package collection.ekkelCollection;

import java.util.*;


	//11. (2) Напишите метод, который использует Iterator для перебора Collection
	//и выводит результат вызова toString() для каждого объекта в контейнере.
	//Заполните объектами разные типы Collection и примените свой метод к каждому контейнеру.
public class IteratorTask11 {
	public static void main(String[] args) {
		Collection<String> collection = Arrays.asList("One", "Two", "Three", "Four");
		ArrayList<String> arrayList = new ArrayList<>(collection);
		LinkedList<String> linkedList = new LinkedList<>(collection);
		HashSet<String> hashSet = new HashSet<>(collection);
		TreeSet<String> treeSet = new TreeSet<>(collection);
		display(arrayList.iterator());
		arrayList.add("Five");
		display(linkedList.iterator());
		display(hashSet.iterator());
		display(treeSet.iterator());
	}
	public static void display(Iterator<String> itr) {
		while(itr.hasNext())
			System.out.print( itr.next().toString() + ", ");
		System.out.println();
		
	}
	
	

}
