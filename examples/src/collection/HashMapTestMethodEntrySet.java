package collection;

import java.util.*;

public class HashMapTestMethodEntrySet {
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
	    hash_map.put("2", 11);
	    hash_map.put("3", 8);
	    hash_map.put("4", 1);
		
		// Displaying the HashMap 
	    System.out.println("Initial Mappings are: " + hash_map.toString()); 
	    
	    //Creating an empty HashSet
	    Set<Map.Entry<String, Integer>> set_hash = new HashSet<>();
	    
	    //filling out an existing collection 
	    set_hash = hash_map.entrySet();
	    
	    // Displaying the HashSet    
	    System.out.println("Initial Set are: " + set_hash.toString()); 
	    
	   //Changing the specific item via iterator
	   Iterator<Map.Entry<String, Integer>> itr = set_hash.iterator();
	   while(itr.hasNext()) {
		   if(itr.next().getKey() == "4")
		   itr.remove();
	   }
	   
	   // Displaying the HashSet and hashMap
	    System.out.println("After removal Mappings are: " + set_hash.toString()); 
	    System.out.println("After removal Set are: " + hash_map.toString()); 
		
		//adding new elements
	    hash_map.put("7", 100);
	
	    // Displaying the HashSet and hashMap
	    System.out.println("After removal Mappings are: " + set_hash.toString()); 
	    System.out.println("After removal Set are: " + hash_map.toString()); 
	    
	    //changing the specific element via Map.Entry.setValue()
	    for(Map.Entry<String, Integer> it : set_hash) {
	    	if(it.getKey() == "BB")
	    		it.setValue(28);
	    }
		
	    // Displaying the HashSet and hashMap
	    System.out.println("After removal Mappings are: " + set_hash.toString()); 
	    System.out.println("After removal Set are: " + hash_map.toString()); 
    
	       
	    
	}
}