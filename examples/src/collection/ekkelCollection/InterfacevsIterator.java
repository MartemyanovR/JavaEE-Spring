package collection.ekkelCollection;

import java.util.Iterator;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import java.util.Map;
import java.util.LinkedHashMap;
/**
 * Коллекциии и Итераторы Еккель стр. 335
 * @author Roman
 *
 */
public class InterfacevsIterator {
	public static void display(Iterator<Pet> it ) {
		while(it.hasNext()) {
			Pet pet = it.next();
			System.out.print(pet.id() + ": " + pet+ ", ");
			}
		Pet.dischargeId();
		System.out.println();
		
	}
	public static void display(Collection<Pet> c) {
		for(Pet pet : c) 
			System.out.print(pet.id() + ":" + pet + "  ");
		Pet.dischargeId();	
		System.out.println();
	}
	public static void main(String[] args) {
		Pet p = new Pet();
		List<Pet> petList = Arrays.asList(p.new Dog(), p.new Hamster(), p.new Cat(), p.new GuineaPig());
		Set<Pet> petSet = new HashSet<>(petList);
		Map<String, Pet> petMap = new LinkedHashMap<>();
		String[] names = ("Ralph, Eric, Robin, Lacey").split(", ");
		for(String s : names)
		System.out.print(s +  " ");
		System.out.println();
		for(int i = 0; i < names.length; i++)
			petMap.put(names[i], petList.get(i));
		display(petList);
		display(petSet);
		display(petList.iterator());
		display(petSet.iterator());
		System.out.println(petMap);
		System.out.println(petMap.keySet());
		display(petMap.values());
		display(petMap.values().iterator());
	}
}
