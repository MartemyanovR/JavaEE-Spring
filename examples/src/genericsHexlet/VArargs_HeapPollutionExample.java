package genericsHexlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VArargs_HeapPollutionExample {
	public static void main(String[] args) {
		List<String>[] str;
		Integer[] a = {1};
		Number[] b = a;
		String f = "WWW";
		System.out.println(f.isEmpty());
		int result=0;
		//byte[] ch = f.getBytes();
		for(Byte by : f.getBytes())			
			result += by;
		System.out.println(result);
		
	//	b[0] = 2.2d;  //java.lang.ArrayStoreException:
		
	List<String> stringListA = new ArrayList<String>();
    List<String> stringListB = new ArrayList<String>();

    Vararg_heap_pollution.addToList(stringListA, "Seven", "Eight", "Nine");
    Vararg_heap_pollution.addToList(stringListB, "Ten", "Eleven", "Twelve");
    List<List<String>> listOfStringLists =
    		new ArrayList<List<String>>();
    Vararg_heap_pollution.addToList(listOfStringLists,
      stringListA, stringListB);

    Vararg_heap_pollution.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
  }

}
