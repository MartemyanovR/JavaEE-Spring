package polimorphism;

public class WheatMill extends Mill{

	public Wheat process() {
	super.process();
		
		return new Wheat();
	}
	public void g() {}
}
