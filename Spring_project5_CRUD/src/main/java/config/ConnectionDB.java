package config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

import org.apache.log4j.Logger;

import springCrud.dao.PersonSQLDAO;

public class ConnectionDB {
	private String url;
	private String user;
	private String password;
	private String driver;	
	private Connection connection;
	private static ConnectionDB connectionDB;
    private static final Logger log = Logger.getLogger(ConnectionDB.class);

	
	private ConnectionDB() {	}

	public static ConnectionDB getInstance() {
		if(connectionDB == null) {
			return new ConnectionDB();
		}	
		return Objects.requireNonNull(connectionDB);
	}
	
	private void init() {
		Properties property = new Properties();
		try(InputStream inputStream = PersonSQLDAO.class.getClassLoader().getResourceAsStream("connect.properties")) {
			property.load(inputStream);
			url = property.getProperty("url");
			user = property.getProperty("user");
			password = property.getProperty("password");
			driver = property.getProperty("driver");
		}catch(IOException e) {
			log.error("Error connecting to database", e);
		}
	}
	
	public Connection getConnection() {
		if(url == null && user == null && password == null && driver == null) {
			init();
		}
		try {
			Class.forName(driver);
			DriverManager.getConnection(url, user, password);
			log.info("Connection successful");
			System.out.println("Connection successful");
			return connection;
		} catch(SQLException e) {
			log.error("Error loafing JDBC driver", e);
		} catch(ClassNotFoundException e) {
			log.error("jdbs driver class not found", e);
		}
		return null;
	}

}
