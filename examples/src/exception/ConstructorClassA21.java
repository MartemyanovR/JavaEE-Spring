package exception;

import exception.MyException;

public class ConstructorClassA21 {
	public ConstructorClassA21() throws MyException {
		throw new MyException(String.format("Exception MyException"));
	}
	public ConstructorClassA21(String s)  {
		System.out.println("constructor with args String: " + s);
	}

}
