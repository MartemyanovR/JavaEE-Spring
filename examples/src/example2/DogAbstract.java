package example2;
public abstract class DogAbstract {
	int volume;
	
	public  abstract  void voice ();
	
	protected void color(String col) {
		System.out.println("Color is " + col);
	}

}
