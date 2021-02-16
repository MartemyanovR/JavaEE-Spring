package io.pathFiles;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsTest {

	public static void main(String[] args) {
		Path paths = Paths.get("C:\\eclipse-workspace\\");
		System.out.println(paths.getFileName());
		System.out.println(paths.startsWith("C:\\"));
		System.out.println(paths.endsWith("C:\\eclipse-workspace"));		
		System.out.println(paths.isAbsolute());
		
		Path paths2 = Paths.get("C:\\eclipse-workspace\\..\\README.txt");
		System.out.println(paths2.normalize());
		Path path3 = Paths.get("\\Test1\\src\\arrays");
		paths2 = paths.resolve(path3);
		System.out.println(paths2.normalize());
		
	}

}
