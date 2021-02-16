package interfaces;

/**
 * Если реализовывать 2 интерфейса с одинаковыми дефолтными методами,
 *  и не реализовывать их в классе то произоййдет ошибка компиляции,
 *  реализовать 2 метода(с одинаковой сигнатурой) двух интерфейсов так же не получится
 * @author Roman
 */

public class Interface_Class  implements  Interface_A, Interface_B  {
	
	public void print() {
		System.out.println("Implements interfaces");
	}
	 /*@Override
		public void print() {
			// TODO Auto-generated method stub
			Interface_B.super.print();
		}*/

	// Если в интерфейсах есть методы с одининаковыми сигнатурами, но разнымми возвр знач, то ошибка компил
	//исключение при коариантности
	//@Override
	/*
	public Interface_Class meth() {
		super.meth();
		System.out.println("Meth subclass");
		return null;
	}*/
	
	public void meth1() {
		// TODO Auto-generated method stub		
	}


}
