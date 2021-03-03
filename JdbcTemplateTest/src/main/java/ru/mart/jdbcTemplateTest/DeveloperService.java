package ru.mart.jdbcTemplateTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeveloperService implements DeveloperDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public DeveloperService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void createDeveloper(String name, String specialty, Integer experience) {
		String sql = "INSERT INTO Developers (name, specialty, experience) VALUES(?,?,?)";
		jdbcTemplate.update(sql, name, specialty, experience);
		System.out.println("Developer successfully created.\nName: " + name + ";\nSpecilaty: " +
                specialty + ";\nExperience: " + experience + "\n");
	}

	@Override
	public Developer getDeveloperById(Integer id) {
		String sql = "SELECT * FROM Developers WHERE id = ?";
		Developer developer = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Developer>(Developer.class),
				new Object[] {id});
		return developer;
	}

	@Override
	public void updateDeveloper(Integer id, String name, String specialty, Integer experience) {
		String sql = "UPDATE Developers SET name = ?, specialty = ?, experience = ? where id = ?";
		jdbcTemplate.update(sql, name, specialty, experience, id);
        System.out.println("Developer with id: " + id + " successfully updated.");
	}

	@Override
	public void removeDeveloper(Integer id) {
		String sql = "DELETE FROM Developers where id = ?";
		jdbcTemplate.update(sql,id);
        System.out.println("Developer with id: " + id + " successfully removed");
	}

	@Override
	public List<Developer> listDevelopers() {
		String sql = "SELECT * FROM  Developers ";
		List<Developer> listDeveloper = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Developer>(Developer.class));
		return listDeveloper;
	}
	
	

}
