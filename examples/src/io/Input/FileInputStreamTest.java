package io.Input;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		try(FileInputStream fin=new FileInputStream("C://eclipse-workspace//README.txt"))
        {
            System.out.printf("File size: %d bytes \n", fin.available());
              
            int i=-1;
            while((i=fin.read())!=-1){
              
                System.out.print((char)i);
            }   
        }
        catch(IOException ex){
              
            System.out.println(ex.getMessage());
        } 
	}

}
