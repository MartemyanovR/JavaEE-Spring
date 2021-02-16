package collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Queue;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		Queue<GregorianCalendar> que = new PriorityQueue<>();
		
		que.add(new GregorianCalendar(1908, Calendar.DECEMBER,9));
		que.add(new GregorianCalendar(1915, Calendar.MAY,15));
		que.add(new GregorianCalendar(1903, Calendar.MARCH,7));
		que.add(new GregorianCalendar(1921, Calendar.NOVEMBER,1));
	
		System.out.println("Iterating elements: ");
		for(GregorianCalendar gc : que) 
			System.out.print(gc.get(Calendar.YEAR) + ", ");		
		System.out.println("\n" + "Removing elements: ");
		while(!que.isEmpty())
			System.out.print(que.remove().get(Calendar.YEAR) + ", ");
	}

}
