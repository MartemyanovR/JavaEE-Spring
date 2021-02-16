package innerClasses;

import java.util.Iterator;

public class DataStructureTest {

	 public static void main(String[] args) {
	    	DataStructure data = new DataStructure();
	    	Iterator<DataStructure> iter= data.iterator();
	    	iter.hasNext();
	    	data.getme().meth();
	    }
}
