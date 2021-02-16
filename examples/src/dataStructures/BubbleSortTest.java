package dataStructures;

public class BubbleSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int z =0;
		
		int i = ++n%5;
		n = n<i ? 5: 0;
		n/=2;
		System.out.println(i + " " + n);
		int maxSize = 100;
		BubbleSort bs = new BubbleSort(maxSize);
		//bs.str;
		
		bs.insert(100);
		bs.insert(11);
		bs.insert(120);
		bs.insert(5);
		bs.insert(19);
		bs.insert(159);
		bs.insert(32);
		bs.insert(25);
		bs.insert(4);
		bs.display();
		bs.bubbleSort();
		bs.display();
	}

}
