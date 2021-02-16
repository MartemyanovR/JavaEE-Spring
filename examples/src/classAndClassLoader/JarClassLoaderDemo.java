package classAndClassLoader;

import java.io.IOException;
import java.util.jar.JarFile;

import classAndClassLoader.jarTest.MainClass;

public class JarClassLoaderDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		JarClassLoader jcl = 
				new JarClassLoader(
						"C:\\eclipse-workspace\\Test1\\bin\\jarTest.jar", "classAndClassLoader.jarTest");
/*		Class<?> clazz = jcl.loadClass("MainClass.class");
		MainClass mc =(MainClass) clazz.newInstance();	*/
		
	/*	
		JarFile jf = new JarFile("C:\\eclipse-workspace\\Test1\\bin\\classAndClassLoader\\jarTest.jar");
		System.out.println(jf.getName());*/

	}

}
