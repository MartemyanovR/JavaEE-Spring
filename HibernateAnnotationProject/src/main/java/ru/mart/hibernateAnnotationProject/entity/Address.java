package ru.mart.hibernateAnnotationProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="POSTCODE", length = 10)
	private Integer postCode;
	
	public Address() {	}

	public Long getId() {return id;	}

	public void setId(Long id) {this.id = id;}

	public String getCountry() {return country;	}

	public void setCountry(String country) {this.country = country;	}

	public String getCity() {return city;	}

	public void setCity(String city) {this.city = city;	}

	public String getStreet() {return street;	}

	public void setStreet(String street) {this.street = street;	}

	public Integer getPostCode() {return postCode;	}

	public void setPostCode(Integer postCode) {this.postCode = postCode;	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", country=" + country + ", city=" + city + ", street=" + street + ", postCode="
				+ postCode + "]";
	}
	
	
	

}
