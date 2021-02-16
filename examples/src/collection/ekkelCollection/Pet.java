package collection.ekkelCollection;

public class Pet {
	private static int id = 0;

	public int id() {
		return ++id;
	}
	public static void dischargeId() {
		id = 0;
	}
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public class Dog extends Pet{}
	public class Hamster extends Pet{}
	public class Cat extends Pet{}
	public class GuineaPig extends Pet{}
}
