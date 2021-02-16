package interfaces;


// класс содержит внутренние интерфейсы и класс
public class AOut {
	interface Aint1 {
		default void aintPrint1() {
			System.out.println("Default aintPrint1");
		}
		static void aintPrt2() {
			System.out.println("Static aintPrt2");
		}
	}
	private interface Apriv {
		default void privPrt() {
			System.out.println("Default privPrt()");
		}
	}
	protected interface Aprod {
		void protPrt();
	}
	
	//внутренний класс Аа реализует Apriv
	class Aa implements Apriv {
			}
	
	private class Aaa implements Aprod{
		public void protPrt() {
			System.out.println("Method protPrt from the Aprod");
		}
	}
	// метод класса A  использующий внутренний класс Аа
	void Aaprint() {
		Aa aa = new Aa();
		aa.privPrt();
	}
	void Aaaprint() {
		Aaa aaa = new Aaa();
		aaa.protPrt();
	}
	
}
