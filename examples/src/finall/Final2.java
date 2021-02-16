package finall;

public class Final2 extends Final1{
	
	
	public Final2(final int i) {
		super(i);
	}
	//это не переопределенный а обычный метод
	//@Override - ошибка
	public void f() {
		System.out.println("Final2.f");
	}
	/*//подкласс видит метод финал суперкласса, но переопределить невозможно!!!
	public void g() {
		System.out.println("Final2.g");
	}
	*/
	
	public final void fg() {
		System.out.println("Final2.fg");
	}
	
}
