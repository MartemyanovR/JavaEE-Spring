package classAndClassLoader.jarTest;

public class SubClass extends SuperClass {
	private String name;

	public SubClass() {				
	}
	
	
	public class Inner {
		private String lastN;
		
		Inner(String name,String lastN) {
			SubClass.this.name = name; 	
			this.lastN = lastN;
			System.out.println("Object created " + name + " " + lastN);
		}
		
	}

}
