package ru.mart.spring_project_0_test_Di.app1;

import org.springframework.stereotype.Component;


public interface I {
	
	String speaking(Integer i);
	
	default void def() {
		System.out.println("default method");
	}
}
