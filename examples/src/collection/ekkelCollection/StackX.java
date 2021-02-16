package collection.ekkelCollection;

import java.util.LinkedList;

public class StackX<T> {
	private int size;
	private LinkedList<T> storage = new LinkedList<>();
	public StackX(int size) { this.size = size; }
	public void push(T t) { storage.addFirst(t); }
	public T pop() { return storage.removeFirst(); }
	public T peek() { return storage.getFirst(); }
	public boolean isEmpty() { return storage.isEmpty(); }
	public String toString() { return storage.toString(); }
}
