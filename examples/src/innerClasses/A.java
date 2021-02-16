package innerClasses;

public class A {
	
	private String str = "Outer";
	
	public A() {
		//new B();
		System.out.println("Exit");
	}
	
	A meth(A a) {
		return meth(a);
	}
	
	class B extends A {
		public void printStr() {
			System.out.println(super.str);
		}
		//@Override
		B meth (int a) {
			return new B();
		}
	}

	public static void main(String[] args) {
		A a  = new A();
		a.meth(a);
	/*	B b = a.new B();
		b.printStr();*/
}

}
