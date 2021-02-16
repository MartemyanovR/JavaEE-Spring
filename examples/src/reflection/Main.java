package reflection;

import java.lang.reflect.Constructor;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ReflectEnum re;
		Rabbit r = new Rabbit(1);
		Class cl = Rabbit.class;
		Class cl1 = Integer[].class;
		Class cl2 = int.class;
		Class cl3 = void.class;
		
//		ReflectEnum inst =(ReflectEnum) cl.newInstance(); // runtime error, создать экземпляр перечисления невозможно
//		Integer[] instArr=(Integer[]) cl1.newInstance(); // runtime error, создать экземпляр array невозможно, так же с примитивами и void
		Rabbit r1 =(Rabbit) cl.newInstance();	
		System.out.println(cl.getName());
		
		String strRabbbit = "reflection.Rabbit";
		System.out.println(cl.forName(strRabbbit).newInstance().toString());
		System.out.println("ds".getClass().getSimpleName());
		
	}

}
