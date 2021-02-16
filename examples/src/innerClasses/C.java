package innerClasses;

public class C extends A{
	static int i;
	static int j = i;
	public static void printStr() {
	
	 i = new CInterface() {
		public int testMeth() {
			System.out.println("InnerClassMethTEst");
			return 5;
		}
	}.testMeth();
	
	}
	
	public static void main(String[] args) {
		System.out.println(C.class.getClassLoader());
		C.printStr();
		System.out.println(C.i + " " + C.j);
	}
}
