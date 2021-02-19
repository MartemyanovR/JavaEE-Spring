package springCrud.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import config.ConnectionDB;
import springCrud.dao.PersonSQLDAO;
import springCrud.models.Person;

public class PersonService implements PersonSQLDAO {
	private static int COUNT_PERSON = 0;
	private static int tableCount = 0;
	private String tablePerson = "person"; 
	private static final Logger log = Logger.getLogger(PersonService.class);
	private ConnectionDB connectDB;
	
	public PersonService() {
		if(tableCount == 0) {
			addTable();
		}
	}
	
	@Override
	public void firstPerson() {
		String sql = "INSERT INTO person (id, name,surname,age,email) " +
				"VALUES (" + (++COUNT_PERSON) +", Ivan, Ivanov, 34, ivanov@mail.ru)";
		try(Connection connect = connectDB.getConnection(); 
			Statement statement = connect.createStatement()) {
			statement.executeUpdate(sql);
		} catch(SQLException e) {
		log.error("Added database error", e);
		}		
	}	
	
	@Override
	public void addTable() {
		String sql = "CREATE TABLE person (id INTEGER NOT NULL," + 
					" name VARCHAR(15)," + " surname VARCHAR(20)," + 
						" age INTEGER NOT NULL," +" email VARCHAR(30)";
		try(Connection connect = connectDB.getConnection(); 
			Statement statement = connect.createStatement()) {
			DatabaseMetaData dbm = connect.getMetaData();
			try (ResultSet tables = dbm.getTables(null, null, tablePerson, null)) {
				if(tables.next()) {
					log.error("The base has been already created ");
					return;
				} else {				
					statement.executeUpdate(sql);
					tableCount++;
				}
			}	
			System.out.println("Table successfully created...");			
		} catch (SQLException e) {		
			log.error("Creation database error", e);
		}
		
	}

	@Override
	public void add(Person person) {
		String sql = "INSERT INTO person (id, name,surname,age,email) " +
									"VALUES (?,?,?,?,?)";
		try(Connection connect = connectDB.getConnection();
			PreparedStatement prepareStatement = connect.prepareStatement(sql)) {
			prepareStatement.setInt(1, ++COUNT_PERSON);
			prepareStatement.setString(2, person.getName());
			prepareStatement.setString(3, person.getSurname());
			prepareStatement.setInt(4, person.getAge());
			prepareStatement.setString(5, person.getEmail());
			prepareStatement.executeUpdate();
		} catch(SQLException e) {
			log.error("Added database error", e);
		}		
	}

	@Override
	public List<Person> getAll() {
		String sql = "SELECT id, name, surname, age, email FROM person";
		List<Person> listPerson = new ArrayList<>();
		try(Connection connect = connectDB.getConnection(); 
			Statement statement = connect.createStatement(); 
				ResultSet resultSet = statement.executeQuery(sql)) {
				while(resultSet.next()) {
					Person person = new Person();
					person.setId(resultSet.getInt("id"));
					person.setName(resultSet.getString("name"));
					person.setSurname(resultSet.getString("surname"));
					person.setAge(resultSet.getInt("age"));
					person.setEmail(resultSet.getString("email"));
					listPerson.add(person);
				}
 			} catch(SQLException e) {
			log.error("Error getting data from the database", e);
		}
		return listPerson;
	}

	@Override
	public Person getById(int id) {
		String sql = "SELECT id, name, surname, age, email FROM person WHERE id= ?";	
		Person person = new Person();
		try(Connection connect = connectDB.getConnection(); 
				PreparedStatement prepareStatement = connect.prepareStatement(sql)){
			prepareStatement.setInt(1, id);
			try (ResultSet resultSet = prepareStatement.executeQuery()) {			
				while(resultSet.next()) {				
					person.setId(resultSet.getInt("id"));
					person.setName(resultSet.getString("name"));
					person.setSurname(resultSet.getString("surname"));
					person.setAge(resultSet.getInt("age"));
					person.setEmail(resultSet.getString("email"));
				}
			}
		} catch(SQLException e) {
			log.error("Error getting data from the database by id", e);
		}
		return person;
	}

	@Override
	public void update(Person person) {
		String sql = "UPDATE person SET name = ?, surename= ?, age= ?, email = ?" + 
											" WHERE id = ?";
		try(Connection connect = connectDB.getConnection();
				PreparedStatement prepareStatement = connect.prepareStatement(sql)) {
			prepareStatement.setString(1,person.getName());
			prepareStatement.setString(2,person.getSurname());
			prepareStatement.setInt(3,person.getAge());
			prepareStatement.setString(4,person.getEmail());
			prepareStatement.setInt(5,person.getId());
			prepareStatement.executeUpdate();
		} catch(SQLException e) {
			log.error("Error updating data from the database", e);
		}
	}

	@Override
	public void remove(Person person) {
		String sql = "DELETE FROM person WHERE ID = ?";		
		try(Connection connect = connectDB.getConnection(); 
				PreparedStatement prepareStatement = connect.prepareStatement(sql)) {				
			prepareStatement.setInt(1, person.getId());			
			prepareStatement.executeUpdate();			
		}catch(SQLException e) {
			log.error("Error removing data from the database", e);
		}
	}

}
