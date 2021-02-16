package inheritance;

public class DowncastTest {
	public static void main(String[] args) {
		DowncastParrent parent = new DownCastChild();
		DownCastChild child = new DownCastChild();
		if(child instanceof DowncastParrent) {
			child =(DownCastChild) parent;
			System.out.println("!!!");
		}
	
	}
}
