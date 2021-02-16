package generics;

public class GenericClass<T> implements GenericInterface<T> {

	private T id;
	private int sum;
	
	public GenericClass(T id, int sum) {
		this.id = id;
		this.sum = sum;
	}	
	
	public  T getId() {
		return id;
	}
	//использование с другим парамером типа, является шаблоном для методов
	public <U> U getId2(U u) {
		return u;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String toString() {
		return this.id + " " + this.sum; 
	}
	
	
}
