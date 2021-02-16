package arrays;

import java.util.Arrays;

public class Merge4 {
	
	public static void main(String[] args) {		
		int[] a = {5,2,4,6,1,3,2,6};
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	private static void mergeSort(int[] array) {
	    mergeSort(array, 0, array.length);
	}

	private static void mergeSort(int[] array, int low, int high) {
	    if (low >= high-1)
	        return;

	    int middle = low + (high - low)/2;

	    mergeSort(array, low, middle);
	    mergeSort(array, middle, high);
	    merge(array, low, middle, high);
	}

	private static void merge(int[] array, int low, int middle, int high) {
	    int[] capacity = new int[high - low];

	    int currentIndex = 0;

	    for (int i = low, k = middle; i < middle || k < high; ) {
	        if (i == middle) {
	            while (k < high)
	            capacity[currentIndex++] = array[k++];
	            break;
	        }

	        if (k == high) {
	            while (i < middle)
	            capacity[currentIndex++] = array[i++];
	            break;
	        }

	        if (array[i] < array[k])
	            capacity[currentIndex++] = array[i++];
	        else
	            capacity[currentIndex++] = array[k++];
	    }

	    for (int i = low, c = 0; i < high && c < capacity.length; i++, c++)
	        array[i] = capacity[c];
	}
}
