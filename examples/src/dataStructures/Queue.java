package dataStructures;

public class Queue {
		private int maxSize;
		private long[] queArr;
		private int rear;
		private int front;
		private int nItem;
		
		public Queue(int s) {
			maxSize = s;
			queArr = new long[maxSize];
			front=0;
			rear=-1;
			nItem=0;
		}
		public void insert (long i) {
			if (rear == maxSize-1) {		//циклический перенос
				rear = -1;
			}
			queArr[++rear] = i;
			nItem++;			
		}
		public long remove() {
			long temp = queArr[front++];
			if (front == maxSize) {
				front=0;
			}
			nItem--;
			return temp;
		}
		public long peekFront() {
			
			return queArr[front];
		}
		
		public boolean isEmpty() {
			return (nItem==0);
		}
		public boolean isFull(){
			return (nItem==maxSize);
		}
		public int size() {			//количество элементов в очереди
			return nItem;
		}
}
