package composition;

public class Two {
	private String t;
	private int age;
	//private One one;
	

	public Two () {
		this.age = age;
		System.out.println("This is Two class");
	}
	
	public Two (int age) {
		this.age = age;
		System.out.println("This is Two class");
	}
	
	public String toString() {
		// отложенная инициализация!!!
		t = "Roman";
		return "name " + t + " age " + age + " One " + new One(); 
	}

	
}
