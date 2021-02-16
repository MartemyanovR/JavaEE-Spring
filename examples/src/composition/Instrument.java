package composition;

public class Instrument {
	public String name;
	
	public void play() {
		System.out.println("Balalayka");
		System.out.println(name);
	}
	
	private void play1() {
		System.out.println("Gitar");
	}	
	
	public void play2() {
		
		System.out.println(name);
	}
	
	public static void tune(Instrument i) {
		i.play();
		i.play1();
	}
	public void tune1(Instrument i) {
		i.play();
		i.play1();
	}
}
