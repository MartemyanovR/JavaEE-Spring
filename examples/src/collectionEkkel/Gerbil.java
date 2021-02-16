package collectionEkkel;

public class Gerbil {
	private final int gerbilNumber;
	
	public Gerbil(int gerbilNumber) {
		this.gerbilNumber = gerbilNumber;
	}
	
	public void hop() {
		System.out.println("Method hop()" + gerbilNumber);
	}
}
