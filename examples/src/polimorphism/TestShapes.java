package polimorphism;

import java.util.ArrayList;
import java.util.List;

import covariance.Circle;

public class TestShapes {	

	private static RndomShapeGenerator rsg = new RndomShapeGenerator(5);

	public static void main(String[] args) {
		List<Shape> listShape = new ArrayList<>();
		for(Shape shape : rsg) {
			listShape.add(shape);
		}
		for(Shape shape : listShape) {
			shape.draw();
		}
		
		Shape[] shape = new Shape[9];		
		for(int i = 0; i < shape.length; i++) {
		shape[i] = rsg.next();
	}
		for (Shape s : shape) {
			s.draw();
		}	
		//работать не будет
	/*	Shape[] shape1 = new Cycle[9];
		for(int i = 0; i < shape1.length; i++) {
			shape1[i] = new Shape();
		}
			for (Shape s : shape1) {
				s.draw();
		}*/
			/*// супер тип исппользует обьект подкласса через Cycle
			Shape st = new Triangle();
			Cycle superC = new  Cycle();
			Cycle sp = new UniCycle();
			Cycle cb = new BiCycle();
			Cycle ct = new Tricycle();
			superC.ride();
			sp.ride();
			cb.ride();
			ct.ride();		
			sp.draw();
			*/	
	}
}
