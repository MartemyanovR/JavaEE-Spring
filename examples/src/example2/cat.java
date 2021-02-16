package example2;

public class cat implements Animal {
	Animal.Calor calorr;
	static {
		
		System.out.println("Static blok cat.");
		
	}
	
		public cat() {
		System.out.println("Creat new object cat");
	}
	
		public void getCalor(){}
		
	public void eat() {
		System.out.println("Cat food");
	}
	public void walk() {
		System.out.println("Thank you, but i prefer to sleep");
	}
}
