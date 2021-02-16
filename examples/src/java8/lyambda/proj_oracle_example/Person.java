package java8.lyambda.proj_oracle_example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {
	static List<Person> list = new ArrayList<Person>();
	
	public enum Sex {
        MALE, FEMALE
    }
    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
       return 0;
    }

    public void printPerson() {
        System.out.println(name);
    }

	public Sex getGender() {
		
		return gender;
	}

	public static List<Person> createRoster() {		
		list.add(new Person());
		return list;
	}

	public String getEmailAddress() {
		// TODO Auto-generated method stub
		return null;
	}

}
