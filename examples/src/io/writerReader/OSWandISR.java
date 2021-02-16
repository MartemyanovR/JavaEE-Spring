package io.writerReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OSWandISR {

	public static void main(String[] args) {
		/*
		 * InputStreamReader не только получает данные из потока. Он еще и преобразует байтовые потоки в символьные.
		 *  Иными словами, тебе уже не нужно самому заботиться о переводе считанных данных с “компьютерного” языка на “человеческий”
		 */
		//считывает байты а не символы
		try (InputStreamReader prost = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("C://eclipse-workspace//README.txt"))))		
		 {			
			//возвращает считанный символ
			int strProst = prost.read();
			System.out.println(strProst);   
			

			//возвращает количиство символов, если буфер меньше длинны символов, вернет chbuff.length
			char[] chbuf = new char[100];
			int intProst = prost.read(chbuf);					
			System.out.println(intProst);
					
			/*	
			String str = reader.readLine();
			System.out.println(str);
			
			
			String str2 = null;
			while((str2 = reader2.readLine())  != null)
				System.out.println(str2);
*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C://eclipse-workspace//README.txt"), "UTF-16")) {
			
			String strOut = "Hello World!!!";
			
			osw.write(strOut);
			
			
		} catch(IOException e ) {
			e.getMessage();
		}
		
		

	}

}
