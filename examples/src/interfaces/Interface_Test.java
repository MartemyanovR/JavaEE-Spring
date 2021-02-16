package interfaces;

public class Interface_Test {
	
	public static void main (String[] args) {
		Interface_B  ib = new Interface_Class();
		ib.print();
		
		Interface_Class  ic = new Interface_Class();
		ic.print();
		ic.meth();
		
	}

}
