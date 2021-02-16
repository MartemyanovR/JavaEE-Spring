package annotation.testAnnotation2;


public final class Sample2 extends Sample implements Cloneable{
	
	
	public static void main(String[] args) {
		new Object().hashCode() ;
	}

	@Override
	protected Sample2 clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Sample2)super.clone();
	}
	
	
	

}
