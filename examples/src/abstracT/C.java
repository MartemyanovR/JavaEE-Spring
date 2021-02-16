package abstracT;

import interfaces.MyInter;

public class C extends Sub_B implements MyInter {

	@Override
	public void prt2() {
		System.out.println("метод интерфейса MyInter");
		
	}

	@Override
	public void emptyMethod() {
		System.out.println("Sub_B class method ");
		
	}

	

}
