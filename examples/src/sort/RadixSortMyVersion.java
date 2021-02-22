package sort;

import java.util.Arrays;
import java.util.Random;

public class RadixSortMyVersion {
	public static int radix = 1; 
	
	public static void main(String[] args) {
		int [] src = new int[10];
		Random random = new Random();
		for(int i = 0; i<src.length; i++) {
			src[i] = random.nextInt(200000000);
		}	
		long first = System.nanoTime();
		System.out.println("Input array: " + Arrays.toString(src));		
		regexSort(src);
		System.out.println("Sorted array: " + Arrays.toString(src));
		long result = (System.nanoTime() - first) /1000;
		System.out.println(result);
	}
	
	/**
	 * Реализация поразрядной сортировки, с помощью вспомогательного массива
	 * с корзинами для хранения списков элементов, хорошо работает с большими числами
	 * @param src входной массив чисел
	 * @return оттсортированный массив чисел
	 */
	public static int[] regexSort(int[] src) {
		int count = max(src);
		while(count-- > 0) {
			Node[] arNode = new Node[10];
			int j = 0;
			for(int i = 0; i<src.length; i++) {
				int val = src[i];
				Node node = new Node(val);
				int position;
				position = val/radix % 10;
				if(arNode[position] != null) {
					Node current = arNode[position];
					while(current.next != null) {	
						current = current.next;												
					}
					current.next = node;
				} else
					arNode[position] = node;
			}
			for(int i = 0; i<arNode.length; i++) {
				
				if(arNode[i] != null) {
					src[j++] =  arNode[i].val;					
					Node current = arNode[i];
					while(current.next != null) {
						src[j++] =  current.next.val;						
						current = current.next;
					}
				}
			}			
			radix*=10;			
		}		
		return src;
	}	
	
	/**
	 * поиск максимального элемента в массиве	
	 * @param src массив источник
	 * @return разрядность максимального элемента в массиве	
	 */
	private static int max(int[] src) {
		int max;
		int i=0;
		int result=0;
		max = src[i];
		for(i=1; i < src.length; i++) {
			if(max < src[i])
				max = src[i];
		}
		while(max > 0 ) {
			max /= 10;
			result++;
		}			
		return result;
	}	
	
	/**
	 * Объект для хранения значений и устанавливает связи между ними
	 */
	 private static class Node {
		 int val;
		 Node next;
		 Node(int val) {
			 this.val = val;
		 }
	
	}

}
