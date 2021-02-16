package polimorphism;

public class A {
	public void meth()   throws ClassNotFoundException{
		//StackOverflowError
		//this.meth();
		System.out.println("ClassA");
	}
}
