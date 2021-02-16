package java8.lyambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Lyambda2 {

	public static void main(String[] args) {
		Integer[] arr = {5,8,7,666,2,4,54,45};
		List<Integer> list =Arrays.asList(arr);
		Collections.sort(list, (x,y)-> y.compareTo(x));
		System.out.println(list);
		

	}

}
