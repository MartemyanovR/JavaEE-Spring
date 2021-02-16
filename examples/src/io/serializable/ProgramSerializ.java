package io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ProgramSerializ {

	public static void main(String[] args) {
		Person person = new Person("Tom",25,175,false);
		Person p;
		
		try(ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("C://eclipse-workspace//README.txt")) ) {
			oos.writeObject(person);
			oos.flush();
			oos.close();
		}catch(IOException e) {	e.getMessage(); }
		
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C://eclipse-workspace//README.txt")) ) {
			
			 p =(Person) ois.readObject();
			double height =p.height;
			byte b = p.CONSTANT;
			p.CONSTANT = 10;
			 b = p.CONSTANT;  //значение меняется тк у нас есть доступ к классу
			System.out.println(p.getAge() + " " + p.getHeight() + " " + height + " " + p.CONSTANT);
			ois.close();
			
							
		} catch(IOException e) {	e.getMessage(); }
		catch(ClassNotFoundException e) {	e.getMessage(); }		
	
		
	}

}
