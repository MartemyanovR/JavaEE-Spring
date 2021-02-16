package classAndClassLoader.jarTest;

public class MainClass {

	public static void main(String[] args) {
		SuperClass sup = new SuperClass();
		SubClass.Inner sc = new SubClass().new Inner("Tom","Baden");
		System.out.println(MainClass.class.getName());

	}

}
