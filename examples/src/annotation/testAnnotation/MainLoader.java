package annotation.testAnnotation;

import java.lang.reflect.Method;

public class MainLoader {

	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("annotation.testAnnotation.Cookies");
			
			if(!clazz.isAnnotationPresent(ControlledObject.class)) {
				System.err.println("no annotation");
			} else {
				System.out.println("class annotated " + clazz.getAnnotation(ControlledObject.class));
			}
			boolean hasStart=false;
			boolean hasStop=false; 
			
			Method[] meth = clazz.getDeclaredMethods();
			for(Method m : meth) {
				if(m.isAnnotationPresent(StatrObject.class)) {
					System.out.println(m.getName() +  " there is " + m.getAnnotation(StatrObject.class));
					hasStart = true;}
				if(m.isAnnotationPresent(StopObject.class)) {
					System.out.println(m.getName() +  " there is " + m.getAnnotation(StopObject.class));
					hasStop = true;}
				if(hasStart == hasStop) { break;}				
			}
				System.out.println("Start annotaton  - " + hasStart + ";  Stop annotation  - " + hasStop );
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
