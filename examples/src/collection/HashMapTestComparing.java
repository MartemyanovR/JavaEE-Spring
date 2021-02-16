package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class HashMapTestComparing {

	public static void main(String[] args) {

		 // Creating an empty HashMap 
	    Map<String, Integer> hash_map = new HashMap<String, Integer>(); 
	
	    // Mapping int values to string keys 
	    hash_map.put("Geeks", 10); 
	    hash_map.put("4", 15); 
	    hash_map.put("T", 20); 
	    hash_map.put("BB", 27); 
	    hash_map.put("Welcomes", 25); 
	    hash_map.put("You", 30); 
	    hash_map.put("1", 17);
	    hash_map.put("D", 11);
	    hash_map.put("3", 8);
	    hash_map.put("F", 1);
		
		// Displaying the HashMap 
	    System.out.println("Initial Mappings are: " + hash_map.toString()); 
	    
	    //Creating arrayList
	    List<Map.Entry<String, Integer>> list = new ArrayList<>(hash_map.entrySet());
	    
	    // Displaying the List 
	    System.out.println("Initial list are: " + list.toString()); 
	 /*   
	    //Sorting the elements collection via Comparator
	    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {	    	
	    	@Override
	    	public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2) {  
	    		return 	((String) e1.getKey()).compareTo((String) e2.getKey());	    	
	    	}
	    });
	    */
	    //Sorting the elements collection via Comparator
	    Collections.sort(list, 
	    	//new Comparator<Map.Entry<String, Integer>>() {	    	
	    	//@Override
	    	//public int compare
	    	(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2) -> 
	    	((String) e1.getKey()).compareTo((String) e2.getKey())	    	
	    );
	
	    // Displaying the List 
	    System.out.println("Initial list are: " + list.toString()); 
	}

}
