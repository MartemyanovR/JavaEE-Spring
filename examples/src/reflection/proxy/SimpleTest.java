package reflection.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SimpleTest {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SimpleClassRabbit scr = new SimpleClassRabbit();
		Class<?> clazz = SimpleClassRabbit.class;
		Method [] meth = clazz.getDeclaredMethods();
		
		for(Method m : meth) {
			System.out.println(m.getName());
			if(m.getName().equals("methPriv"))
				//второй параметр это аргументы метода
				m.invoke(scr, "Some string");
			else
				m.invoke(scr);
		}
		
		
	}
	

}
