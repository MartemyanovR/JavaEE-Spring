package collection.ekkelCollection;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;
import java.util.Queue;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Напишите класс с именем Command, который содержит поле String и метод operation(),
 * выводящему String. Напишите второй класс с методом, который заполняет контейнер Queue
 * объектами Command и выводит его. Передайте заполненный контейнер Queue методу третьего класса,
 * перебирающему объекты Queue и вызывающему их методы operation().
 * @author Roman
 */

public class MainTask27 {
	public static void main(String[] args) {
		FillerTask27 fill = new  FillerTask27();
		fill.fill();
		fill.display();
/*28. (2) Заполните контейнер PriorityQueue (с использованием метода offer()) значениями Double,
 *  созданными генератором java.util.Random. Извлеките элементы из очереди методом poll() и выведите их.		
 */
		Random gen = new Random();
		PriorityQueue<Double> dous = new PriorityQueue<>(Arrays.asList(0.2,0.6));
		for(int i=0, k=10; i<k; i++)
			dous.offer(gen.nextDouble()*100);
		while(!dous.isEmpty())
			System.out.printf("%2.2f, ", dous.poll());		
/**
 * 29. Создайте простой класс, производный от {@link Object} и не содержащий членов. Покажите, что множественные
 * элементы этого класса не могут быть добавлены в {@link PriorityQueue}. Проблема будет более подробно рассмотрена
 * в главе 17.
 *		
 *	Queue<Task29> queue = new PriorityQueue<>(Arrays.asList(new Task29(),
 *               new Task29()));
*/                
		
	}
}
