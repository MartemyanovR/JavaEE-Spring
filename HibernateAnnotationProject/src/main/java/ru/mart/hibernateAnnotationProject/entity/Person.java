package ru.mart.hibernateAnnotationProject.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="BIRTHDAY")
	private Date birthDay;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "PERSON_CAR" , joinColumns =@JoinColumn(columnDefinition = "PERSON_ID"),
						inverseJoinColumns = @JoinColumn(columnDefinition = "CAR_ID"))
	private Set<Car> cars;
	
	public Person() {	}

	public Long getId() {return id;	}

	public void setId(Long id) {this.id = id;	}

	public String getFirstName() {return firstName;	}

	public void setFirstName(String firstName) {this.firstName = firstName;	}

	public String getLastName() {return lastName;}

	public void setLastName(String lastName) {this.lastName = lastName;	}

	public Date getBirthDay() {	return birthDay;	}

	public void setBirthDay(Date birthDay) {this.birthDay = birthDay;	}

	public Address getAddress() {return address;}

	public void setAddress(Address address) {this.address = address;	}

	public Set<Car> getCars() {	return cars;}

	public void setCars(Set<Car> cars) {this.cars = cars;	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", latsName=" + lastName + ", birthDay=" + birthDay
				+ ", address=" + address + "]";
	}	

}
