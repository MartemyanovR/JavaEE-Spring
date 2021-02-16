package io.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipEntryTest {
	
	public static void main(String[] args) {

	
	try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("C://eclipse-workspace//ARCHIV.ZIP"));  //открываем выходной поток
			FileInputStream fis = new FileInputStream("C://eclipse-workspace//README.txt");    //открываем входной поток для чтения
			FileOutputStream fos2 = new FileOutputStream("C://eclipse-workspace//README2.txt"))	{ 
		ZipEntry ze = new ZipEntry("README.txt");  //создам файл для архивации
		zos.putNextEntry(ze);   // погружаем файл в архив
		
		byte[] buf = new byte[fis.available()];  //создаем масив байт для чтения данных с файла
		fis.read(buf);  //читаем в массив
		zos.write(buf);  //пишем с массива в выходной поток
		zos.closeEntry();  // закрываем текущую запись, для новой записи
		
		
		String s = "OneTwoThree";
		byte[] b = s.getBytes();
		fos2.write(b);
		ZipEntry ze2 = new ZipEntry("README2.txt");  //создам файл для архивации
		zos.putNextEntry(ze2);
		zos.write(b);
		zos.closeEntry();
	}catch(IOException e) {
		e.getMessage();
		}



	}
}