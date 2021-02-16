package polimorphism;

public class C extends B {
	
	public void meth()  throws ClassNotFoundException{
		super.meth();
		System.out.println("ClassC");
	}

}
