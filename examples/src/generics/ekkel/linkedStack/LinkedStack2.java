package generics.ekkel.linkedStack;

/*
 * 5. (2) Удалите параметр-тип класса Node и измените остальной код LinkedStack.java так,
 *  чтобы показать, что для внутреннего класса доступны обобщенные параметры-типы внешнего класса.
 */
public class LinkedStack2<T> {
	
	private  class Node {
		T item;
		Node next;
		Node() { item = null; next = null; }
		Node(T item, Node next) { this.item = item; this.next = next; }

		boolean end() { return item == null && next == null; }
	}
	
	private LinkedStack2.Node top = new LinkedStack2.Node(); // Сторож
	
	public void push(T item) { top = new LinkedStack2.Node(item, top); } //аналогия СС, здесь top(в аргументах) ссылается на прошлый next 
	public T pop() {
	T result = (T)top.item;
	if(!top.end()) 
		top = top.next; //возвращаемся через ссылку next, к предыдущему элементу
	return result;
	}
	
	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<String>(); 
		for(String s : "Phasers on stun!".split(" ")) 
			lss.push(s);
		String s;
		while((s = lss.pop()) != null)
			System.out.println(s);
		
	}
}
