package properties;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class TestProperties {
	
	static Properties props = new Properties();

	public static void main(String[] args) throws IOException {
		Connection conn = null;
		try{
			conn = getConnection();
			String driver = props.getProperty("driver");			
			Class.forName(driver);
                           
            System.out.println("Connection to Store DB succesfull!");
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            ex.printStackTrace();
        }finally {
        	try {
        		conn.close();
        	}catch(Exception ex){
                System.out.println("Connection failed close");
                ex.printStackTrace();
        	}
        }
				
		/*prop.setProperty("driver", "org.h2.Driver");
		prop.setProperty("url", "jdbc:h2:C:/H2/test");
		prop.setProperty("user", "sa");
		prop.setProperty("Password", "_");
		
		System.out.println(prop.getProperty("Email"));
		Enumeration<?> en =  prop.propertyNames();
		while(en.hasMoreElements())
			System.out.println(en.nextElement().toString());	
			*/
	}
	
	 public static Connection getConnection() throws SQLException {
				
		try(InputStream is = Files.newInputStream(loadPropepties())) {
			props.load(is);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		String url = props.getProperty("url");
		String username = props.getProperty("user");
		String password = props.getProperty("Password");
		        
		System.out.println(url + " " + username + " " + password);
		
		return DriverManager.getConnection(url, username, password);        
	 }
	
	public static Path loadPropepties() {
		File file  = null;
		try {
			file = new File("database.properties");	
			StringBuilder strB = new StringBuilder();
			try(OutputStream os = new BufferedOutputStream(new FileOutputStream(file)))  {
				Map<String, String> load = fillData();
				for(Map.Entry<String, String> entry : load.entrySet())
					 strB.append(entry.getKey() + " = " + entry.getValue() + "\n");	
				String str = new String(strB);
				os.write(str.getBytes());
				os.flush();
			}		
		}catch(IOException e) {
			e.printStackTrace();
		}
				
		return file.toPath();
	}
	
	public static Map<String,String> fillData() {
		Map<String,String> stringMap = new LinkedHashMap<>();
		stringMap.put("driver", "org.h2.Driver");
		stringMap.put("url", "jdbc:h2:C:/H2/test");
		stringMap.put("user", "sa");
		stringMap.put("Password", "");
		return stringMap;
	}

}
