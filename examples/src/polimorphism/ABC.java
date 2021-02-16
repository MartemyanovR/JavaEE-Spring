package polimorphism;

public class ABC {
	public static void select(A a) throws ClassNotFoundException{
		System.out.println("This A");
		a.meth();
	}
	public static void select(B b) throws ClassNotFoundException {
		System.out.println("This B");
		b.meth();
	}
	public static void select(C c) throws ClassNotFoundException {
		System.out.println("This C");
		c.meth();
	}
	public static void main(String[] args) throws ClassNotFoundException{
		C c = new C();
		A a = new A();
		B b = new B();
		a = b;
		a.meth();
		ABC.select(a);

	}

}
