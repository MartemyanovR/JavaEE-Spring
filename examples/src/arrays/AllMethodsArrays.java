package arrays;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllMethodsArrays {

	public static void main(String[] args) throws Exception {
		Integer[] i = {1,56,7,87,9,0,3,33,3,25,9,4,46};
		//Arrays.asList(null);  //npe		
		List<Integer>list = Arrays.asList(i);  //преобразуем в лист(Arrays.asList возвращает обертку List вокруг массива)
	//	list.remove(87);  //UnsupportedOperationException, Arrays.ArrayList поддерживает только set(), тк он не мен€ет размера 
	//	list.add(100); //UnsupportedOperationException
		Collections.sort(list, (o1,o2) -> o1-o2);  //отсортируем
		list.stream().forEach((y) -> System.out.print(y + " "));   //выведем на экран
		Integer[] integers = list.toArray(new Integer[0]);
		System.out.println("\n" + Arrays.binarySearch(integers, 0,8 , 5));  //возвращает отриц значение(с учетом места вставки), либо индекс найденого знначени€
		System.out.println(Arrays.toString(i));
		System.out.println("\n" + Arrays.binarySearch(i, 25 , (o1,o2) -> o1-o2));  //поддержка comporator
		System.out.println(Arrays.toString(Arrays.copyOf(i, 50)));  //создаем массив указанного размера(заполн€€ null)
		Number[] num = Arrays.copyOfRange(i, 1, 5, Number[].class);  //копирование подмассива + преобразование к другому типу
		System.out.println(Arrays.toString(num));
		Arrays.fill(i, 5, 7, -1);  //заполн€ет указанную часть одним эленментом(-1)
		System.out.println(Arrays.toString(i));
		double[] d = {5.2, 6.8, 1.2, 7.2, 1.3};
	//	Arrays.parallelPrefix(d, (x,y) -> x+=y); //кумулирует каждый элемент массива
	//	Arrays.stream(d).forEach((z) -> System.out.print(z + ", "));
		Arrays.parallelSetAll(d, iq->iq*2);  //устанавливает элементы массива с помощью л€мбда-выражени€
	    Arrays.stream(d).forEach((z) -> System.out.print(z + ", "));
		System.out.println();
		Arrays.parallelSort(d,1,5);
		Arrays.stream(d).forEach((z) -> System.out.print(z + ", "));
		
		
		//из пазлера Java Puzzlers NG S02
		ArrayList[] two = new ArrayList[10];
		Arrays.setAll(two,ArrayList::new);  //т.е аргумент массива передаетс€ в аргумент arrayList как capacity, и так дл€ каждой коллекции
		System.out.println(Arrays.deepToString(two));
		two[0].add("!!!");
		two[0].add("???");	
		System.out.println(two[3].size() + " " + getCapacity(two[85]));  //здесь показан корень проблемы, что  
		two[0].forEach(System.out::print);
		System.out.println(Arrays.deepToString(two));
	}
	
	//метод который показыват capacity коллекции
	static int getCapacity(ArrayList<?> l) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }

}
