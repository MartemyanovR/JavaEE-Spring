package innerClasses;

public interface InnerClassWithMainMethod {

	void meth();
	
	class InnerMain implements InnerClassWithMainMethod {
		
		public void meth() {
			System.out.println("Start!");
		}
		
		public static void main(String args[]) {
			new InnerClassWithMainMethod.InnerMain().meth();
		}
	}
	
}

/* Start program from commandLine:
C:\eclipse-workspace\Test1>javac -d bin\innerClasses -sourcepath src src\innerClasses\InnerClassWithMainMethod.java

C:\eclipse-workspace\Test1>java -cp bin innerClasses.InnerClassWithMainMethod
Error: Could not find or load main class innerClasses.InnerClassWithMainMethod

C:\eclipse-workspace\Test1>java -cp bin innerClasses.InnerClassWithMainMethod$InnerMain
Error: Could not find or load main class innerClasses.InnerClassWithMainMethod$InnerMain

C:\eclipse-workspace\Test1>java -cp bin\innerClasses innerClasses.InnerClassWithMainMethod$InnerMain
Start!
 */




