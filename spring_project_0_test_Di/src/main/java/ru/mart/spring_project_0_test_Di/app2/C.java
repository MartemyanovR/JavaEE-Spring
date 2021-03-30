package ru.mart.spring_project_0_test_Di.app2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.AliasFor;

import ru.mart.spring_project_0_test_Di.app1.I2;

@IAlias(name = "C" ,value = "CC")
@Component()
public class C {
	
	private I2 b;
	
	@Autowired
	public void setI2(I2 b) {
		this.b = b;
	}
	
	public void meth() {
		System.out.println("meth class A");
	}

}
