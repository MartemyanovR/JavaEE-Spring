package polimorphism;

import java.util.Iterator;
import java.util.Random; 
/**
 * Измените пример polymorphisnVshape/RandomShapeGenerator.java, чтобы он реализовал Iterable.
 *  Для этого необходимо добавить конструктор, получающий количество элементов, 
 *  которые должен создать итератор перед остановкой. Убедитесь в том, что пример работает.
 * @author Roman
 *
 */

public class RndomShapeGenerator implements Iterable<Shape> {
	Random gen = new Random();
	private int count;
	
	public RndomShapeGenerator(final int count) {
		this.count = count;
		
		//либо создавать обьекты в конструкторе, и обходить их в итераторе
		//через public Shape next() {return shapes[index++];}
		/*shapes = new Shape[count];
        for (int i = 0; i < count; i++) {
            shapes[i] = next();*/
	}
	
	public Shape next() {
		switch (gen.nextInt(3)) {
		default:
		case 0 : return new Square();
		case 1 : return new Triangle();
		case 2 : return new Cycle();
		 }		
	}

	@Override
	public Iterator<Shape> iterator() {
		return new Iterator<Shape>() {
			int index;
			@Override
			public boolean hasNext() {				
				return RndomShapeGenerator.this.count > index;
			}
			@Override
			public Shape next() {	
				index++;
				return RndomShapeGenerator.this.next();
			}			
		};
	}

}
