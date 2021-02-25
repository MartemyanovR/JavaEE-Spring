package entity;

import java.sql.Date;
import java.util.Set;

public class Person {
	
	private Long id;
	private String firstName;
	private String lastName;
	private Date birthDay;
	private Address address;
	private Set<Car> cars;
	
	public Person() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", latsName=" + lastName + ", birthDay=" + birthDay
				+ ", address=" + address + "]";
	}
	
	
	

}
