package generics.ekkel.genInterface;

import java.util.Iterator;
import java.util.Random;

/*
 * CoffeeGenerator  реализует интерфейс lterable, что позволяет использовать его в конструкции foreach.
 */
public class CoffeeGenerator implements Generator<Coffe>, Iterable<Coffe> {
	
	private Class[] types = { Latte.class, Mocha.class,
		Cappuccino.class, Americano.class, Breve.class, };
	private static Random rand = new Random(47);
	
	public CoffeeGenerator() {}
	
	// Для перебора:
	private int size = 0;
	public CoffeeGenerator(int sz){ size = sz; }
	
	public Coffe next() { 
		try {
			return (Coffe) types[rand.nextInt(types.length)].newInstance();
			// Сообщить программисту об ошибках во время выполнения:
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	class CoffeeIterator implements Iterator<Coffe> { 
		int count = size;
		public boolean hasNext() { return count > 0; } 
		public Coffe next() { 
			count--;
			return CoffeeGenerator.this.next();
		}
		public void remove() { // Не реализован
			 throw new UnsupportedOperationException();
		}
	}
	public Iterator<Coffe> iterator() {
		return new CoffeeIterator();
	}
		
	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();
		for(int i = 0; i < 5; i++)
			System.out.println(gen.next());
		//работает только с реализацией Iterator, а так же CoffeeGenerator должен реализовывать Iterable
		for(Coffe c : new CoffeeGenerator(5))
			System.out.println(c);
		
		//реализация foreach расширенная
		for(Iterator<Coffe> i = new CoffeeGenerator(5).iterator(); i.hasNext();) {
			Coffe item = i.next();
			System.out.println(item);
		}
		
		
	}
	
}
