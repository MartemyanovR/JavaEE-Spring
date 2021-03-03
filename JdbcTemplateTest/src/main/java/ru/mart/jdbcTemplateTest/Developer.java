package ru.mart.jdbcTemplateTest;

public class Developer {
	private Integer id;
    private String name;
	private String specialty;
	private Integer experience;
	
	public Developer() { } 	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}	

	@Override
	public String toString() {
		return "Developer [id=" + id + ", name=" + name + ", specialty=" + specialty + ", experience=" + experience
				+ "]";
	}

}
