package interfaces;

public interface Interface_C extends Interface_A, Interface_B {
	//если в интерфейсах или родительских классах (рализованных подклассом) используются одинаковые
	//методы но с разными возвращающими значениями, то переопределить такой метод невозможно
	void print();
	

}
