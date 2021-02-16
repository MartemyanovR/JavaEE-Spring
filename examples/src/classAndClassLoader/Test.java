package classAndClassLoader;

public class Test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class<Rabbit> clazz = Rabbit.class;
		Rabbit rabbit = clazz.newInstance();
		System.out.println(rabbit.toString()  + " " + rabbit.hashCode() + "\n");
		foo();
	}
	
	//Dynamic class loading
	public static void foo() throws InstantiationException, IllegalAccessException,ClassNotFoundException {		
		ClassLoader cl = Rabbit.class.getClassLoader();
		System.out.println(cl.toString());
		Class<?> clazz =cl.loadClass("classAndClassLoader.Rabbit");
		Object obj = clazz.newInstance();	
		System.out.println(obj.toString()  + " " + obj.hashCode());
	}

}
