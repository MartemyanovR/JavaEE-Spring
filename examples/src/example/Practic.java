package example;

public class Practic {
	private static final int EX = 5;
	private String name = "Roman";
	
	private int age = 32;

	public String getName() {
		return name;
	}
	
	public String privategetName() {
		return name;
	}
	public static void getEx() {
		System.out.println(EX);
		 String.format("value= $d", EX);
	} 
	public void info() {
		System.out.printf("name: %s , grade: %d", name, age);
		System.out.println();	}

	

}
