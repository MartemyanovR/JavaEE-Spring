package collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class InterfaceListTest {
	@Test
    public void testAddInIteratorWhenIsNotEmptyListToTheBeginning() {	
		final InterfaceList<Integer> testInstance = new InterfaceList<>();
        final ListIterator<Integer> listItrTest =  testInstance.listIterator();	
        testInstance.add(0);
        testInstance.add(0);
        testInstance.add(0);
        listItrTest.add(1);
        assertSame("previousIndex ",0, listItrTest.previousIndex());
        assertSame("nextIndex ",1, listItrTest.nextIndex());
        assertSame("previous element ", 1, listItrTest.previous());
        assertSame("Get first element ",1, testInstance.get(0));
        assertEquals("size",4, testInstance.size());
    }
	
		@Test(expected = NoSuchElementException.class)
	    public void testSizeWhenSizeIs0() {
	        final InterfaceList<Integer> testInstance = new InterfaceList<>();
	        final ListIterator<Integer> listItrTest =  testInstance.listIterator();	        
	        	listItrTest.add(1);
	        	listItrTest.next();
	        	listItrTest.remove();
	          }	
	public static void main(String[] args) {
		
		
		Result result = JUnitCore.runClasses(InterfaceListTest.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	         System.out.println(failure.getTrace());
	      }
	      System.out.println("Result=="+result.wasSuccessful());
		
		
		final InterfaceList<Integer> iList = new InterfaceList<>();
		final ListIterator<Integer> listItr =  iList.listIterator();
		iList.add(1);
		iList.add(3);
		iList.add(4);
		listItr.next();
		listItr.next();
		System.out.println(listItr.next());	
		listItr.set(5);
		iList.display();
		System.out.println(listItr.previous());		
		listItr.set(2);
		iList.display();
	}

}
