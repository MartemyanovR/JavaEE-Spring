package io.pathFiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FilesTest {

	

	public static void main(String[] args) throws IOException, URISyntaxException {
	
		byte[] b = {32,76,56,45,120,11,90};
		ByteArrayInputStream is = new ByteArrayInputStream(b);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		Path testFile = Paths.get("C:\\eclipse-workspace\\Test1\\FFF.txt");
		if(!Files.exists(testFile)) {
			System.out.println("delete");
			Files.deleteIfExists(testFile);
		}
		Path target = Paths.get("C:\\eclipse-workspace\\FFF.txt");
		
		//возвращаем масссив байт из файла
		String message = new String(Files.readAllBytes(
				Paths.get(ClassLoader.getSystemResource("C:\\eclipse-ee\\readme.txt").toURI())));
		System.out.println(message);
		
		/*		
	//	Files.move(testFile, target, REPLACE_EXISTING);
	//	Files.copy(testFile, target);
		//копируем данные из входного потока в файл (файл создаеется атоматически) 
		Files.copy(is, target);
		//копируем данные из файла в выходной поток
		Files.copy(target,os);
		byte[] bOut = os.toByteArray();
		for(Byte b1 : bOut) {
			System.out.print(b1 + ", ");
		}
		
		byte[] bOut = Files.readAllBytes(target);
		for(Byte b1 : bOut) {
			System.out.print(b1 + ", ");
		}*/
		
		
	}

}
