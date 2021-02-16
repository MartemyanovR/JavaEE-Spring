package collection;

//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class InterfaceCollection<T> implements Collection<T>  {
	private T[] m;
	private int size = 0;
	
	InterfaceCollection() {
		m = (T[]) new Object[size];
	}
	@Override
	public int size() {
		return this.size;
	}
	@Override
	public boolean isEmpty() {
		return this.size == 0;
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
	public boolean remove(Object o) {
		for(int i = 0; i < this.size; i++) {
			if(m[i].equals(o)) { 
				if(i == 0 && size == 1) {
					size--;
					return true; }
				for(int j = i; j < size - 1; j++)
					m[j] = m[j+1];
					size--;					
					return true;
				}
			}				
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends T> c) {
		for(T t : c)
			this.add(t);
		return true;
	}
	@Override
	public void clear() {
		this.size = 0;
		m = (T[])new Object[size];		
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		for(final Object item : c)
			if(!this.contains(item))
				return false;
		return true;
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean marker = false;
		for(int i = 0; i < size; i++) {
			if(c.contains(m[i])) {
				this.remove(m[i]);
				i--;
				marker = true;
			}
		}
		return marker;
	}
	@Override
	public boolean contains(Object obj) {
		for(T t : this)
			if(t.equals(obj))
			return true;
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		boolean marker = false;
		for(int i = 0; i < size; i++) {
			if(!c.contains(m[i])) {
				this.remove(m[i]);
				i--;
				marker = true;
			}
		}
		return marker;
			}
	@Override
	public Object[] toArray() {
		T[] c = (T[]) new Object[size];
		return (T[])c;
	}
	@Override
	public <T> T[] toArray(T[] c) {
		if(c.length < this.size) { 
			//T[] temp = (T[])new Object[size];
			@SuppressWarnings("unchecked")
			T[] temp = (T[])java.lang.reflect.Array.newInstance(c.getClass().getComponentType(), size);
			for(int i = 0; i<size; i++) {
				temp[i] = (T) m[i];
			}
			c = temp;
			return c;
					//(T[])Arrays.copyOf(this.m, this.size, this.m.getClass());
		}
			System.arraycopy(m, 0, c, 0, size);
		if(c.length > this.size)
			c[size] = null;
		return c;	
	}
	 private void remove(final int index) {
	        if (index != this.size() - 1)
	            System.arraycopy(m, index + 1, m, index, this.size() - index - 1);
	        size--;
	    }
	public void display() {
		for(int i=0; i<this.size; i++) {
			System.out.print(m[i] + " ");
		}
		System.out.println();
	}
	@Override
	public Iterator<T> iterator() {		
		return new ElementsIterator();
	}
	private  class ElementsIterator implements Iterator<T> {
		private int index = 0;
		private int last = -1;
		
		public ElementsIterator() {
		}
		@Override
		public boolean hasNext() {
			return index < InterfaceCollection.this.size;			
		}
		@Override
		public T next() throws NoSuchElementException{
			if (!hasNext()) throw new NoSuchElementException();
				last = index;
				return InterfaceCollection.this.m[index++]; 
		}		
		@Override
		public void remove() throws UnsupportedOperationException , IllegalStateException {
			if(last == -1)
				throw new IllegalStateException("Next method has not yet been called.");
				InterfaceCollection.this.remove(m[last]);
				index--;
				last = -1;
		}		
	}	
}
			/**
			 * TEST from KoValevskiy!!!
			 */

/*
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class ArrayCollectionTest {

    @Test
    public void testSizeWhenSizeIs0() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.remove(1);
        assertEquals(0, testInstance.size());
    }

    @Test
    public void testSizeWhenSizeIs1() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(10);
        assertEquals(1, testInstance.size());
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.remove(1);
        assertTrue(testInstance.isEmpty());
    }

    @Test
    public void testIsEmptyWhenIsNoEmpty() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(10);
        assertFalse(testInstance.isEmpty());
    }

    @Test
    public void testContains() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);

        assertTrue(testInstance.contains(1));
        assertFalse(testInstance.contains(0));
    }
    @Test
    public void testIterator() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        for (int i = 3; i < 15; i++) {
            testInstance.add(i);
        }
        int i = 0;
        System.out.println("\n testIterator");
        System.out.format("Size: %s\n", testInstance.size());
        for (final Integer iT : testInstance) {
            System.out.format("Element %s: %s \n", i++, iT);
        }
        if (i != testInstance.size()) {
           throw new RuntimeException("ElementsIterator don't working!!!!");
        }
    }

    @Test
    public void testToArray() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        for (int i = 1; i < 15; i++) {
            testInstance.add(i);
        }
        testInstance.remove(10);
        testInstance.remove(8);
        if (testInstance.toArray().length != testInstance.size()) {
            throw new RuntimeException("The returned array does not match the length of the collection.");
        }
    }

    @Test
    public void testAdd() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        for (int i = -10; i < 15; i++) {
            testInstance.add(i);
        }

        assertEquals(25, testInstance.size());
        assertFalse(testInstance.isEmpty());

    }

    @Test
    public void testRemoveFirstElement() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.remove(1);

        assertEquals(1, testInstance.size());
        assertFalse(testInstance.isEmpty());
    }

    @Test
    public void testRemoveCenterElement() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);
        testInstance.add(4);
        testInstance.add(5);
        testInstance.remove(3);

        assertEquals(4, testInstance.size());
        assertFalse(testInstance.isEmpty());
    }

    @Test
    public void testRemoveLastElement() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);
        testInstance.add(4);
        testInstance.remove(4);

        assertEquals(3, testInstance.size());
        assertFalse(testInstance.isEmpty());
    }

    @Test
    public void testContainsAll() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        final Collection<Integer> testInstance2 = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);

        testInstance2.add(2);
        testInstance2.add(1);

        assertTrue(testInstance.containsAll(testInstance2));
    }

    @Test
    public void testAddAll() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        final Collection<Integer> testInstance2 = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);

        testInstance2.add(3);
        testInstance2.add(4);
        testInstance.addAll(testInstance2);

        assertTrue(testInstance.contains(3));
        assertTrue(testInstance.contains(4));
    }

    @Test
    public void testRemoveAll() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        final Collection<Integer> testInstance2 = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);
        testInstance.add(4);

        testInstance2.add(2);
        testInstance2.add(3);

        testInstance.removeAll(testInstance2);

        assertEquals(2, testInstance.size());
        assertTrue(testInstance.contains(1));
        assertFalse(testInstance.contains(2));
    }

    @Test
    public void testRetainAll3() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        final Collection<Integer> testInstance2 = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);
        testInstance.add(6);
        testInstance.add(7);
        testInstance.add(8);
        testInstance.add(9);

        testInstance2.add(3); //0 size1
        testInstance2.add(4); //1 size2
        testInstance2.add(5); //2 size3
        testInstance2.add(6); //3 size4

        testInstance.retainAll(testInstance2);

        assertEquals(2, testInstance.size());
        assertTrue(testInstance.contains(3));
        assertFalse(testInstance.contains(4));
        assertFalse(testInstance.contains(5));
        assertTrue(testInstance.contains(6));
    }

    @Test
    public void testRetainAll2() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        final Collection<Integer> testInstance2 = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);
        testInstance.add(4);
        testInstance.add(5);
        testInstance.add(6);
        testInstance.add(7);
        testInstance.add(8);
        testInstance.add(9);

        testInstance2.add(3); //0 size1
        testInstance2.add(4); //1 size2
        testInstance2.add(5); //2 size3
        testInstance2.add(6); //3 size4

        testInstance.retainAll(testInstance2);

        assertEquals(4, testInstance.size());
        assertTrue(testInstance.contains(3));
        assertTrue(testInstance.contains(4));
        assertTrue(testInstance.contains(5));
        assertTrue(testInstance.contains(6));
    }

    @Test
    public void testRetainAll1() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        final Collection<Integer> testInstance2 = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);
        testInstance.add(3);
        testInstance.add(3);
        testInstance.add(6);
        testInstance.add(7);
        testInstance.add(8);
        testInstance.add(9);

        testInstance2.add(3); //0 size1
        testInstance2.add(4); //1 size2
        testInstance2.add(5); //2 size3
        testInstance2.add(6); //3 size4

        testInstance.retainAll(testInstance2);

        assertEquals(4, testInstance.size());
        assertTrue(testInstance.contains(3));
        assertTrue(testInstance.contains(6));
    }

    @Test
    public void testClear() {
        final Collection<Integer> testInstance = new ArrayCollection<>();
        testInstance.add(1);
        testInstance.add(1);

        testInstance.clear();

        assertTrue(testInstance.isEmpty());
        assertEquals(0, testInstance.size());
    }
}
*/
