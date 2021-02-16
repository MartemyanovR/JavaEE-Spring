package innerClasses;

import java.util.Iterator;

public class DataStructure implements Iterable<DataStructure>{

	 @Override
	    public Iterator<DataStructure> iterator() {
		 	int em = this.new Me().me;
	        return new InnerEvenIterator();
	    }
	 public DataStrucutreAbstract getme() {
		 return new Me();
	 }
	    // ...        

	    private class InnerEvenIterator implements Iterator<DataStructure> {
	        // ...    
	        public boolean hasNext() { // Why public?
	            // ...
	            return false;
	        }

	        @Override
	        public DataStructure next() {
	            throw new UnsupportedOperationException("Not supported yet.");
	        }

	        @Override
	        public void remove() {
	            throw new UnsupportedOperationException("Not supported yet.");
	        }
	    }
	    private  class Me extends DataStrucutreAbstract{
	    	private int me = 0;
			@Override
			public void meth() {
				System.out.println("Inner Me");
				
			}
	    	
	    }
	    
	    public static void main(String[] args) {
	    	DataStructure data = new DataStructure();
	    	Iterator<DataStructure> iter= data.iterator();
	    	iter.hasNext();
	    }
}
