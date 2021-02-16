package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.util.Arrays;

public class AnnotationMain {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		inspectService(SimpleService.class);
		inspectService(LazyService.class);
		inspectService(String.class);
		inspectMethod(SimpleService.class);
		
	}
	
	static void inspectMethod(Class<?> clazz) throws NoSuchMethodException, SecurityException {
		if (clazz.getSimpleName().equals("SimpleService")) {
			System.out.println("!!!");
			Annotation[] annType = clazz.getMethod("initService").getAnnotations();
			for(Annotation annatation : annType) {
			System.out.println(annatation.annotationType());
			}
			System.out.println(Arrays.toString(annType));
		}
	}
	
	static void inspectService(Class<?> service) {
		if(service.isAnnotationPresent(Service.class)){
			Service ann = 
					service.getAnnotation(Service.class);
			System.out.println(ann.name()
					+ " there is " + ann.lazyLoad() + 
			" " + ann.hashCode());
		}
		else
			System.out.println(service.getName()
					+" class not found");		
	}
	
	
}
