package io.fileClass;

// Программа суммирует размер выбранных файлов.

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
	
	public static long summator(File file) {
		 long sum = 0;
		File[] fileArr = file.listFiles();
		for(File f : fileArr) {
			if (f.exists() && f.isFile())
				sum += f.length();			
		}
		return sum;
	}
		public static void main(String[] args) {
		File path = new File("C://eclipse-workspace//");
		String[] list;
		long sum = 0;
		if(args.length == 0) 
			list = path.list();
		else
			list = path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(args[0]);
				public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
				}
			});
	
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem: list) {
			File f = new File("C://eclipse-workspace//" + dirItem);
			if (f.exists() && f.isFile())
				sum+= f.length();
			System.out.println(dirItem);
		}
		System.out.println("Size files- " + sum + " byte.");
		
	}
}
