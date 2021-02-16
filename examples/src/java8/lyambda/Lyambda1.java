package java8.lyambda;

import java.util.function.IntFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class Lyambda1 {
	
	public static void meth(int x, IntFunction<Integer> i) {
		i.apply(x);
	}
	
	//получается многофункцианальный метод
	static public String compStr(String[] str, String t, BiPredicate<String, String> bp) {
		for(String s : str)
			if(bp.test(s, t))
				return s;
		return null;
	}
	
	static BiFunction<String, String, Integer> comp = (first,second) -> Integer.compare(first.length(), second.length());
	
	public static void main(String[] args) {
		String[] str = {"A","V","B","S","D"};		
		String to = "F";
		String too = "S";
		//лямбда
		String s = compStr(str, to , (x,y) -> x.contains(y));
		System.out.println(s);
		//ссылка на метод
		s = compStr(str, too, String::contains);
		System.out.println(s);
		
		
		meth(5, (x) -> {
			if(x>0) 
			return 1;
			return 0;
			});		
		
		System.out.println(comp.apply("AB", "ABC"));
		
		Integer[] itg ={13, 7, 6, 45, 21, 9, 2, 100};		
		
		 Arrays.parallelSort(itg, 
				(one,two) -> Integer.compare(one, two)
				);
		System.out.println(Arrays.deepToString(itg));
		
	/*	Arrays.sort(str);
		System.out.println(Arrays.deepToString(str));     */
		
	//упорядочивание массива
	/*	Arrays.sort(str, 
				(one,two) -> one.compareTo(two)
				);
		System.out.println(Arrays.deepToString(str));
		str[0].compareToIgnoreCase(str[1]);	*/
		
		//сортировка листа
		List<String> strList = Arrays.asList(str);
		System.out.println(strList);
		//Collections.sort(strList, (x,y) -> x.compareTo(y));
		Collections.sort(strList, String::compareTo);
		System.out.println(strList);
		
	}

}
