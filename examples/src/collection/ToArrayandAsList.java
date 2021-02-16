package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToArrayandAsList {

	public static void main(String[] args) {
		Integer[] arrint = {1,2,3,6,5,4,7};
		List<Integer> listInt = Arrays.asList(arrint);
		System.out.println(Arrays.toString(arrint) + "\n" + listInt);
		arrint[0] = null;
		System.out.println(Arrays.toString(arrint) + "\n" + listInt);
		listInt.set(0, 99);
		System.out.println(Arrays.toString(arrint) + "\n" + listInt);
		
		System.out.println();
		
		Integer[] intarr= listInt.toArray(new Integer[10]);
		System.out.println(Arrays.toString(intarr));
		intarr[0] = null;
		System.out.println(Arrays.toString(arrint) + "\n" + listInt + "\n" + Arrays.toString(intarr));		
		
		Arrays.fill(intarr, 1);
		System.out.println(Arrays.toString(arrint) + "\n" + listInt + "\n" + Arrays.toString(intarr));
		
		Arrays.parallelPrefix(intarr, (x,y) -> x+y);
		System.out.println(Arrays.toString(arrint) + "\n" + listInt + "\n" + Arrays.toString(intarr));
		
		final Integer finint = 1;
		final Integer[] arrintfinal = {finint,2,3,6,5,4,7};
		Arrays.parallelSetAll(intarr, (i) -> i*10 );
		Arrays.parallelSetAll(arrintfinal, (i) -> i*10 );
		System.out.println(Arrays.toString(arrint) + "\n" + listInt + "\n"  
						+ Arrays.toString(intarr) + "\n"  +Arrays.toString(arrintfinal));
	}

}
