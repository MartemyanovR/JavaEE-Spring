package dataStructures;

public class BubbleSort {  
	private long[] arr;
	private int nElem;
	public String str = "new"; 
	
	BubbleSort(int max){
		arr = new long[max];
		nElem=0;
	}
	
	public void insert(long value) {     //пузырек
		arr[nElem]=value;
		nElem++;
		}
	
	public void display() {
		for(int i=0; i<nElem; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public void bubbleSort() {
		int out=nElem-1;
	    int in;
	    /*	for (out=nElem-1; out>in; out--) {		
		for (int i=in; i<out; i++) {	// сортировка слева на право
			if (arr[i]>arr[i+1]) {
				long temp;
				temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				}
			}		*/
	    for (in=0; in<out; in++) {
		for (int j = out; j>in; j--) { 	//сортировка справа налево (+ в обратной последовательности)  
			if (arr[j]>arr[j-1]) {
				long temp;
				temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				}
			}
			
		}	
	}
}
