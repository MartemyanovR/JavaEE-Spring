package collection.ekkelCollection;
//Коллекции обьектов, задание №3
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class SequenceWithInnerClass<T> {
	private List<T> item;
	
	public SequenceWithInnerClass() {
		item = new ArrayList<>();
	}
	public void add(T obj) {
		item.add(obj);
	}
	private class InnerSequenceSelector implements Selector {
		private int i= 0;
		public boolean end() { return i == item.size(); }
		public T current() { return item.get(i); }
		public void next() { if(i<item.size()) i++;}
	}
	
	public Selector methodAccessInnerSequenceSelector() {
		return new InnerSequenceSelector();
	}

	//9. (4) Измените пример innerClasses/Sequence.java так, 
	//чтобы контейнер Sequence работал с Iterator вместо Selector.
	private class InnerSequenceSelectorIterator implements Iterator {
		private int i = 0;
		@Override
		public boolean hasNext() {
			
			return i < item.size();
		}

		@Override
		public Object next() {			
			return item.get(i++);
		}
		
	}
	public Iterator methodAccessSequenceSelectorIterator() {
		return new InnerSequenceSelectorIterator();
	}
	
}
