package dataStructures;

import java.io.*;

public class HashDoubleApp {

	public static void main(String[] args) throws IOException {
		int key;
		HashDataItem dataItem;
		int size, n;
		
		System.out.print("Enter size of hash table: ");
		size = getInt();
		System.out.println("Enter initial number of items: ");
		n = getInt();
		HashTable ht = new HashTable(size);		//создание таблицы
		for(int j= 0; j<n; j++) {				// вставка данных
			key = (int)(java.lang.Math.random()* 2 * size);
			System.out.print(key + " ");
			dataItem = new HashDataItem(key);
			ht.insert(key, dataItem);
			}
		
		while (true) {
			System.out.print("Enter first latter of:  ");
				System.out.print("show, insert, delete, or find:  ");
				char choise = getChar();
				switch (choise) {
				case 's':
					ht.displayHash();
					break;
				case 'i':
					System.out.print("enter key value to insert: ");
					key = getInt();
					dataItem = new HashDataItem(key);
					ht.insert(key, dataItem);
					break;
				case 'd': 
					System.out.print("Enter key value to delete: ");
					key = getInt();
					ht.delete(key);
					break;
				case 'f' :
					System.out.print("Enter key value to find");
					key = getInt();
					dataItem = ht.find(key);
						if (dataItem == null) 
							System.out.println("key is not found");
							else
								System.out.println("key " + key + "found");
					break;
				default :
					System.out.println("Invalid entry \n");
			}
		}
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	public static int getInt() throws IOException{
		String s =getString();
		return Integer.parseInt(s);
	}
	public static char getChar() throws IOException{
		
		String s =getString();
		return s.charAt(0);
	}
	
}
