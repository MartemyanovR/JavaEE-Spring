package polimorphism;

public class Mill {
	
	public Grain process() {
		System.out.println("G");
		return new Grain();
	}

}
