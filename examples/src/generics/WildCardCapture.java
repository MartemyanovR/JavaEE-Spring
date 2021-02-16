package generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardCapture {
	
	public static void main(String[] args) {	}
	
	

	 
	public static void reverse(List<?> list) {	//Проблема
		  List<Object> tmp = new ArrayList<Object>(list);
		  for (int i = 0; i < list.size(); i++) {
			  /*
			   * В методе reverse в качестве аргумента принимается список с неограниченным символом подстановки <?> .
			   *<?> означает то же что и <? extends Object>. Следовательно, согласно принципу PECS, list – это producer.
			   * А producer только продюсирует элементы. А мы в цикле for вызываем метод set(), т.е. пытаемся записать в list.
			   */
//	    list.set(i, tmp.get(list.size()-i-1)); // compile-time error
		  }
		}
	 void foo(List<?> i) {
//	        i.set(0, i.get(0)); //тоже самое
	    }
	
	// РЕШЕНИЕ ↓
	public static void reverseGood(List<?> list) {
		rev(list);
	}
	
	private static <T> void rev(List<T> list) {
		  List<T> tmp = new ArrayList<T>(list);
		  for (int i = 0; i < list.size(); i++) {
		    list.set(i, tmp.get(list.size()-i-1));
		  }
		}
	

}
