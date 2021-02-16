package horstmann;
import example2.Pug;
import java.lang.reflect.*;

public class ReflectionTestPrivateAccess {

	public static void main(String[] args) {
		Pug p = new Pug (3) ;		
		String className = "example2.Pug";
				
		try {			
			Class<?> cl = Class.forName(className);
			Constructor<?>[] constr = cl.getDeclaredConstructors();
			for (Constructor<?> c : constr) {
				System.out.println(c.getName() + "?");
				Object t = c.newInstance(8);
				Class[] par = c.getParameterTypes();
				System.out.println(par[0].getName());
				/*Pug pug = (Pug) t;
				Field reflectField2 = Pug.class.getDeclaredField("s");
				reflectField2.setAccessible(true);
				String fieldValue2 = (String) reflectField2.get(pug);
				System.out.println(fieldValue2);*/
			}
			//Object op = Class.forName(className).newInstance();
			//System.out.println(op.toString());
		Field reflectField = Pug.class.getDeclaredField("s");
		
		reflectField.setAccessible(true);
		
		String fieldValue = (String) reflectField.get(p);
		System.out.println(reflectField);
		System.out.println(fieldValue);

		}
		catch (ClassNotFoundException ie) {
			ie.printStackTrace();
		}
		catch (InvocationTargetException ie) {
			ie.printStackTrace();
		}
		catch ( InstantiationException ie) {
			ie.printStackTrace();
		}
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException ex) {
			ex.printStackTrace();
		}
	}
}
