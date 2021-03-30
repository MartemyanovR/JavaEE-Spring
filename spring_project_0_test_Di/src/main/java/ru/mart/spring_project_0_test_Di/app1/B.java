package ru.mart.spring_project_0_test_Di.app1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class B implements I2{
	
	private I a;
	
//	@Autowired
	public void setA(I a) {
		this.a = a;
	}
	
	{
		System.out.println("Init block B.class");
	}

	public String tolking(int i) {
		System.out.println("method tolking");
		return a.speaking(i);
	}
	
//	@PostConstruct
//	private void init() {
//		System.out.println("Init");
//	}
//	
//	@PreDestroy
//	private void destroy() {
//		System.out.println("destroy");
//	}

	public I getA() {
		return a;
	}

	@Override
	public void methI2() {	
		System.out.println("realization merthI2");
	}
}
