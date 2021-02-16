package arrays;

import java.util.Arrays;

public class ArraysFillTest {

	public static void main(String[] args) {
	/*	Integer[] integ = new Integer[] {1,2,3,4,5};
		Integer in = 10;
		Arrays.fill(integ, in);
		
			System.out.println(Arrays.toString(integ));  */
		NodeClass nc = new NodeClass();
		Object[] numbers = new Object[100];
		//внутри филла есть фор перебирающий элементы массива и присваевающий обьект
        Arrays.fill(numbers, nc);
        System.out.println(Arrays.toString(numbers));
        
	}

}
