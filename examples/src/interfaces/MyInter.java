package interfaces;

//интерфейс содержит внутренний интерфейс
public interface MyInter {
	void prt();
	void prt2();
	
	interface MyInner {
		default void myinnerPrt() {
			System.out.println("Default myInnerPrt");
		}
	}

}
