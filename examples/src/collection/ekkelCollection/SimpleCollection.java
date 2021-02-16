package collection.ekkelCollection;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class SimpleCollection {

	public static void main(String[] args) {
		Collection<Integer> col = new ArrayList<>(10);
		for(int i = 0; i <10; i++ ) {
			col.add(i);
		}
		for (Integer i : col) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
		Set<String> colD = new HashSet<>();
		colD.add("Apple");
		colD.add("Peach");
		colD.add("Pear");
		//дубликаты в Set не добавляются
		colD.add("Apple");
		colD.add("Pear");
		
		for(String str : colD) {
			System.out.print(str + " ");
		}
		
	}

}
