package collection.collision;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetCollision {

	public static void main(String[] args) {
		 Set<Person> set = new HashSet<Person>();
	        Person a= new Person("Alice",44);
	        Person b=new Person("bob",45);
	        Person c= new Person("charlie",48);
	        set.add(a);
	//        a.setName("bob");
	        set.add(b);
	        set.add(c);


	        for(Iterator<Person> iterator=set.iterator();iterator.hasNext();){

	            System.out.println(iterator.next() );

	        }
	        System.out.println(set.toString());
	        
	        Set<Person> set2 = new HashSet<Person>();
	        Person a1= new Person("charlie",48);
	        Person b1= new Person("bob",44);
	        Person c1= new Person("bob",45);
	        set2.add(a);
	//        a.setName("bob");
	        set2.add(b);
	        set2.add(c);

	   //     System.out.println(set2.equals(set));
	      set.retainAll(set2);
	      System.out.println(set);
	}

}
