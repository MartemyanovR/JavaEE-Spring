package polimorphism;

public class B extends A{

	@Override
	public void meth() throws ClassNotFoundException{
		super.meth();
		System.out.println("ClassB");
	}
	
}
