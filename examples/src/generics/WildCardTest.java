package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WildCardTest <T extends Number & Comparable<? extends Number>> {
	
	 class InnerWildCar<T extends Object> {		
		 		 
		 //этот метод может работать только с <Object>
		 void printCollection(Collection<Object> c) {
			    for (Object e : c) {
			        System.out.println(e);
			    }
			}		 
		 void printCollectionWild(Collection<?> c) {
			    for (Object e : c) {
			        System.out.println(e);
			    }
			}				 
		 void printCollectionSuper(Collection<? extends Number> c) {
			    for (Object e : c) {
			        System.out.println(e);
			    }
			}		 
	}
	 public static void main(String[] args) {
		 Object obj= null;
		 Number num = null;
		 Integer i = 10;
		 Collection<Object> colObj = new ArrayList<>();
		 Collection<String> colStr = new ArrayList<>();
		 colStr.add("A");
		 colStr.add("B");
		 WildCardTest<Integer> wct = new WildCardTest<Integer>();
		 WildCardTest<Integer>.InnerWildCar<Object> iwc = wct.new InnerWildCar<>();
		 iwc.printCollection(colObj);
		// iwc.printCollection(colStr); //не сработает, Collection<Object> не родитель, и не одно и тоже что и Collection<Integer>
		
		 //c подстановочным типом работает  
		 iwc.printCollectionWild(colStr);		
		 
		 List<?> colWild = new ArrayList<>();
		 //поскольку мы не знаем, что это за тип,мы не можем ничего добавить.
		 //Единственным исключением является null, который является членом каждого типа
	     //colWild.add(new Integer(1));
		 colWild.add(null);
		 /*
		  *  Учитывая List<?>, мы можем вызвать get() и использовать полученный результат.
		  *  Тип результата неизвестен, но мы всегда знаем, что это объект.
		  *   Поэтому безопасно присвоить результат get () переменной типа Object или 
		  *   передать его в качестве параметра там, где ожидается объект типа.
		  */
		Object o =  colWild.get(0);
		
		// iwc.printCollectionSuper(i);
		 
		 
		 
	}

}
