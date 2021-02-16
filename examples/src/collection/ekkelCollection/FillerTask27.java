package collection.ekkelCollection;

import java.util.Queue;
import java.util.LinkedList;

public class FillerTask27 {
	private String num = "Number";
	private Queue<CommandTask27> que = new LinkedList<>();
	
	public void fill() {
		for(int i=0; i<10; i++)
		que.offer(new CommandTask27(num + " " + String.valueOf(i)));
	}
	
	public void display() {
		for(CommandTask27 com : que)
			System.out.println(com.operation());			
	}
}
