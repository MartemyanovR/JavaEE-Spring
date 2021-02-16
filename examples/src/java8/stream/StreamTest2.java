package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {
	

	public static void main(String[] args) {
		int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
		//реобразуем многомерный массив в одномерный
		int[] newArr = Arrays.stream(arr).flatMapToInt(i -> Arrays.stream(i)).toArray();
		System.out.println(Arrays.toString(newArr));
		//с помощью флат возвращаем количество в каждом значении, для 1,2,3,4 /*0010120123*/
		Stream.of(1,2,3,4).flatMapToInt(x -> IntStream.range(0, x)).forEach(System.out::print);
		
		//использование сортед
		List<String> phones = new ArrayList<String>();
        Collections.addAll(phones, "iPhone X", "Nokia 9", "Huawei Nexus 6P",
                "Samsung Galaxy S8", "LG G6", "Xiaomi MI6",
                "ASUS Zenfone 3", "Sony Xperia Z5", "Meizu Pro 6",
                "Pixel 2");
        phones.stream().filter(p -> (p.length() > 4)).map(s -> s.toLowerCase()).sorted().forEach(System.out::println);
        System.out.println();
        
        //сортед с компаратором
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600), 
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Nokia 9", "HMD Global",150),
                new Phone("Galaxy S9", "Samsung", 300));
        //класскастексеп тк фон не реализ компаратор
        //phoneStream.sorted().forEach(System.out::println);
        phoneStream.sorted(new PhoneComparator()).forEach(x -> System.out.println(x.getName()));
        
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(x -> System.out.print(x +" "));

	}

}
