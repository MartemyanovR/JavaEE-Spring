package reflection.proxy.javaRush;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		//original object
		Man man = new Man("Bob", 41, "NY", "USA");
		//construction wrapper, в парамметрах объект который необходимо перехватить
		InvocationHandler handler = new PersonInvocationHandler(man);
		//get loader
		ClassLoader loader = man.getClass().getClassLoader();
		//get Interface
		Class<?>[] interfaces = man.getClass().getInterfaces();
		//create proxy our object type Interface "Person"
		Person proxyBob = (Person)Proxy.newProxyInstance(loader, interfaces, handler);
		//Вызываем у прокси объекта один из методов нашего оригинального объекта
		//при вызове данного метода, автоматически ввызывается invoke из нашего обработчика(PersonInvocationHandler)
		//получающий обьект класса и парамметры вызова
		proxyBob.introduce("!!!!!!!!!!");
		proxyBob.sayAge(man.getAge());	
		
		
	}

}
