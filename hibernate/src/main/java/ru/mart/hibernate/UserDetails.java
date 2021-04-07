package ru.mart.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "city")
	private String city;

	@OneToOne(mappedBy = "details")   //mappedBy указывает что связь с таблицей User двухсторонняя 
//	@Transient							
	private User user;

	public UserDetails() {
	}

	public UserDetails(String email, String city) {
		super();
		this.email = email;
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getId() {
		return id;
	}
	
	public User getUser() { 
		return user; 
	}
	 
	public void setUser(User user) { 
		this.user = user; 
	}
		
	@Override
	public String toString() {
		return String.format("User Details:[id=%d, email=%s, city=%s]", id, email, city);
	}

}
