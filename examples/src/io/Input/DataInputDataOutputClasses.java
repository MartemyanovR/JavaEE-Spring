package io.Input;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputDataOutputClasses {
	static final String str = "What is it!?";
	static final String str2 = "\n";
	public static void main(String[] args) {
		int b = 76;
		int line;
		//Create output stream
		try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream
				(new FileOutputStream("C:\\eclipse-workspace\\README.TXT")))) {
			//filing using different methods 
			dos.writeUTF(str);
			dos.writeBytes(str);
			dos.writeByte(b);
			dos.write(str.getBytes());
			dos.writeChar(b);
			dos.writeChar((char)b);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		//Create input stream
		try (DataInputStream dis = new DataInputStream(new BufferedInputStream
				(new FileInputStream("C:\\\\eclipse-workspace\\\\README.TXT")))) {
			//marking in position '0'
			dis.mark(0);
			//estimate of the number of bytes
			System.out.println(dis.available());
			//create buffer, and read bytes from the conteined input steam 
			byte[] by = new byte[dis.available()];
			dis.readFully(by);
			for(byte byt : by) {
				System.out.print((char) byt);
			}
			//transfer this stream to the position at the time the mark 
			dis.reset();
			System.out.println();
			//read Unicode string
			System.out.println(dis.readUTF());
			//read the rest of the data in the stream
			while((line = dis.read()) != -1)
			System.out.print((char)line);
			
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
