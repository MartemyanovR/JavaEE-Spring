package io.pathFiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilesAndStream {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("C:\\eclipse-workspace");
        final int maxDepth = 10;
        //поиск по предикату в файловой системе
    //    Stream<Path> matches = Files.find(p,maxDepth,(path, basicFileAttributes) -> String.valueOf(path).endsWith(".txt"));
   //     matches.map(path -> path.getFileName()).forEach(System.out::println);
       
        //lines читает данные файла
        Path p2 = Paths.get("C:\\eclipse-workspace\\StringSub.txt");
        Files.lines(p2).forEach(System.out::print);
        
        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(p2))) {
        		IntStream.range(0, 30).mapToObj(String::valueOf).forEach(pw::println); }
        
        Files.walk(p, 1).forEach(System.out::println);  //проходим по уровням влложености
        
	}
	
}
