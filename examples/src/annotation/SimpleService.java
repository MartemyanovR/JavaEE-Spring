package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Service(name = "AnnotationSimpleService")
public class SimpleService {
	
	
	@Init
	@Service(name = "AnnotationSimpleServiceMethod", lazyLoad = true)
	public void initService() {
		System.out.println("SimpleMeth");
	}
	
	public ElementType[] getTargetElementTypes(Target target) {
		  if (target == null) {
		    return ElementType.values();
		  }
		  return target.value();
		}

}
