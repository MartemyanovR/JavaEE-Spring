package sort;

import java.util.Arrays;
import java.util.Random;

public class RadixSort2 {

	public static void main(String[] args) {
        int [] src = new int[10];
		Random random = new Random();
		for(int i = 0; i<src.length; i++) {
			src[i] = random.nextInt(200000000);
		}	
		long first = System.nanoTime();
		System.out.println("Sorted array: " + Arrays.toString(src));
		int[] res = countingSort(src,200000000);
		System.out.println("Sorted array: " + Arrays.toString(res));
		long result = (System.nanoTime() - first) /1000;
		System.out.println(result);
    }
    
	/*
	 * javarush
	 */
    public static int[] countingSort(int[] theArray, int maxValue) {
        // Массив со "счётчиками" размером от 0 до максимального значения
        int numCounts[] = new int[maxValue + 1];
        // В соответствующей ячейке (индекс = значение) увеличиваем счётчик
        for (int num : theArray) {
            numCounts[num]++;
        }
        // Подготавливаем массив для отсортированного результата
        int[] sortedArray = new int[theArray.length];
        int currentSortedIndex = 0;
        // идём по массиву со "счётчиками"
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            // идём по количеству значений
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }
	
	
}
