package collection.ekkelCollection;
//Коллекции обьектов, задание №3
public interface Selector<T> {
	boolean end();
	T current();
	void next();	
}
