package generics.ekkel.linkedStack;

/*
 * В этом примере для определения пустого стека используется сторож (end sentinel).
 *  Сторож создается при конструировании LinkedStack, и при каждом вызове push() новый узел Node<T>
 *   создается и связывается с предыдущим узлом Node<T>. При вызове pop() всегда возвращается top.item,
 *    после чего текущий узел Node<T> удаляется и происходит переход к следующему узлу;
 *     но при достижении сторожа перемещение не выполняется. Если клиент будет и дальше вызывать pop(),
 *      он будет получать null (признак пустого стека).
 */

public class LinkedStack<T> {
	
	private static class Node<U> {
		U item;
		Node<U> next;
		Node() { item = null; next = null; }
		Node(U item, Node<U> next) { this.item = item; this.next = next; }

		boolean end() { return item == null && next == null; }
	}
	
	private LinkedStack.Node<T> top = new LinkedStack.Node<T>(); // Сторож
	
	public void push(T item) { top = new LinkedStack.Node<T>(item, top); } //аналогия СС, здесь top(в аргументах) ссылается на прошлый next 
	public T pop() {
	T result = top.item;
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
