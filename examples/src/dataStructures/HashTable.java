package dataStructures;

public class HashTable {
		private HashDataItem[] arrHash;		//массив хэш таблицы
		private HashDataItem nonItem;		// вставка -1 при удалении
		private int arrSize=0;
		
		public HashTable (int s) {
			arrSize = s;
			arrHash = new HashDataItem[arrSize];
			nonItem = new HashDataItem(-1);
		}
		
		public void displayHash() {
			System.out.print("Size: ");
			
			for(int j=0; j<arrSize; j++) {
				if (arrHash[j] != null) {
					System.out.print(arrHash[j].getKey() + " ");
				}
				else {
					System.out.print("**");
				}
			}
			System.out.println();
		}
		
		public int hashFunc(int key) {
			return key % arrSize;
		}
		public int hashFunc2(int key) {  // возвращаемое значение отлично от нуля, меньше размера массива
			return 5 - (key % 5);		 //размер значения должен быть простым по отношению к 5,4,3,2,1
		}
		
		public void insert (int key, HashDataItem dataItem) {
			int hashVal = hashFunc(key);		//хеширование ключа
			int stepSize = hashFunc2(key);	    //вычесление смещения
			
			while(arrHash[hashVal] != null && arrHash[hashVal] != nonItem) {
				hashVal += stepSize;		//прибавление смещения
				hashVal %= arrSize;			//возврат к началу
			}
			arrHash[hashVal] = dataItem;	//вставка
		}
		
		public HashDataItem delete(int aKey) {
			int hashVal = hashFunc(aKey);
			int stepSize = hashFunc2(aKey);
			
			while(arrHash[hashVal] != null ) {
				
				if (arrHash[hashVal].getKey() == aKey) {  //ключ найден?
					HashDataItem temp = arrHash[hashVal];
					arrHash[hashVal] = nonItem; 
					return temp;
				}
				hashVal += stepSize;	//прибавление смещения
				hashVal %= arrSize;		//возврат к началу
			}
		      return null;	
		}
		public HashDataItem find (int key) {
			int hashVal = hashFunc(key);
			int stepSize = hashFunc2(key);

		while (arrHash[hashVal] != null ){
			if (arrHash[hashVal].getKey() == key ) {
				HashDataItem temp = arrHash[hashVal];
				return temp;
			}
			hashVal +=stepSize;
			hashVal %=arrSize;
		}
		return null;
	}
		
}
