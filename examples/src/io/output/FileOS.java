package io.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileOS {

	public static void main(String[] args) {
		try(FileOutputStream fos = new FileOutputStream("C://eclipse-workspace//README.txt"); 
			FileInputStream fin=new FileInputStream("C://eclipse-workspace//README.txt")) {
			byte[] b = {65,66,67,68,69,70,71,72,73};
			
			fos.write(b);
			
			byte[] bis = new byte[b.length];
			int i = -1;
			int k = 0;
			fin.read(bis);
			String ch = new String(bis);
			System.out.println(Arrays.toString(bis));
			System.out.println(ch);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
