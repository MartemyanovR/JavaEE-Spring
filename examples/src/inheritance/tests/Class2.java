package inheritance.tests;

public class Class2 extends Class1{
	
	public Class2(double d) {		
		this((int)d);		//пи указании this, супер класс не вызывается!!!
		System.out.println("Class2_D");
	}
	
	public Class2(int i) {
		super(1);
		System.out.println("Class2_i");
	}

}
