package io.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public enum SingletonEnum {
	
	INSTANCE;
	
	private SingletonEnum() {
		System.out.println("Here");
	}

	public static class Main {
		
		
		
		public static void main(String[] args) throws IOException, ClassNotFoundException {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(INSTANCE);
			oos.close();
			
			ByteArrayInputStream bai = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bai);
			SingletonEnum serialEnum = (SingletonEnum)ois.readObject();			
			SingletonEnum s = SingletonEnum.INSTANCE;
			System.out.println(s.hashCode());
		    System.out.println(SingletonEnum.INSTANCE.hashCode());
		    System.out.println(serialEnum.hashCode());
		    System.out.println(serialEnum == s);
		}
	}
}
