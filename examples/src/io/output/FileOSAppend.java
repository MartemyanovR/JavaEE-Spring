package io.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileOSAppend {

	public static void main(String[] args) {
		boolean append = true;
		try(FileOutputStream fos = new FileOutputStream("C://eclipse-workspace//README.txt",append) ) {
				byte[] b = {65,66,67,68,69,70,71,72,73};
				
				fos.write(b);
				fos.write(b);
				fos.write(b);
				fos.write(b);
				fos.write(b);
				
				
		}		
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
}
