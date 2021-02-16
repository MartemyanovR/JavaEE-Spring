package io.Input;

import java.io.FileInputStream;
import java.io.IOException;

public class OldClose {
	 public static void main(String[] args) {
         /*
          * Поскольку при открытии или считывании файла может произойти ошибка ввода-вывода,
          *  то код считывания помещается в блок try. И чтобы быть уверенным, что поток в 
          *  любом случае закроется, даже если при работе с ним возникнет ошибка, 
          *  вызов метода close() помещается в блок finally. И, так как метод close() 
          *  также в случае ошибки может генерировать исключение IOException, то его вызов 
          *  также помещается во вложенный блок try..catch
          */
	        FileInputStream fin=null;
	        try
	        {
	            fin = new FileInputStream("C://SomeDir//notes.txt");
	             
	            int i=-1;
	            while((i=fin.read())!=-1){
	             
	                System.out.print((char)i);
	            }
	        }
	        catch(IOException ex){
	             
	            System.out.println(ex.getMessage());
	        } 
	        finally{
	             
	            try{
	             
	                if(fin!=null)
	                    fin.close();
	            }
	            catch(IOException ex){
	             
	                System.out.println(ex.getMessage());
	            }
	        }  
	    } 

}
