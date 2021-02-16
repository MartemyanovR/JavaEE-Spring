package dataStructures;

public class insertSelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int u;
		if (1%2==0)
			System.out.println("четное");
		
		int maxSize = 100;
		InsertSort is = new InsertSort(maxSize);
		is.primeNumber();
		
		is.insert(0);
		is.insert(10);
		is.insert(30);
		is.insert(50);
		is.insert(51);
		is.insert(52);
		is.insert(53);
		is.insert(54);
		is.insert(55);
		is.insert(56);
		is.insert(57);
		is.insert(58);
		is.insert(60);
		is.insert(61);
		is.insert(62);
		is.insert(63);
		is.insert(64);
		is.insert(65);
		is.insert(66);
		is.insert(67);
		is.insert(68);
		is.insert(69);
		is.insert(1140);
		is.insert(323);
		is.insert(55);
		is.insert(65);
		is.insert(52);
		is.insert(13);
		
		is.display();
		is.median();
		System.out.println(is.insertSort());
		System.out.println(is.insertSort());
		is.selectSort();
		//is.evenOddSort();
		
		is.display();
		//is.median();
		is.noDups();
		is.display();
	}

}
