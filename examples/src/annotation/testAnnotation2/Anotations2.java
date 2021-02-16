package annotation.testAnnotation2;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;

@Inherited
@Retention(RUNTIME)
public @interface Anotations2 {
	String title();
    int version() default 1;
    String text();

}
