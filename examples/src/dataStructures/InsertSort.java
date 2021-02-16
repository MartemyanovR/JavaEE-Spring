package dataStructures;

public class InsertSort {      // медиана массива, удаление дубликата

	private long arr[];
	private int nElem;
	private int a=2;
	
	public InsertSort(int max) {
		arr = new long[max];
		nElem=0;		
	}
	
	public void insert(long value) {
		arr[nElem] = value;
		nElem++;
	}
	public void display() {
		for(int i=0; i<nElem; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public long insertSort() {		//сортировка вставкой (c подчетом копирований и сравнений)
		
		int out,in;
		int copy=0;
		int comp=1;
		for (out=1; out<nElem; out++) {
			comp++;
			long temp = arr[out];
			copy++;
			in=out;
			copy++;
			comp++;
			while (in>0) {
				comp++;
				if (arr[in-1]>= temp) {
				comp++;	
				arr[in] = arr [in-1];
				copy++;
				in--;
				}
				else break;
				
			}
			arr[in] = temp;
			copy++;
		}
		System.out.println("Сравнений- " + comp + "; копирований- "  + copy);
		
		return arr[--a];
	}
	
	
	public void median() {	//медиана массива
		int mid = nElem/2;
		System.out.println(arr[mid]);
	}
	
	public void noDups() {    //удаление дубликата
		int dups = 0;
		for (int i=0; i<nElem-1; i++) {   // перебор массива
			do {
				dups++;                          //счетчик для дубликатов

			if (dups == nElem-1) {              // если счетчик равен концу массива
				if (arr[i] == arr[dups]) {		//если текущий элемент массива равен элементу для дубликатов(последнему)
					nElem=i+1;
					return;
					}
				arr[i+1] = arr[dups];			//иначе
				nElem=i+2;
				return;
				}
			}
			while (arr[i] == arr [dups]);
			arr[i+1] = arr[dups];			
			}
			
		}		
	
	
	public void selectSort(){			//сортировка выбором
		int out,in,min;
		int copy=0;
		int comp=1;
		for (out = 0; out<nElem-1; out++) {
			comp++;
			min = out;
			copy++;
			comp++;
			for (in = out+1; in<nElem; in++) {
				comp+=2;
				if(arr[in]<arr[min]) {
					min=in;
					copy++;
				}
			}
			long temp = arr[out];
			arr[out] = arr[min];
			arr[min]=temp;
			copy+=3;
		}
		System.out.println("Сравнений- " + comp + "; копирований- " + copy);
	}
	
	public void primeNumber() {							// решето Эратосфена
	num:
		   for (int num = 2; num <= 100; num++) {
		      int n = (int)Math.sqrt(num)+1;
		      System.out.println(n);
		      while (--n != 1) {
		    	  System.out.println(n + "__");
		         if (num%n==0) {
		            continue num;
		         }
		      }
		      System.out.println(num+" ");
		   }
	System.out.println();
	}
	
	public void evenOddSort() {   {   // четно-нечетная сортировка
		int i = 0;
		int out = nElem-1;
		int count=1;
		while (count != 0) {
			count = 0;
			for (i=0; i< out;i++) {
				if(i%2 != 0) {
					if(arr[i] > arr[i+1]) {
						long temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
						count++;
					}
				}
			}
			for (i=0;i<out;i++) {
				if(i%2 == 0) {
					if(arr[i] > arr[i+1]) {
						long temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
						count++;
					}
				}
			}
		}
		
	}
  }
}

	

