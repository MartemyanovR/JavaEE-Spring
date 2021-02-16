package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapPollution {
	public static void main(String[] args) {
		List<String> ls =  t();
		String s0 = ls.get(0);
		for (String s : ls)		
			System.out.println(s);
			
		ArrayList<String> strings = new ArrayList<>();
		ArrayList arrayList = new ArrayList();
		arrayList = strings; // (1) Ok
		arrayList.add(1); // (2) unchecked call
		/*
		 * Java разрешает выполнить присваивание в строке (1). Это необходимо для обеспечения обратной совместимости.
		 *  Но если мы попытаемся выполнить метод add в строке (2), то получим предупреждение Unchecked call — 
		 *  компилятор предупреждает нас о возможной ошибке. В самом деле, мы же пытаемся в список строк добавить целое число.
		 */
	}
	
	
	static List<String> t() {
		   List l = new ArrayList<Number>();
		   l.add(1);
		   List<String> ls = l; // (1)
		   ls.add("X");
		   return ls;
		}
	
	static void methVArArgs(List<String> ...lists ) {
		Object[] arrObj = lists;
		List<Integer> tmpList = Arrays.asList(42);
		
		arrObj[0] = tmpList; // (1)
		String s = lists[0].get(0); // (2) java.lang.ClassCastException: 
	}

}
