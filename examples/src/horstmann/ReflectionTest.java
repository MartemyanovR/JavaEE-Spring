package horstmann;

import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectionTest {

	public static void main(String[] args) {
			String name;
			if (args.length > 0) name = args[0];
			else
			{
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter class name (e.g. horstmann.TalkingClock.TimePrinter)");
				name = scan.next();
			}			
			try {				
				// вывести имя класса и супер класса (if != Object)
				Class cl = Class.forName(name);
				Class supercl = cl.getSuperclass();
				int getM = cl.getModifiers();
				//System.out.println(getM);
				String modifiers = Modifier.toString(getM);
				if(modifiers.length() > 0) 
					System.out.print(modifiers + " ");
				System.out.print("Class " + name);
				if(supercl != null && supercl != Object.class)
					System.out.print(" extends " + supercl.getName());
					
				System.out.print("\n{\n");
				printConstructors(cl);
				System.out.println();
				printMethods(cl);
				System.out.println();
				printFields(cl);
				System.out.println("}");
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.exit(0);
	}
	// выводит все конструкторы класса
	
	public static void printConstructors(Class cl) {
		Constructor[] constructors = cl.getDeclaredConstructors();
		//cl.getConstructors();
		//System.out.println(constructors[1].getName());
		for (Constructor c : constructors) {
			String name = c.getName();
			System.out.print(" ");
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length()>0) 
				System.out.print(modifiers + " ");
			System.out.print(name + "(");
			
			Class<?>[] paramTypes = c.getParameterTypes();
			for(int j=0; j<paramTypes.length;j++) {
				if (j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	// выводит все методы класса
	public static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();
		for(Method m: methods) {
			String name = m.getName();
			Class<?> retType = m.getReturnType();
			System.out.print(" ");
			//вывести модификаторы, возвращаемый тип и имя метода
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0) 
				System.out.print (modifiers + " ");
			System.out.print(retType.getName() + " " + name + "(");
			
			Class<?>[] paramTypes = m.getParameterTypes();
			for(int j=0; j<paramTypes.length; j++) {
				if (j>0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	public static void printFields(Class cl) {		//выводит все поля класса
			
		Field[] fields = cl.getDeclaredFields();
			for (Field f: fields) {
			String name = f.getName();
			Class type = f.getType();
			System.out.print(" ");
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(type.getName() + " " + name + " ");
			if (type.getName().toString() == "java.lang.String") {
				try {
					f.setAccessible(true);
					String fieldValue = (String)f.get(cl);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				System.out.println(" " + f);
			}
			
		}
	}
		
	
	}


