package collection;

import java.util.HashMap;

public class HashMapTestMethodPuttAll {

	 public static void main(String[] args) 
	    { 	  
	        // Creating an empty HashMap 
	        HashMap<String, Integer> hash_map = new HashMap<String, Integer>(); 
	  
	        // Mapping int values to string keys 
	        hash_map.put("Geeks", 10); 
	        hash_map.put("4", 15); 
	        hash_map.put("Geeks", 20); 
	        hash_map.put("Welcomes", 25); 
	        hash_map.put("You", 30); 
	  
	        // Displaying the HashMap 
	        System.out.println("Initial Mappings are: " + hash_map); 
	  
	        // Creating a new hash map and copying 
	        HashMap<String, Integer> new_hash_map = new HashMap<String, Integer>(); 
	        
	        // Mapping int values to string keys
	        new_hash_map.put("1", 1);
	        new_hash_map.put("2", 1);
	        new_hash_map.put("3", 1);
	        new_hash_map.put("4", 1);
	        
	        new_hash_map.putAll(hash_map); 
	  
	        // Displaying the final HashMap 
	        System.out.println("The new map looks like this: " + new_hash_map); 
	    } 

}
