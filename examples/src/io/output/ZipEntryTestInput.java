package io.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipEntryTestInput {

	public static void main(String[] args) {

		try(ZipInputStream zis = new ZipInputStream(
				new FileInputStream("C://eclipse-workspace//ARCHIV.ZIP"))) //создаем входной поток из архива
		{
			ZipEntry ze;  
			String name;
			long size;
			while  ((ze = zis.getNextEntry()) != null) {		//читаем с входного потока лежащие внутри entry
					name = ze.getName();						//получаем имя entry
					size = ze.getSize();
					System.out.println(name + " size: " + size);
					FileOutputStream fos = new FileOutputStream(
							"C://eclipse-workspace//new" + name);  //создаем выходной поток, для записи в файл
					for(int c = zis.read(); c!=-1; c=zis.read()) {   //читаем побайтно содержимое каждого файла архива
						fos.write(c);								//пишем в файл
					}
					
					fos.flush();									//чистим буфер
					zis.closeEntry();								//закарывает zip entry, для чтения следующего zip entry
					fos.close();
			}
		}catch(IOException e) {
			e.getMessage();
		}

	}

}
