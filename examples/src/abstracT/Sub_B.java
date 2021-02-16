package abstracT;

import interfaces.*;

public abstract class Sub_B extends AbstractClass implements MyInter {
	
	private int val = 6;
	
	//реализует пустой метод из интерфейса, классам наследникам теперь он не обязателен	
	public void prt() {
		System.out.println("переопределенный метод интерфейса MyInter");		
	}
	//public abstract void prt2();

	@Override
	void print() {
		System.out.println(val);		
	}

}
