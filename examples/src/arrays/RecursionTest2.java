package arrays;

import java.util.stream.IntStream;

public class RecursionTest2 {
	
	public static String showNums(int first, int last) {
	    if(first==last)
	      return ""+last;
	    else
	      return (first + showNums(first+1,last)  );
	  }

	public static void main(String[] args) {
	System.out.println(RecursionTest2.showNums(0, 100));
	IntStream.range(1,100).forEach(System.out::print);

	}

}
