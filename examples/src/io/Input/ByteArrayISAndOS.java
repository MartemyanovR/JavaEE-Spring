package io.Input;

import java.io.ByteArrayInputStream;

public class ByteArrayISAndOS {

	public static void main(String[] args) {
		byte[] b = {25,44,78,49,123,1};
		byte[] b1 = {66,78,69,91,73,88};
		byte[] b2 = new byte[5];
		
		//создаем новый входной поток массив байтов
		ByteArrayInputStream bais = new ByteArrayInputStream(b);	
		
		int i = -1;
		//считывает побайтно
		while((i = bais.read()) != -1)
			System.out.print(i + " ");
		System.out.println();
		
		String text = "Hello world!";
		//преобразуем строку   массив байт
        byte[] array2 = text.getBytes();
        // считываем 5 символов
        ByteArrayInputStream byteStream2 = new ByteArrayInputStream(array2, 3, 5);
        int c;
        while((c=byteStream2.read())!=-1){
        	System.out.print(c);
            System.out.print((char)c);
        }
        System.out.println();
      
        
        ByteArrayInputStream bais2 = new ByteArrayInputStream(b1);
        //данный метод записывает в массив в2 с байтового потока bais2
       int i2 =  bais2.read(b2, 3, 2);
       System.out.println(i2);
       //при считывании не с первого элемента, в массив в2 записываются 0 
       for(byte bb: b2) {
    	   char ch = (char) bb;
    	   System.out.print(bb + " ");
       }
	}

}
