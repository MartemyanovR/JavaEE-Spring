package ru.mart.spring_project_0_test_Di.app1;

import org.springframework.stereotype.Component;

@Component()
public class A implements I{

	{
		System.out.println("init block A");
	}
		
	@Override
	public String speaking(Integer s) {
		return String.valueOf(s);
		
	}
}
