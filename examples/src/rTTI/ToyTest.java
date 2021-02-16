package rTTI;

public class ToyTest {
	static void printInfo(Class cc) {
		System.out.println("Class name " + cc.getName() + 
				" is an interface " + cc.isInterface());
		System.out.println("Simple name " + cc.getSimpleName());
	}

	public static void main(String[] args) {
		Class c = null;	
		try {
			c = Class.forName("rTTI.ToyFancy");
		} catch(ClassNotFoundException e) {
			System.out.println("Not found class FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for(Class face: c.getInterfaces()) {
			printInfo(face);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance(); //если в классе отсутствует конструктор без аргументов, генерируется исключение
		} catch(InstantiationException e) { System.out.println("Failed to creat instance");
			System.exit(1);
		} catch(IllegalAccessException e) { System.out.println("Denied access");
		System.exit(1);
		}
		printInfo(obj.getClass());
	}

}
