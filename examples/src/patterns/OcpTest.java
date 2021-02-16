package patterns;

public class OcpTest {
	public static void main(String args[]) {
	OcpCook cookF = new OcpFood();
	OcpCook cookB = new OcpBurg();
	OcpCook cookI = new OcpIcecream();
	
	cookF.methCook();
	
	methCookStart(cookF);
	methCookStart(cookB);
	methCookStart(cookI);
	
	
	}
	static void methCookStart(OcpCook cook) {
		cook.methCook();
		
	}
}
