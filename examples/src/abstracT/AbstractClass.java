package abstracT;

public abstract class AbstractClass  extends AbstractTest{
	
	
	public AbstractClass() {
		print();
	}
	
	abstract void print();
	
	public abstract  void  emptyMethod();
	
	
	public static void statMeth3(AbstractClass ac) {
		System.out.print("statMeth3___");
		((Sub_A)ac).emptyMethod();		
		ac.emptyMethod();
	}
	//public  void  emptyMethod() {};

}
