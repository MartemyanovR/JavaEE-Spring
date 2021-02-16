package generics.wildCardTestExtAndSuper;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<LivingBeings> lb = new ArrayList<LivingBeings>();
		lb.add(new Animal());
		lb.add(new Fish());
		lb.add(new SawFish());
		lb.add(new Lion());
		lb.add(new Animal());
		
//		List<Animal> listAnimal = lb;  //no
		List<? extends LivingBeings> wildlb = lb;
//		wildlb.add(new Animal());  //no
		System.out.println(wildlb.get(0));
//		wildlb.set(0, wildlb.get(0)); //no		
		
	/*	List<? super Feline> listCat = lb;
		listCat.add(new Animal());   //не можем, тк вдруг у нас ? это 
		System.out.println(listCat.get(1));*/
		//meth(wildlb);
		
//1		
		System.out.println(meth(wildlb));
		System.out.println(meth2(wildlb));
		
		
//2		
		List<Feline> wildFelineAdd = new ArrayList<>();   // так как добавление элементов в коллекцию  ↓ (List<? extends Feline> wildFeline) 
		wildFelineAdd.add(new Lion());					  //невозможна, мы создаем сппец коллекцию для копирования
		wildFelineAdd.add(new Feline());
		List<? extends Feline> wildFeline = wildFelineAdd;  
		System.out.println(meth3(wildFeline));	//тк метод meth3 в аргументох принимает (List<? extends Feline>, мы не можем использовать коллекцию с типом выше чем Feline
		
		System.out.println(meth4(lb));
	
	}
	
//-----------------1------------------------------------------------------
/*	public static <T> T meth(List<? super T> list) {
		
		return list.get(0);  //Нельзя прочитать элемент из контейнера с wildcard ? super, кроме объекта класса Object
	}		*/
	
	public static <T> Object meth(List<? super T> list) {  //тк мы не знаем какой супер тип у Т, поэтому мы можем вернуть только Object
	//	list.add(new Animal());  //мы так же не знаем конкретного типа T
		return list.get(2);
	}
	
	public static <T> Object meth2(List<? extends T> list) {  //тоже самое, тк мы не знаем какой супер тип у Т, поэтому мы можем вернуть только Object
	//	list.add(new Animal());  //тоже самое,мы так же не знаем конкретного типа T
		return list.get(3);
	}
//------------------------2--------------------------------------------------
	
	public static <T> Animal meth3(List<? extends Feline> list) {  //если мы ограничиваем ? extends Feline, то для того чтобы вернуть элемент 
																// коллекции (return list.get(3);) возвращаемое значение 
			return list.get(1);									//должно быть не ниже ограничивающего типа.
		}
	
	public static <T> Object meth4(List<? super Fish> list) {
		//	list.add(new Animal());  
			return list.get(2);
		}
	

}
