package collection;

public class GraphStack {
	private int maxSize; // Размер массива
	private int[] stackArray;
	private int top; // Вершина стека
	//--------------------------------------------------------------
	public GraphStack(int s) // Конструктор
	{
		maxSize = s; // Определение размера стека
		stackArray = new int[maxSize]; // Создание массива
		top = -1; // Пока нет ни одного элемента
	}
	//--------------------------------------------------------------
	public void push(int j) // Размещение элемента на вершине стека
	{
		stackArray[++top] = j; // Увеличение top, вставка элемента
	}
	//--------------------------------------------------------------
	public int pop() // Извлечение элемента с вершины стека
	{
		return stackArray[top--]; // Извлечение элемента, уменьшение top
	}
	public int peek() // Чтение элемента с вершины стека
	{
		return stackArray[top];
	}
	//--------------------------------------------------------------
	public boolean isEmpty() // True, если стек пуст
	{
		return (top == -1);
	}
	//--------------------------------------------------------------
	public boolean isFull() // True, если стек полон
	{
		return (top == maxSize-1);
	}
}
