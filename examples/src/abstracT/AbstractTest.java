package abstracT;

public class AbstractTest {
	
	public static void main (String[] args) {
		
	//	C c = new  C();
		//c.prt();
		
	// при создании обьекта вызывается метод print с неинициализированной переменной
	AbstractClass sa = new Sub_A();
	sa.print();	
	
	//вызываем статический метод, в котором создаем обьект класса Sub_A,
	//делаем нисходящее преобразование для вызова метода подкласса
	Sub_A.statMeth(sa);
	
	//либо делаем преобразование без создания лишнего метода
	Sub_A.statMeth2(sa);
	
	//либо создаем объект в аргументе метода
	Sub_A.statMeth3(new Sub_A());
	
	
	//можно создать метод statMeth в абстрактном классе, и через него обратиться к методу подкласса
	AbstractClass.statMeth3(new Sub_A());
	
	}
	
		

}
