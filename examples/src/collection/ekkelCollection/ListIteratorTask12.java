package collection.ekkelCollection;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

public class ListIteratorTask12 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		final int size = list.size();
		List<Integer> arrayList = new ArrayList<>(size);
		System.out.println(list.size());
		/*ListIterator<Integer> litr = list.listIterator();
		//first way
		while(litr.hasNext()) {
			litr.next();
		}
		
		while(litr.hasPrevious()) {
			arrayList.add(litr.previous());
		}
		*/
		ListIterator<Integer> litr = list.listIterator(size);
		while(litr.hasPrevious()) {
			arrayList.add(litr.previous());
		}
		System.out.println(list);
		System.out.println(arrayList);
	
	}

}
