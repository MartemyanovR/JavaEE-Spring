package java8;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class SortTest {
	public static void main(String[] args) {
		List<Integer> lInt = new ArrayList<>(16);
		lInt.add(5);
		lInt.add(8);
		int a;
		int b;
		Collections.sort(lInt, Comparator.naturalOrder());
		System.out.println(lInt);
		Collections.sort(lInt, Collections.reverseOrder());
		System.out.println(lInt);
		Collections.sort(lInt, new Comparator<Integer>() {  //анонимный
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}			
		});
		System.out.println(lInt);
		Collections.sort(lInt, Collections.reverseOrder());
		System.out.println(lInt);
		Collections.sort(lInt, (Integer o1, Integer o2) -> o1.compareTo(o2));
		System.out.println(lInt);
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		int sum1 = list.stream().map(x -> x*x).reduce((x,y) -> x + y).get();
		int sum2 = list.stream().map(x -> x*x).reduce(Integer::sum).get();
		System.out.println(sum1);
		list.stream().map(x -> x*x).forEach(System.out::println);//.reduce((x,y) -> x + y)
		
		
	}	
}
