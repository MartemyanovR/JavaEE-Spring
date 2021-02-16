package generics.ekkel.genericMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import generics.ekkel.genInterface.*;;

public class Generators {
	
	public static <T> Collection<T>	fill(Collection<T> coll, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++) 
			coll.add(gen.next());
		return coll;
	}
	
	public static <T> List fill1(List coll, Generator<T> gen, int n) {
		for(int i = 0; i < n; i++) 
			coll.add(gen.next());
		return coll;
	}
	
	public static void main(String[] args) {
		Set<Coffe> set =  new HashSet<Coffe>();
		Collection<Coffe> coffe = fill(set, new CoffeeGenerator(), 4); 
		for(Coffe c : coffe)
			System.out.println(c);
		for(Coffe c : set)
			System.out.println(c);
		Collection<Integer> fnumbers = fill1(new ArrayList<Integer>(), new Fibonacci(), 12);
		for(int i : fnumbers)
			System.out.print(i + ", ");
	}

}
