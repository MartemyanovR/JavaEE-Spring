package reference;

public class Weak {
	private String s;
	
	public Weak(String s) {
		this.s = s;
	}
	
	@Override
	public String toString() {
		return Weak.class.getName() + " " + s;
	}

}
