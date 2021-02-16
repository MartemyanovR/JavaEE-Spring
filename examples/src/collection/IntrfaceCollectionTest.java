package collection;

import java.awt.Button;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class IntrfaceCollectionTest {
	 @Test
	    public void testSizeWhenSizeIs0() {
	        final Collection<Integer> testInstance = new InterfaceCollection<>();
	        testInstance.add(1);
	        testInstance.remove(1);
	        assertEquals(0, testInstance.size());
	    }	

	    @Test
	    public void testToArrayWhenInputArrayHaveSizeOne() {
	        final Collection<Integer> testInstance = new InterfaceCollection<Integer>();
	        testInstance.add(1);
	        testInstance.add(2);
	        testInstance.add(3);

	        final Integer[] input = new Integer[1];
	        
	        final Integer[] result = testInstance.toArray(input);
	        assertNotEquals(input, result);
	        assertEquals((Integer)1, result[0]);
	        assertEquals((Integer)2, result[1]);
	        assertEquals((Integer)3, result[2]);
	        assertEquals(3, result.length);
	    }
	public static void main(String ... args) {
		Result result = JUnitCore.runClasses(IntrfaceCollectionTest.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	        // System.out.println(failure.getTrace());
	      }
	      System.out.println("Result=="+result.wasSuccessful());
		
		InterfaceCollection<Integer> interColl = new InterfaceCollection<>();
		InterfaceCollection<Integer> interColl2 = new InterfaceCollection<>();
		
		Random r = new Random();
        final Collection<Integer> testInstance = new InterfaceCollection<>();
        final Integer[] controlArray = {r.nextInt(99)
                , r.nextInt(99)
                , r.nextInt(99)
                , r.nextInt(99)
                , r.nextInt(99)};       
        testInstance.addAll(Arrays.asList(controlArray));
        System.out.println(testInstance.size());
        Integer[] arr = new Integer[testInstance.size()];
        
		//for(int i=1; i<15; i++)
		interColl.add(1);
		interColl.add(2);
		interColl.add(3);
		interColl.add(4);
		interColl.add(5);
		interColl.add(6);
		System.out.println(interColl.size());
		//interColl.toArray(arr);
		System.out.println(Arrays.deepToString(interColl.toArray(new Integer[6])));
		final Iterator<Integer> iter = interColl.iterator();
		interColl.display();
		iter.next();		
		iter.remove();		
		interColl.display();
		System.out.println(Arrays.deepToString(interColl.toArray(new Integer[1])));
		System.out.println(interColl.toArray(new Integer[1]).getClass().getName());
	}
}
