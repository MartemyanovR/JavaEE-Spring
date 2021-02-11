package utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import model.User;

public class Utils {
	
	public static User createStubUser(int id, String name, int age) {		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		return user;
	}

	public static boolean requestValid(HttpServletRequest request, String name, String age) {
		return name != null && name.length() > 0 &&
			   age != null && age.length() > 0 && 
			   age.chars().allMatch(Character::isDigit);	
	}
	
	public static Object checkUserOnNullAndInit(Object users) {
		if(users == null || users.getClass() != ConcurrentHashMap.class ) {
			throw new IllegalStateException("Illegal object using");
		} else {			
			return users;
		}		
	}


}
