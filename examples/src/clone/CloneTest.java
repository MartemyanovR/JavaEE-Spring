package clone;

public class CloneTest {
	
	final Integer i;
	
	public CloneTest(int i) {
		this.i = i;
	}
	
	@Override
	protected final Object clone() throws CloneNotSupportedException {
	
	throw new CloneNotSupportedException();
	
	}
	


}
