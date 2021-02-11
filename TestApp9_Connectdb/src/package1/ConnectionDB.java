package package1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {	
	private String url;
	private String user;
	private String password;
	private String driver;	
	Connection connect;
	
	private void init() {		
		try(InputStream in = ConnectionDB.class.getClassLoader().getResourceAsStream("connect.properties")) {
			Properties propert = new Properties();
			propert.load(in);
			url = propert.getProperty("DB_URL");
			user = propert.getProperty("DB_USERNAME");
			password = propert.getProperty("DB_PASSWORD");	
			driver = propert.getProperty("DB_DRIVER");
		} catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	public Connection getConnection() {
		
		if(url==null && user==null && password ==null) {
			init();
		}
		try {
			Class.forName(driver);
			connect = DriverManager.getConnection(url, user, password);
			System.out.println("Connect succes");
			return connect;
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
