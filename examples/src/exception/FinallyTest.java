package exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import io.Input.FileInputStreamTest;

public class FinallyTest {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:\\eclipse-workspace\\fff.txt");
			System.out.println("try catch");
			int i = 1/0;
			try {
				System.out.println("try finally");
			} finally {
				System.out.println("FINALLY");
			}
		} catch(IOException e) {
			System.out.println("CATCH");
			e.printStackTrace();		
		}

	}

}
