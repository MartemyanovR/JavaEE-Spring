package io.writerReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderWriterTest {

	public static void main(String[] args) {
	try (Reader fr = new FileReader("C://eclipse-workspace//README.txt"))
	{	
		char[] buff = new char[1];
		
		int i = -1;
		while((i = fr.read(buff)) != -1) {
			System.out.print(buff);
		}

	} catch(IOException e) {
		System.out.println(e.getMessage());
	}
	
	}

}
