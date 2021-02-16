package classAndClassLoader;

public class TestLoader {
	public static void main(String[] args) throws ClassNotFoundException {

		ClassTestLoader ctl = new ClassTestLoader();
		LoaderB1 lb1 = new LoaderB1();
		LoaderB2 lb2 = new LoaderB2();
		
		Class<?> c1 = ctl.loadClass("classAndClassLoader.Rabbit");
		Class<?> c2 = lb1.loadClass("classAndClassLoader.Rabbit");
		Class<?> c3 = lb2.loadClass("classAndClassLoader.Rabbit");
		System.out.println(c1==c2);  //true  тк дочерний загрузчик использует тот же загрузчик что и родительский
		System.out.println(c3==c2);   //true, тк базовый загрузчик у  всех один загрузчик 
		
	}

}
