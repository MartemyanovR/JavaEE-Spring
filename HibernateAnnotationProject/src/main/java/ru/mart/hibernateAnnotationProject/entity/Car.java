package ru.mart.hibernateAnnotationProject.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "MARK")
	private String mark;
	
	@Column(name = "TYPE")
	private String type;
	
	@ManyToMany(mappedBy = "cars")
	private Set<Person> persons;
	
	public Car() {	}

	public Long getId() {return id;	}

	public void setId(Long id) {this.id = id;	}

	public String getMark() {return mark;	}

	public void setMark(String mark) {this.mark = mark;	}

	public String getType() {return type;	}

	public void setType(String type) {this.type = type;	}
	
	public Set<Person> getPersons() {return persons;	}

	public void setPersons(Set<Person> persons) {this.persons = persons;	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", mark=" + mark + ", type=" + type + "]";
	}

}
