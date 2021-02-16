package reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler implements InvocationHandler {

	//обработчик вызовов, выводдящий сначала имя метода и его параметры,
	//а затем вызывающий исходный метод
	private Object target;
	
	public TraceHandler(Object t) {
		//t - неявный параметр вызова метода
		this.target = t;
	}

	@Override
	public Object invoke(Object proxy, Method meth, Object[] args) throws Throwable {
		//вывести неявный параметр
		System.out.print(target);
		//вывести имя метода
		System.out.print("." + meth.getName() + "(");
		//вывести явные параметры
		if(args != null) {
			for(int i = 0; i< args.length; i++) {
				System.out.print(args[i]);
				if(i < args.length-1) 
					System.out.println(", ");
			}			
		}
		System.out.println(")");
		
		//вызвать кокретный метод
		return meth.invoke(target, args);
	}
	
	
	
}
