package example;

public class OuterInnerClass {
	private String a;
	static final int KEY = 0;
	
	public static void outerMethod() {
		System.out.println("Outer class static Method");
	}
	private void privateOuterMethod() {
		System.out.println("Outer class private method");
	}
	
	class Inner extends Just {				//внутренний класс
		// public static int b;				// нельзя указывать статик переменные и методы во внутреннем классе
		private String a_Inner;
		public Inner(String a_in) {
			super("SuperConstruction");
			System.out.println("Inner class");
			a_Inner = a_in;
		}
		public void outer() {
			OuterInnerClass.outerMethod();
			privateOuterMethod();
		}
	
	}
}