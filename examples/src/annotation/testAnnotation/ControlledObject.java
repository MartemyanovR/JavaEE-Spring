package annotation.testAnnotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(value = RUNTIME)
public @interface ControlledObject {

	String name();
}
