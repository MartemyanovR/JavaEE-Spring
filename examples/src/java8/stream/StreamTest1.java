package java8.stream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Collections.addAll(list, "A","D","Vccccc","F","R");
		list.stream()		//получам поток
			.filter(s -> s.length() == 6)			//фильтрация по длине строки
				.forEach(s -> System.out.println(s));		//выводим строки на консоль
		
		IntStream intStream = Arrays.stream(new int[]{1,2,4,5,7});
		intStream.forEach(System.out::print);
		System.out.println();
		
		LongStream longStream = LongStream.of(34545,534534,52435324,435243534,4354,243423,323);
		longStream.filter(i -> i > 312423).forEach(i -> System.out.print(i +  " "));
		System.out.println();
		
		//вывести 10 случ чисел  способ 1:
		IntStream stream = Arrays.stream(new int[10]);;
		stream.limit(10).forEach(i ->System.out.print(new Random().nextInt(100) + " "));
		System.out.println();
		//способ 2 :
		Random random = new Random();
		random.ints(0,100).limit(10).forEach(System.out::println);
		System.out.println();
		
		//вывести колличество пустых строк (filter), можно подсчитыать любые символы
		try (BufferedReader br = new BufferedReader(new FileReader(new File("C:\\eclipse-workspace\\stringSub.txt")))) {
			StringBuilder sb = new StringBuilder(); 
			String s;
			while((s = br.readLine()) != null) {
				sb.append(s);
			}			
			Long countchar = sb.toString().chars().filter(i -> (i == 'Ф')).count();
			System.out.println(countchar);
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		//еще пример
		List<String> strList = Arrays.asList("","",""," ","!","?");
		long l = strList.stream().filter(str -> str.isEmpty()).count();
		System.out.println(l);
		
		//преобразование одного типа в другой с помощью map
		List<Integer> intList = Arrays.asList(2,34,54,5,6,5,6,5,6);
		String ss = intList.stream().map(mapping -> mapping.toString()).collect(Collectors.joining("_"));
		System.out.println(ss);
		//преобразование числа в корень этого числа
		List<Integer> intList2 = Arrays.asList(16,49,64,50,100,2,4,5,600);
		intList2.stream().map(mapping -> Math.sqrt(mapping)).forEach(x -> System.out.printf("%3.1f ", x));
		System.out.println();
		//преобразование в квадрат, и отбрасывает повторки(дистинкт)
		List<Integer> ll = intList.stream().map(m -> m*m).distinct().collect(Collectors.toList());
		System.out.println(ll);
		
		

	}

}
