package collection.ekkelCollection;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

//рассмотрим программу, которая проверяет «случайность» чисел,
//вырабатываемых классом для производства случайных чисел Random.
//В идеале этот метод должен равномерно распределять сгенерированные числа,
//но для проверки необходимо создать набор случайных чисел
//и подсчитать количество чисел в разных диапазонах.	

public class MapStatistic {
	public static void main(String[] args) {
		Random rand = new Random();
		Map<Integer,Integer> m =
		new HashMap<Integer,Integer>(); 
		for(int i = 0; i < 1000; i++) {
			// Produce a number between 0 and 20: 
			int r = rand.nextInt(2);
			Integer freq = m.get(r);
			m.put(r, freq == null ? 1 : freq + 1);
			}
		System.out.println(m);	
	}
}
