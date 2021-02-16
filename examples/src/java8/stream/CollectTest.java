package java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectTest {
	public static void main(String[] args) {

		List<String> phones = new ArrayList<String>();
        Collections.addAll(phones, "iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2", 
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");    
        
       //здесь фильтруем и помещаем в коллекцию
        List<String> filteredPhones = phones.stream()
                .filter(s->s.length()<10)
                .collect(Collectors.toList());
                 
        for(String s : filteredPhones){
            System.out.println(s);
        }
        
        System.out.println();
        
        //здесь фильтруем и помещаем в опеделенный тип коллекции
        HashSet<String> hashPhones = phones.stream()
                .filter(s->s.length()<10)
                .collect(Collectors.toCollection(HashSet::new));
        
        for(String s : hashPhones){
            System.out.println(s);
        }
        
        System.out.println();
//--------------------------------------------------------------------------------------------------
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 8", 54000), 
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000));
   //фильтруем коллекцию, далее превращаем результат в MAP     
        Map<String, Integer> phoneMap = phoneStream.filter(s -> (s.getPrice() > 42000))
        								.collect(Collectors.<Phone, String, Integer>toMap(k -> k.getName(), v-> v.getPrice()));
        
        phoneMap.forEach((k,v) -> System.out.println(k + " " + v));
//-------------------------------------------------------------------------------------------------------        
        
        Stream<String> phones2 = Stream.of("iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2", 
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");  
        
        ArrayList<String> filteredPhones2 = phones2.filter(s -> s.length() > 15).
        		collect(
        				()->new ArrayList<String>(), // создаем ArrayList
                        (list, item)->list.add(item), // добавляем в список элемент
                        (list1, list2)-> {				// добавляем в список другой список
                        list1.addAll(list2);
                        System.out.println(list1==list2);
                        System.out.println(list1.equals(list2));
                        }); 
                
              
        filteredPhones2.forEach(s->System.out.println(s));
		
	}

}
