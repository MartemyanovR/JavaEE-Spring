package ru.mart.spring_project_0_test_Di.app2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

@Retention(RetentionPolicy.RUNTIME)
public @interface IAlias {

	@AliasFor("value")
	String name() default"";
	
	@AliasFor("name")
	String value() default"";
}
