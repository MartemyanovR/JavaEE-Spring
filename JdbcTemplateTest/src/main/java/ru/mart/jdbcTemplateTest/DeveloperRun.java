package ru.mart.jdbcTemplateTest;

import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DeveloperRun {

	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SpringConfig.class)) {
		
		 DeveloperService devService = (DeveloperService) context.getBean("devService");	               

	        System.out.println("========Creating new records to DB========");
	        devService.createDeveloper("Tom", "Java Developer", 3);
	        devService.createDeveloper("Petr", "C++ Developer", 2);
	        devService.createDeveloper("DesignerAsya", "UI Developer", 1);

	        System.out.println("========Developers List========");
	        List<Developer> developers = devService.listDevelopers();
	        for (Developer developer : developers) {
	            System.out.println(developer);
	        }

	        System.out.println("========Some changes to DB========");
	        devService.updateDeveloper(12, "DesignerAsya", "UI Developer", 2);
	        devService.removeDeveloper(11);

	        System.out.println("========Final Developers List========");
	        List<Developer> finalDevelopers = devService.listDevelopers();
	        for (Developer developer : finalDevelopers) {
	            System.out.println(developer);
	        }
		}  // context.close();
	}

}
