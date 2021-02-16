package testJUnit;

public class UsersTest {

	public static void main(String[] args) {
		boolean b;
		Sex sex = new Sex();
		
		sex.setS("Hello!");
		
		b = sex.getS().equals("Hello!");
		System.out.println(b);
	}

}
