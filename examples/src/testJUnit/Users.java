package testJUnit;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Users {
	private int id;
	private String name;
	private int age;
	private Sex sex;

	private static Map <Integer,Users> allUsers;
	
	private static int countId = 0;
	
	public Users ( String name , int age, Sex sex) {
		if (allUsers == null) {
			allUsers = new HashMap<>();
		}
		
		this.name = name;
		this.age = age;
		this.sex = sex;
		
		if (!hasUser()) {
			countId++;
			this.id = countId;			
			allUsers.put(id, this);
		}
	}
	 private boolean hasUser() {			// метод проверки дубликатов в мапе
		 for (Users user : allUsers.values()) {
			 if(user.equals(this) && user.hashCode() == this.hashCode()) {
				 return true;
			 }
		 }
		 return false;
	 }
	 

 	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		Users user = (Users) obj;
		return this.age == user.age && Objects.equals(name, user.name) && Objects.equals(sex, user.sex);
	}
	
	
}
