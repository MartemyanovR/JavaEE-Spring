package example2;
import static java.lang.Math.sqrt;				


public class AnimalApp {
	
	private AnimalApp() {				
		System.out.println("Private");
	}

	public static void main(String[] args) {
		int x =(int) sqrt(9);
		Animal animal = new Dog(x);
		
		Animal.Calor ac = new Animal.Calor(null);
		animal.getCalor();
				 
		for (int i = 0; i<201; i++) {
			if (i%2 == 0 && i%3 == 0 && i%4 == 0 && i%5 == 0)
				System.out.println(i);
		}
		
	}


//col = new Dog.Calor("Black");
		
		
		
		/*Animal [] ani = new Animal[2];			
		ani[0] = new Dog(3);
		ani[1] = new cat();
		for (Animal a : ani) {
			System.out.println(a.getClass().getName());	
			}									
		 AnimalApp.privat();			
		Animal animal = new Dog(6);
		Animal animal2 = new cat();
		hi((byte)5);
		animal.eat();
		animal2.eat();	
		Dog.eat("s", "sfs","sfsfs");		
			
		Animal animal = new Dog(x);
		Animal animal1 = new Poodle(3);
	    Poodle p  = new Poodle((int)sqrt(100));
	    System.out.println( p instanceof Dog);
	  
		animal1.eat();
		animal1.walk();		*/
	
	static void hi(int u) {
		System.out.println("1");		
	}
	static void hi (short j) {
		System.out.println("2");
	}
	static void privat () {		
		new AnimalApp();
	}
}
