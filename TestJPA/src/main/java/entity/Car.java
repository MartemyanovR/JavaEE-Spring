package entity;

import java.util.Set;

public class Car {

	private Long id;
	private String mark;
	private String type;
	private Set<Person> persons;
	
	public Car() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}


	@Override
	public String toString() {
		return "Car [id=" + id + ", mark=" + mark + ", type=" + type + "]";
	}

}
