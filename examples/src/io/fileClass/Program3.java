package io.fileClass;

import java.io.File;
import java.io.IOException;

public class Program3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 // определяем объект для каталога
        File myFile = new File("C://eclipse-workspace//NewDirRenamed//notes.txt");
        System.out.println("File name: " + myFile.getName());
        System.out.println("Parent folder: " + myFile.getParent());
        //если файл существует, он не пересоздается
        boolean createDir = myFile.createNewFile();
        if(createDir) {
        	System.out.println("File created");
        }
        if(myFile.exists())
            System.out.println("File exists");
        else
            System.out.println("File not found");
         
        System.out.println("File size: " + myFile.length());
        if(myFile.canRead())
            System.out.println("File can be read");
        else
            System.out.println("File can not be read");
         
        if(myFile.canWrite())
            System.out.println("File can be written");
        else
            System.out.println("File can not be written");
         
        // создадим новый файл
        File newFile = new File("C://eclipse-workspace//MyFile");
        try
        {
            boolean created = newFile.createNewFile();
            if(created)
                System.out.println("File has been created");
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }  
        boolean deleter = newFile.delete();
        if(deleter) {
        	System.out.println("File has been deleted");
        }
	}

}
