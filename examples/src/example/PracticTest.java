package example;

import java.util.Arrays;
import example.Practic;

public class PracticTest {
	public static void main(String ... args) { 
		Practic p = new Practic();
		Practic1 p1 = new Practic1();
		Practic2 p2 = new Practic2();
		System.out.println(p.getName());
		System.out.println(p1.privategetName());
		//работает только при наследовании practic1, а он в свою очередь наследует Practic!
		System.out.println(p2.privategetName());
		Practic.getEx();
		p.info();
		p.toString();
        Boolean b = new Boolean("/true"); 
        String str[] = {"X",null,"O"};
        System.out.println(b); 
        System.out.println(Arrays.deepToString(str)); 
    } 
 
	 public static void main(String args) { 
	        Boolean b = new Boolean("/false"); 
	        System.out.println(b == false); 
	    } 
}
