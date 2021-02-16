package io.Input;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushbacklS {

	public static void main(String[] args) { 
		try	(PushbackInputStream pb = new PushbackInputStream(
				new BufferedInputStream(new FileInputStream("C://eclipse-workspace//Pushback.txt")))) {
			int i = -1;
			int k = 200;
			while (((i = pb.read()) != -1) && k !=0) {
				if(i == 65)
					pb.unread(i);
				System.out.print( i);
				k--;
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
