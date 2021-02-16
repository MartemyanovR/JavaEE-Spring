package io.pathFiles;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileVisitTest extends SimpleFileVisitor<Path>{
	String partOfName;
    String partOfContent;
    List<Path> foundFiles = new ArrayList<>();
    
   /*
    * В данном примере при обходе дерева файлов каждый файл проверяется на предмет одновременного выполнения 2 событий -
    * содержит ли имя файла искомое вхождение, и есть ли в теле файла вхождения требуемой строки.
    */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean containsName = true;
        if(partOfName!=null && !file.getFileName().toString().contains(partOfName))
            containsName = false;

        String content = new String(Files.readAllBytes(file));
        boolean containsContent = true;
        if(partOfContent!=null && !content.contains(partOfContent))
            containsContent = false;

        if(containsName && containsContent)
            foundFiles.add(file);
        
        //Здесь мы просто описываем что должна делать программа после того, как выполнен вход в файл,
        // и все необходимые операции совершены. В нашем случае необходимо продолжать обход дерева, 
        // поэтому мы выбираем вариант CONTINUE.
        return FileVisitResult.CONTINUE;
    }
    
    public static void main(String[] args) throws IOException {
    	Path path = Paths.get("C:\\Users\\Roman\\Downloads\\report (17).csv");
    	FileVisitTest fileVisit = new FileVisitTest();
    	fileVisit.partOfName = "rep";
    	fileVisit.partOfContent = "CITYCODE";
    	boolean contunue = true; 
    	for(int i = 0 ; i< 20; i++)
    		fileVisit.visitFile(path, null);
    			  		
    	
    	for(Path p : fileVisit.foundFiles) {
    		System.out.println(p.getFileName());
    	}
	}

}
