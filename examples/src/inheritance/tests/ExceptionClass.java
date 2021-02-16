package inheritance.tests;

import java.io.IOException;

public class ExceptionClass {
	
	public static void test(int j) throws Exception{
		try {
			System.out.println("Before exception");
			int i = 4/j;
			System.out.println("After exception");
		}catch(ArithmeticException e) {
			System.out.println("Catch in meth test");
			test(j+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		try {ExceptionClass.test(0);
		}catch(IOException e) {
			System.out.println("processed");
		}
	}
}
