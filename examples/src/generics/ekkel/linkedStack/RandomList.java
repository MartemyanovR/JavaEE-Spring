package generics.ekkel.linkedStack;

import java.util.ArrayList;
import java.util.Random;

/*
 * мы хотим создать особую разновидность списка, 
 * которая случайным образом выбирает один из своих элементов при каждом вызове select()
 */

public class RandomList<T> {	
	
	private ArrayList<T> storage = new ArrayList<T>();
	private Random rand = new Random(47);
	public void add(T item) { storage.add(item); }
	public T select() {
		return storage.get(rand.nextInt(storage.size()));
		}
	
	public static void main(String[] args) {
		RandomList<String> rs = new RandomList<String>();
		for(String s: ("The quick brown fox jumped over " +
		"the lazy brown dog").split(" "))
			rs.add(s);
		for(int i = 0; i < 11; i++)
			System.out.print(rs.select() + " ");
		System.out.println();
		
		RandomList<Integer> rs2 = new RandomList<>();
		int[] i = {1,2,3,4,6,9,8,7,5};
		for(Integer c: i) 
			rs2.add(c);
		for(int k = 0; k < i.length; k++)
			System.out.print(rs2.select() + " ");
		}
}
