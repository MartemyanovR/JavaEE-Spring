package generics.wildCardTest;

import java.util.List;

public class Rectangle extends Shape {

	@Override
	void draw(Canvas c) {
		System.out.println("Rectangle");		
	}
	
	public void  addRectangle(List<? extends Shape> shapes) {	    
		/*
		 * Поскольку мы не знаем, какой это тип (<? extends Shape>), мы не знаем,
		 *  является ли он супертипом REctangle.
		 */
	  // shapes.add(0, new Rectangle()); // Compile-time error!
	
		//это работает, так как мы знаем что <? extends Shape> это в любом случае обьект типа Object
		shapes.get(0);
	}

}
