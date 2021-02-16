package clone;

public class ConstructorCloneMain {

	public static void main(String[] args) {
		ConstructorCloneUser u1 = new ConstructorCloneUser(1, "Name 1", new ConstructorCloneAddress("street 1", 1), 0.1d);
		 
		ConstructorCloneUser u2 = new ConstructorCloneUser(u1);
		 
		u2.setId(2);
		u2.getAddress().setHouse(32);
		System.out.println(u1);
		System.out.println(u2);

	}
}
