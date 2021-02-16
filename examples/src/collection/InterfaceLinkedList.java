package collection;

import java.util.*;

public class InterfaceLinkedList<T> implements List<T> {

   private Item<T> firstInList = null;
	private Item<T> lastInList = null;
	private int size = 0;	
	
	@Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    @Override
    public int indexOf(final Object o) {
	    // BEGIN (write your solution here)
    	int index = 0;
    	if(o == null) {
    		for(Item<T> temp = firstInList; temp != null; temp = temp.nextItem) {
    		if(temp.element == null) {
    			return index;
    		}
    		index++;
    	}    		
   	} 	else {
    		for(Item<T> temp = firstInList; temp != null; temp = temp.nextItem) {
    			if(temp.element == null  ? o == null : temp.element.equals(o)) {
    				return index;
    			}
    			index++;
    		}
    	}    		
        return -1;
	    // END
    } 

    @Override
    public boolean contains(final Object o) {
	    // BEGIN (write your solution here)
		return indexOf(o) != -1 ? true : false;
	    // END
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator(0);
    }

    @Override
    public Object[] toArray() {
 	    // BEGIN (write your solution here)
    	Item<T> current = firstInList;    	
    	Object[] obj = new Object[size];
    	int index = 0;
    	while(current != null) {
    		obj[index++] = current.element;
    		current = current.nextItem;
    	}
        return obj;
	    // END
    }

    @Override
    public <T1>  T1[]  toArray(T1[] a) {
	    // BEGIN (write your solution here)
    	if(a.length < this.size) 
			a = (T1[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);			
    	Object[] temp = a;
    	Item<T> current =  firstInList;
    	int index = 0;	
		while(current != null) {
			temp[index++] = current.element;
	    	current = current.nextItem;    		
	    }
		if(a.length > this.size)
			temp[size] = null;
		return a;		
       // END
    }

   	    @SuppressWarnings("unchecked")
		@Override
	    public boolean add(final T newElement) {
		    // BEGIN (write your solution here)
	    	if(size() == 0) {
	    		Item<T> item = new Item<>(newElement, null, null);
		    	firstInList = item;		    	
		    	lastInList =item;
		    }
		    else {
		    	Item<T> item = new Item<>(newElement, null, lastInList);
		    	lastInList.nextItem = item;
		    	lastInList = item;
		    	}		
	    	size++;
		    return true;
		    // END
	    }

    @Override
    public boolean remove(final Object o) {
	    // BEGIN (write your solution here)
    	Item<T> temp;
    	for(temp = firstInList; temp != null; temp = temp.nextItem)
    		if(temp == firstInList && temp.element == o) {
    			removeFirst();
    			size--;
    			return true;
    		} else if(temp == lastInList && temp.element == o) {
    			removeLast();
    			size--;
    			return true;
    		} else if(temp.element == o) {
    			temp.prevItem.nextItem = temp.nextItem;
            	temp.nextItem.prevItem = temp.prevItem;
            	size--;
    			return true;
    		}    	
	    return false;
	    // END
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        for (final T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (final T item : this) {
            if (!c.contains(item)) this.remove(item);
        }
        return true;
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)
        firstInList = lastInList =  null;
        size = 0;
        // END
    }

    @Override
    public T remove(final int index) throws IndexOutOfBoundsException{
        // BEGIN (write your solution here)
    	if (index > size) throw new IndexOutOfBoundsException();
    	Item<T> temp = getItemByIndex(index);
    	remove(temp.element);
    	return temp.element;
        // END
    }

    private void remove(final Item<T> current) throws IndexOutOfBoundsException {
        // BEGIN (write your solution here)
        remove(getItemByIndex(indexOf(current.element)).element);
        // END
    }

    @Override
    public List<T> subList(final int start, final int end) {
	    return null;
    }

    @Override
    public ListIterator<T> listIterator() {
	    return new ElementsIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(final int index) {
	    return new ElementsIterator(index);
    }

    @Override
    public int lastIndexOf(final Object target) {
	    throw new UnsupportedOperationException();
    } 

    @Override
    public void add(final int index, final T element) {
	    throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(final int index, final Collection elements) {
	    throw new UnsupportedOperationException();
    }

    @Override
    public T set(final int index, final T element) throws IndexOutOfBoundsException {
        // BEGIN (write your solution here)
    	Item<T> temp = getItemByIndex(index);
    	T oldVal = temp.element;
    	temp.element =  element;
        return oldVal;
        // END
    }

    @Override
    public T get(final int index) {
        // BEGIN (write your solution here)
       	return getItemByIndex(index).element;
        // END
    }
    
    public T getFirst() {
        // BEGIN (write your solution here)
        return firstInList.element;
        // END
    }

    private Item<T> getItemByIndex(final int index) {
        // BEGIN (write your solution here) An auxiliary method for searching for node by index.
    	if(index < 0 && index > size) throw new IndexOutOfBoundsException("Invalid array index");
    	int index1 = 0; 
    	Item<T> temp;
    	for(temp = firstInList; temp != null; temp = temp.nextItem)
    		if(index == index1++)
    			break;
    	return temp;
        // END
    }
    
    private void removeFirst() {
    	if(firstInList==lastInList) lastInList = null;
    	else firstInList.nextItem.prevItem = null;
    	firstInList = firstInList.nextItem;
    }

    private void removeLast() {
    	lastInList.prevItem.nextItem = null;
    	lastInList = lastInList.prevItem; 
    }
    
    public void display() {
    	Item<T> current = firstInList;
    	System.out.print("[ ");
    	while(current != null) {
    		System.out.print(current.element + " ");
    		current = current.nextItem;
    	}
    	System.out.print("] \n");
    }

   private class ElementsIterator implements ListIterator<T> {

        private Item<T> currentItemInIterator;

        private Item<T> lastReturnedItemFromIterator;

        private int index;

        ElementsIterator(final int index) {
            // BEGIN (write your solution here)
        	if(size < index)
				throw new ArrayIndexOutOfBoundsException("Specified index is greater then size array");
        	find(index);
        	// END
        }

        private void find(int index2) {
        	if(index2 < 0) throw new RuntimeException("Wrong value index");
        	currentItemInIterator = firstInList; 
        	while(this.index != index2) {
        		next();
        	}		
        	lastReturnedItemFromIterator = null;
		}

		@Override
        public boolean hasNext() {
            // BEGIN (write your solution here)
        	return index < size;
            // END
        }

        @Override
        public T next() {
            // BEGIN (write your solution here)
        	if (!hasNext()) throw new NoSuchElementException();
        	lastReturnedItemFromIterator = currentItemInIterator;
        	index++;
        	if (currentItemInIterator.nextItem == null) {        		
        		return currentItemInIterator.element;
        	} else {
        	currentItemInIterator = currentItemInIterator.nextItem;
        	return lastReturnedItemFromIterator.element;
        	}
        	// END
        }

         @Override
        public boolean hasPrevious() {
            // BEGIN (write your solution here)
        	if(index == 0) return false;        		
        	return index > 0;            
            // END
        }

        @Override
        public T previous() {
            // BEGIN (write your solution here)
        	if (!hasPrevious()) throw new NoSuchElementException();
        	if(!hasNext()) {
        		index--;
        		return currentItemInIterator.element;
        	}
        	currentItemInIterator = currentItemInIterator.prevItem;
        	lastReturnedItemFromIterator = currentItemInIterator;
        	index--;
        	return currentItemInIterator.element;        	
        	// END
        }

        @Override
        public void add(final T element)  throws UnsupportedOperationException, IllegalArgumentException {
           throw new UnsupportedOperationException();
        }

        @Override
        public void set(final T element) {
            // BEGIN (write your solution here)
        	if(lastReturnedItemFromIterator == null) throw new IllegalStateException();	
        	try {
        	lastReturnedItemFromIterator.element = element;
        	} catch(UnsupportedOperationException  | IllegalArgumentException e1) {
        		e1.printStackTrace();
        	}
            // END
        }

        @Override
        public int previousIndex(){
            // BEGIN (write your solution here)
            if(index <= 0) return -1;
            return index-1;
            // END
        }

        @Override
        public int nextIndex() {
            // BEGIN (write your solution here)
        	if(index >= size) return size;
        	return index;
            // END
        }

        @Override
        public void remove() {
            // BEGIN (write your solution here)
        	if(lastReturnedItemFromIterator == null) throw new IllegalStateException("neither next"
        			+ " nor previous have been called, or remove or add have been called"
        			+ " after the last call to next or previous");        	
            if(lastReturnedItemFromIterator == firstInList) {
            	removeFirst();
            	currentItemInIterator = firstInList;
            }
            else if(lastReturnedItemFromIterator == lastInList) {
            	removeLast();
            	currentItemInIterator = lastInList;            	
            }
            else	removeMiddle();
            index--;
			size--;
            lastReturnedItemFromIterator = null;
        	// END
        }
       
        private void removeMiddle() {
        	lastReturnedItemFromIterator.prevItem.nextItem = lastReturnedItemFromIterator.nextItem;
        	lastReturnedItemFromIterator.nextItem.prevItem = lastReturnedItemFromIterator.prevItem;
        	currentItemInIterator = lastReturnedItemFromIterator.prevItem;
        }        
    }
	
	private static class Item<T> {
		
		private T element;
		private Item<T> nextItem;
		private Item<T> prevItem;
		
		public Item(final T element, final Item<T> nextItem, final Item<T> prevItem) {
			this.element = element;
			this.nextItem = nextItem;
			this.prevItem = prevItem;
		}
		public Item<T> getNextItem() {
			return nextItem;
		}
		public Item<T> getPrevItem() {
			return prevItem;
		}
		
	}
}
