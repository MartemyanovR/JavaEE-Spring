package string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenized_split_Scanner {

	public static void main(String[] args) {

		String s;
		s = "book, author, publication,,,date published" ;
/*		StringTokenizer st = new StringTokenizer(s);
		StringTokenizer st = new StringTokenizer(s, ",");
		StringTokenizer st = new StringTokenizer(s, ",", true);   
		while (st.hasMoreTokens()) {
		    // Выводим лексемы в консоль
		    System.out.println(st.nextToken());		
		}												*/
		
		Scanner scan = new Scanner(s);
		while(scan.hasNext()) {
			System.out.println(scan.next());
		}
	}	
}
