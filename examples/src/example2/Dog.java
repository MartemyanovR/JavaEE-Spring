package example2;
import static java.lang.Math.random;


public  class Dog implements Animal{
	int age;
	private Animal.Calor calor;
	//private int speed;
	
	public void getCalor(){
		
		calor = new Calor("Red");
		System.out.println(calor.colorM());
	}
	
	 public Dog(int age) {
		this.age = age;
		System.out.println("This is dog");
	}
	
	public void eat() {
		System.out.println("pedigree");
	}
	public static void eatn(String... s) {			
		for(String ss: s) {
			System.out.println(ss);
			
		}
		System.out.println(" pedigree_Static");
	}
	public void walk() {
		System.out.println("i  like to run");
	}
	
	public Long getAge() {
		return null;
	}
	
	
	
	
	
}
