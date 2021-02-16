package reflection.proxy.javaRush;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonInvocationHandler implements InvocationHandler {
	
	private Object person;
	
	public PersonInvocationHandler(Object person) {
		this.person = person;
	}	

	@Override
	public Object invoke(Object proxy, Method meth, Object[] arg) throws Throwable {
		System.out.println("Hello!!!");
		//здесь вызывается настоящий метод 
		return meth.invoke(person, arg);
	}

}
