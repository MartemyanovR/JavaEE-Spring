package jvm;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HeapTest {
	 public static void main(String ... args) throws Exception {
	        Integer[] x = IntStream.range(0, 1_000_000).boxed().toArray(Integer[]::new);
	        Thread.sleep(6000000);
	        Stream.of(x).forEach(System.out::println);
	    }
}
