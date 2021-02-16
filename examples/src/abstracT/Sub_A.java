package abstracT;

public class Sub_A extends AbstractClass{
	
	private int val = 5;

	@Override
	void print() {
		System.out.println(val);
		
	}
	
	public  void  emptyMethod() {
		System.out.println("Empty");
	}
	
	public static void statMeth(AbstractClass ac) {		
		ac = new Sub_A();
		((Sub_A)ac).emptyMethod();
	}
	
	public static void statMeth2(AbstractClass ac) {		
		Sub_A sa = (Sub_A) ac;
		System.out.print("statMeth2_____");
		sa.emptyMethod();		
		ac.emptyMethod();
	}
	
	
}
