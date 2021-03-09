package ru.mart.testJPA2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="topic_Id")
	private Set<Topic> topics = new HashSet<>();
	
	public Category() {}
	
	public Set<Topic> getTopics() {
		return topics;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
