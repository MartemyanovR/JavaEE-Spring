package io.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Singleton implements Serializable {

	private static final long serialVersionUID = 1L;
	//если финал, то ошибка в присваивании this
	private static  Singleton instance = new Singleton();
	private int i;

	public static Singleton getInstance() {
	    return instance;
	}	
	
	private Singleton() {
	}	
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
	    ois.defaultReadObject();
	    //если задокументировать этот код, то получаем текущее состояние объекта
	    instance = this;
	}	
	
	private Object readResolve()  {
	    return instance;
	}	
	
	public static void main(String[] args) throws Throwable {
	
	    Singleton s = Singleton.getInstance();
	    s.i = 5;
	
	    ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	    ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
	    oos.writeObject(getInstance());
	    oos.close();
	
	    s.i = 7; //modified after serialization
	
	    InputStream is = new ByteArrayInputStream(baos.toByteArray());
	    ObjectInputStream ois = new ObjectInputStream(is);
	    Singleton deserialized = (Singleton) ois.readObject();
	    System.out.println(deserialized.i);  // prints 5
	}
}