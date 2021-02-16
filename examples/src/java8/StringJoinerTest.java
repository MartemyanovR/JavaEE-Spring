package java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerTest {
	
	public static void main(String[] args) {

	
				StringJoiner sj = new StringJoiner(".", "[", "]");
		sj.add("123").add("456").add("789").add(null);
		System.out.println(sj);
	
		//этот конструктор с префиксом и суффиксом
		 StringJoiner sj2 = new StringJoiner(":");
		 sj2.add("Bob").add("age=").add("33");
		 System.out.println(sj2);
		 
		 System.out.println(sj.merge(sj2));
		 
		 /*		 List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		 String commaSeparatorNumber = list.stream().map(i->i.toString()).collect(Collectors.joining("_"));
		 System.out.println(commaSeparatorNumber);
		 
			StringJoiner sj3 = new StringJoiner(".");
		for(Integer i : list ) {
			sj3.add(i.toString());
		 }
		System.out.println(sj3);			
		 
		 
		 //метод String join, тоже что и SJ.add
		 StringJoiner sj3 = new StringJoiner("-");
		 sj3.add("1").add("0").add("1").add("0");
		 String numbers = String.join("-", "1", "0", "1", "0");
		 System.out.printf("%s \n%s", sj3 , numbers + "\n");
		 
		//метод  static String join(CharSequence delimiter,Iterable<? extends CharSequence> elements)
		 List<String> databases = Arrays.asList("OracleDB", "Mongo", "PostgreSQL", "MySQL");
		    String string = String.join(", ", databases);
		   System.out.println(string);
		 */
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}
}
