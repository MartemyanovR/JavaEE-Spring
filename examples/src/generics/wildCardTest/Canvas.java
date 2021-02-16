package generics.wildCardTest;

import java.util.List;

public class Canvas {

	public void draw(Shape s) {
		s.draw(this);
	}
	
	
	//этот метод закреплен к типу List<Shape>, мы не можем ввызвать его для List<Circle>
	public void drawAll(List<Shape> lShape) {
		for (Shape p : lShape) {
			p.draw(this);
		}
	}
	//Теперь drawAll () будет принимать списки любого подкласса Shape
	public void drawAllWild(List<? extends Shape> lShape) {
		for (Shape p : lShape) {
			p.draw(this);
		}
	}

}
