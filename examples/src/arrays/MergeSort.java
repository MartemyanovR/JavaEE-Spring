package arrays;

import java.util.Arrays;

public class MergeSort {	
	
	public static int[] sort(int[] src, int lower, int upper) {	
		if(upper >= src.length)
			upper = src.length-1;
		if (lower == upper) { // выход из рекурсии
            return src;
		}
		else { 
			int mid = (lower + upper) / 2;
			sort(src, lower, mid);
			sort(src, mid+1, upper);
			return merge(src, lower, mid+1, upper);
		}
	}		
	
	private static int[] merge(int[] src, int lower, int secondLow, int upper) {
		int count = 0;
		int firstLow = lower;
		int mid = secondLow - 1;
		int[] temp = new int[upper-lower+1];
				
		while(firstLow <= mid && secondLow <=upper) {
			if(src[firstLow] < src[secondLow]) {
				temp[count++] = src[firstLow++];
			}
			else {
				temp[count++] = src[secondLow++];
			}		
		}
		if(firstLow <= mid) {
			for(; firstLow <= mid; firstLow++) {
				temp[count++] = src[firstLow];
			}
		} 
		else {
			for(; secondLow <= upper; secondLow++) {
				temp[count++] = src[secondLow];
			}
		}
		return temp;
		
	}

	
	public static void main(String[] args) {
		
		int[] a = {5,2,4,6,1,3,2,6};
//		for(int i = 0; i < a.length-1; i++) {
		int[] i = sort(a,0,a.length);
		System.out.println(Arrays.toString(i));
	    System.out.println(Arrays.toString(a));		
	//		sort(a,0,a.length);
	//		System.out.println(Arrays.toString(a));			
	//	System.out.println(Arrays.toString(a));	
		
	}

}
