package collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class InterfaceList<T> implements List<T> {
	
	private T[] m;
	private int size = 0;
	
	InterfaceList() {
		m = (T[]) new Object[1];
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public boolean add(final T o) {
		if(this.size == m.length) {
			final T[] oldM = m;
			m = (size == 0) ? (T[]) new Object[this.size + 1] : (T[]) new Object[this.size * 2];
			System.arraycopy(oldM, 0, m, 0, oldM.length);
		}
		m[size++] = o;
		return true;
	}
	@Override
	public void add(int index, T element) {
		 if (index > size || index < 0) throw new IndexOutOfBoundsException();

	        if (size  == 0 || index == size) {
	            add(element);

	        } else if (m.length == size) {

	            final T[] tempM = m;
	            m = (T[]) new Object[this.size() * 2];

	            System.arraycopy(tempM, 0, m, 0,  index );
	            System.arraycopy(tempM, index, m, index + 1, size() - index);

	            set(index, element);
	            size++;

	        } else {

	            final T[] tempM = m;
	            System.arraycopy(tempM, 0, m, 0, index + 1);
	            System.arraycopy(tempM, index, m, index + 1, size() - index);
	            set(index, element);
	            size++;
	        }
	}
	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int arg0, Collection<? extends T> arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T get(int index) {
		 if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		    return m[index];
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}		
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Iterator<T> iterator() {
		return null;
	}	
	@Override
	public ListIterator<T> listIterator() {
		return new ElementsIterator();
	}
	@Override
	public ListIterator<T> listIterator(int index) {
		return new ElementsIterator(index);
	}
	public void display() {
		for(int i=0; i<this.size; i++) {
			System.out.print(m[i] + " ");
		}
		System.out.println();
	}
	private class ElementsIterator implements ListIterator<T> {
		private static final int LAST_IS_NOT_SET = -1;
		private int index;
		private int lastIndex = LAST_IS_NOT_SET;
		
		ElementsIterator() {}
		ElementsIterator(int index) {
			if (size < index)
				throw new ArrayIndexOutOfBoundsException("Specified index is greater then size array");
			this.index = index;
			}		
		@Override
		public boolean hasNext() {
			return InterfaceList.this.size() > index;
		}
		@Override
		public T next() {
			if (!hasNext()) throw new NoSuchElementException();
			lastIndex = index++;
			return InterfaceList.this.m[lastIndex];
		}		
		@Override
		public int nextIndex() {
			if(index >= size-1)
				return size;
			return index;
		}
		@Override
		public boolean hasPrevious() {
			return index > 0;
		}
		@Override
		public T previous() {
			if(!hasPrevious()) throw new NoSuchElementException();
			lastIndex = previousIndex();
			return InterfaceList.this.m[--index];
		}
		@Override
		public int previousIndex() {
			if(!hasPrevious()) return LAST_IS_NOT_SET;
			else return index-1;
		}
		@Override
		public void remove() throws UnsupportedOperationException , IllegalStateException{
			if(lastIndex == LAST_IS_NOT_SET)
				throw new IllegalStateException("Next method has not yet been called.");
			if(index == size-1) {
				size--;
				lastIndex = LAST_IS_NOT_SET;
			}
			else {
				final T[] tempM = m;
	            System.arraycopy(tempM, 0, m, 0,  index );
	            System.arraycopy(tempM, index, m, index - 1, size() - index);
	            size--;	
	            lastIndex = LAST_IS_NOT_SET;
			}
		}
		@Override
		public void set(T e) throws IllegalStateException, IllegalArgumentException {
			if(lastIndex == LAST_IS_NOT_SET) throw new IllegalStateException();		
			if (lastIndex < index)
				InterfaceList.this.m[lastIndex] = e;
			else
				InterfaceList.this.m[index] = e;
			}
		@Override
		public void add(T e) {
			if (size  == 0 || index == size) {
				 if (m.length == size) {
			            final T[] oldM = m;
			            m = (T[]) new Object[size * 2];
			            System.arraycopy(oldM, 0, m, 0, oldM.length);
			        }
			        m[size++] = e;
			        index++;
			}  else if (m.length == size) {
	            final T[] tempM = m;
	            m = (T[]) new Object[size * 2];
	            System.arraycopy(tempM, 0, m, 0,  index );
	            System.arraycopy(tempM, index, m, index + 1, size() - index);
	            m[index++] = e;
	            size++;			
			} else {
	            final T[] tempM = m;
	            System.arraycopy(tempM, 0, m, 0,  index );
	            System.arraycopy(tempM, index, m, index + 1, size() - index);
	            m[index++] = e;
	            size++;	
			}
			lastIndex = LAST_IS_NOT_SET; 
		}	
	}
}
