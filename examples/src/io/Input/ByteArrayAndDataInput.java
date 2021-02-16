package io.Input;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class ByteArrayAndDataInput {

	public static void main(String[] args) {
		
		byte[] b = {111,68,74,56,98,89,77,115};		
		try (DataInputStream dis = new DataInputStream(new ByteArrayInputStream(b)))		
		 {
			int i = (int)dis.available();
			byte[] byt = new byte[i];
			for(byte by = 0; by < i; by++)
			 byt[by] = dis.readByte();
			String str = new String(byt);
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
