package ru.mart.spring_project_0_test_Di.conf;

import java.util.Arrays;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.mart.spring_project_0_test_Di.app1.B;
import ru.mart.spring_project_0_test_Di.app2.C;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("ru.mart.spring_project_0_test_Di");
		context.refresh();

		// Возвращает экземпляры bean-компонентов, которые соответствуют заданному типу
		// объекта (включая подклассы)
		Map<String, C> beans = context.getBeansOfType(C.class);
		beans.entrySet().stream().forEach(b -> System.out.println("ID " + b.getKey() + 
									"\nAlias: " + Arrays.toString(context.getAliases(b.getKey()))));  //get list aliasses
		
		//contact through alias
		 C c= (C)context.getBean("c");
		 c.meth();
		 

		/*
		 * String s = System.out.println(s); c.getA().def();
		 */
		context.close();
	}

}
