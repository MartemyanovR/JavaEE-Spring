package covariance;

import java.util.List;
import java.util.ArrayList;

public class WildCards {
	public static void main(String[] args) {
	List<Integer> iList = new ArrayList<>(); 	
	iList.add(1);
	iList.add(2);
	List<? extends Number> nList = iList;
	//Если контейнер объявлен с wildcard ? extends, то можно только читать значения.
	//В список нельзя ничего добавить, кроме null.
	//nList.add(2);  //error compale
	nList.add(null);
	//либо прочитать
	System.out.println(nList.get(0));
	System.out.println(getList(iList));
	//при ? super мы можем записывать в коллекцию
	List<? super Number> iList1 = new ArrayList<>(); 
	iList1.add(3);
	iList1.get(0);
	System.out.println(getList(iList1));
	}
	public static <T> Object /*T*/ getList(List<? super T> list) {
		//Нельзя прочитать элемент из контейнера с wildcard ? super, кроме объекта класса Object
		return list.get(0);  //error compale
		
		//return list.get(2);
	}
}
