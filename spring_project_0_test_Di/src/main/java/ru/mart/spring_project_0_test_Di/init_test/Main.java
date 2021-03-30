package ru.mart.spring_project_0_test_Di.init_test;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("ru.mart.spring_project_0_test_Di.init_test");
		ctx.refresh();
		
//		getBean("oneSinger", ctx);
		getBean("twoSinger", ctx);
//		getBean("threeSinger", ctx);
//		getBean("fourSinger", ctx);
		
		//ctx.close();
		ctx.registerShutdownHook();
	}
		
	public static Singer getBean(String beanName, ApplicationContext context) {
		try {
			Singer bean = (Singer) context.getBean(beanName);
			System.out.println(bean);
			return bean;
		} catch(BeanCreationException e) {
			System.out.println("An error occured in bean "
					+ "configuration: "+ e.getMessage());
			return null;
		}
			
	}		

}
