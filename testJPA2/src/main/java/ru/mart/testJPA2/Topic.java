package ru.mart.testJPA2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Topic {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	public Topic() {}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		category.getTopics().add(this);	
		this.category = category;
	}

}
