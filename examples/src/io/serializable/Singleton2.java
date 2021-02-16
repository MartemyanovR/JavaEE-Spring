package io.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Singleton2 implements Serializable {
			
	    public static void main(String[] args) throws IOException, ClassNotFoundException {
	        Singleton instance = Singleton.getInstance();

	        ByteArrayOutputStream byteArrayOutputStream = serializeSingletonInstance(instance);
	        System.out.println("Проверка ourInstance до десериализации: " + instance);
	        instance.i = 5;
	        Singleton singleton = deserializeSingletonInstance(byteArrayOutputStream);
	        Singleton singleton1 = deserializeSingletonInstance(byteArrayOutputStream);

	        System.out.println("Проверка ourInstance : " + singleton.getInstance());
	        System.out.println("Проверка ourInstance : " + singleton1.getInstance());
	        System.out.println("=========================================================");
	        System.out.println("Проверка singleton : " + singleton);
	        System.out.println("Проверка singleton1 : " + singleton1);
	        System.out.println(singleton == singleton1);
	        System.out.println(instance == singleton1);
	    }

	    public static ByteArrayOutputStream serializeSingletonInstance(Singleton instance) throws IOException {
	        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

	        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
	        oos.writeObject(instance);
	        oos.close();

	        return byteArrayOutputStream;
	    }

	    public static Singleton deserializeSingletonInstance(ByteArrayOutputStream byteArrayOutputStream) throws IOException, ClassNotFoundException {
	        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

	        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
	        Singleton singleton = (Singleton) ois.readObject();
	        ois.close();

	        return singleton;
	    }

	    public static class Singleton implements Serializable {
	       
			private static final long serialVersionUID = 1L;
			private static Singleton ourInstance;
			public int i = 0;

	        public static Singleton getInstance() {
	            if (ourInstance == null) {
	                ourInstance = new Singleton();
	            }
	            return ourInstance;
	        }

	        private Singleton() {
	        }
	        
	        // без данного метода сравнении ссылок возвращает false
	        private Object readResolve() {
	            return getInstance();
	        }

			@Override
			public String toString() {
				return "Singleton [i=" + i + "]";
			}
	        
	        
	    }
}


