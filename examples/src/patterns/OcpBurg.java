package patterns;

public class OcpBurg extends OcpFood {
	/*public void getfry() {
		System.out.println("жарим");
	}*/
	
	public void methCook() {
		System.out.println("Бургер:");
		super.getFry();
	}

}
