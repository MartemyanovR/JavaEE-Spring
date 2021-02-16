package comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Product[] prod = new Product[7];
		
		prod[0] = new Product("broad", 75f, 10);
		prod[1] = new Product("milk",  50f, 100);
		prod[2] = new Product("milk",  50f, 100);		
		prod[3] = null;
		prod[4] = new Product("meas",  17f, 5);
		prod[5] = null	;
		prod[6] = new Product("butter",95f, 35);
		
		//это тоже самое что и класс ProductComparator, здесь в лямбда выражении мы используем метод CompareTo
		// public int compareTo(Product product) {returngetPrice().compareTo(product.getPrice()); }
//		Comparator<Product> productNameComp = Comparator.comparing((Product product) -> product.getPrice());
		Comparator<Product> productNameComp = Comparator.comparing(Product::getName);
		
				
		//здесь мы указываем что тип ключа сртировки должен быть int, затем если первый ключ возвращает 0,
		//то мы сравниваем второе знаение
		//default thenComparingDoubleВозвращает компаратор лексикографического порядка с функцией,
		//которая извлекает ключ сортировки 
		Comparator<Product> productNameCompThen = 
				Comparator.comparingInt((Product product) -> product.getQuantity()).
					thenComparingDouble((product) -> product.getPrice());
		
		//здесь исспользуем свой компоратор s1,s2 это обьекты (ключи сортировки)
		Comparator<Product> productNameComp1 = Comparator.comparing((Product product)
					-> (product.getPrice()), (Float s1,Float s2) ->{ return s2.compareTo(s1);} );
		
		/*		//обратный компаратор 
		Comparator<Product> productNameCompRevers =  productNameComp.reversed();		*/
		
		//синтаксис static <T extends Comparable<? super T>> Comparator<T> naturalOrder()
		//данный метод требует реализации метода Comparable 
		Comparator<Product> productNameCompNatural =  Comparator.<Product>naturalOrder();
		
		//Функция nullsFirst вернет Comparator , который хранит все nulls в начале последовательности упорядочения
		//и не бросает NPE
		//компаратор, который считает null меньше, чем non-null, и сравнивает non-null объекты с поставленным компаратором.
		Comparator<Product> productNameCompNull = Comparator.nullsFirst(productNameComp);
		
		
		//сортируем по полученому компоратору
		Arrays.sort(prod, productNameCompNull);
		Arrays.stream(prod).forEach(System.out::println);
		
		/*for(Product p : prod) {
			System.out.println(p.toString());
		}
		
		Arrays.sort(prod, new ProductComparator());

		for(Product p : prod) {
			System.out.println(p.toString());
		}*/
	}

}
