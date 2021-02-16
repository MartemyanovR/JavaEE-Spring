package io.serializable;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String name;
    private int age;
    public transient double height;
    private transient boolean married;
    public static byte CONSTANT = 5;
      
    Person(String n, int a, double h, boolean m){
          
        name=n;
        age=a;
        height=h;
        married=m;
    }
    String getName() {return name;}
    int getAge(){ return age;}
    double getHeight(){return height;}
    boolean getMarried(){return married;}

}
