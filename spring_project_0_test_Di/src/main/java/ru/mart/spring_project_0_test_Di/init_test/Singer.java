package ru.mart.spring_project_0_test_Di.init_test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Singer {
	
	private static final String DEFAULT_NAME = "Ivan Ivanov";
	private String name;
	
	private int age;
	
	{
		System.out.println("Block init");		
	}

	public Singer() {
		System.out.println("Empty Constructor initialization");
	}	

	public Singer(String name, int age) {
		super();
		System.out.println("Constructor initialization");
		this.name = name;
		this.age = age;
	}

	public Singer(String name) {
		super();
		this.name = name;
	}
	
	public Singer(int age) {
		super();
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@PostConstruct
	public void init () {
		System.out.println("Initializing bean");
		if (name == null) {
			System.out.println("Using default name");
			name = DEFAULT_NAME;
		}
		if (age < 1) {
			throw new IllegalArgumentException("You must set "
			+ " the age property of any beans of type "
			+ Singer.class);
		}
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("This is method DASTROY!");
	}

	@Override
	public String toString() {
		return "Singer [name=" + name + ", age=" + age + "]";
	}		
}
