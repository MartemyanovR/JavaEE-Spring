package java8.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class ReduceTest {

	public static void main(String[] args) {
		
		 Stream<Integer> numbersStream = Stream.of(1,2,3,4,5,6);
	 //геометрическая прогрессия, reduce сводит данные
	    Optional<Integer> result = numbersStream.reduce((x,y)->x*y);
        System.out.println(result.get());
                
        Stream<String> wordsStream = Stream.of("мама", "мыла", "раму");
        Optional<String> sentence = wordsStream.reduce(((x,y)->x + " " + y));
        System.out.println(sentence.get());     
	      
        //первое значение в методае reduce это началное значение
        int sum = Stream.of(1, 2, 3, 4, 5).reduce(10, (acc, x) -> acc + x);
        System.out.println(sum);
        
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", "iPhone", 54000), 
                new Phone("Lumia 950","Lumia", 45000),
                new Phone("Samsung Galaxy S 6", "Samsung" , 40000),
                new Phone("LG G 4", "LG" ,  32000));
        
        
        //reduce принимает Integer,(Integer,Phone),Integer
        // Второй параметр производит бинарную операцию, которая получает промежуточное значение - суммарную цену текущего и предыдущего телефонов.
       //
        int sumPrice = phoneStream.reduce(0, (x,y) -> { 
        						if(y.getPrice() < 44000) {
        							System.out.println(x);
        							return x + y.getPrice(); 
        						}
        						return x + 1;
        						}, (x,y) -> x+y);
        System.out.println(sumPrice);
	
	
	
	
	
	
	
	
	}

}
