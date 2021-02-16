package polimorphism;

public class WheatMillTestCovariant {
	public static void main (String [] args) {
	Grain g;
	Wheat w;
	WheatMill wm = new WheatMill();
	Mill mw  = new WheatMill();
	Mill m = new Mill();
	//ковариантности возвращаемьис типов; этот термин означает, что переопределенный метод 
	//производного класса может вернуть тип, производный от типа, возвращаемОго методом базового класса.
	//Ковариантность возвращаемых типов позволяет вернуть более специализированный тип Wheat.
	 g = wm.process();
	 System.out.println(g);
	 
	 g = m.process();
	System.out.println(g);
	//происходит нисходящее преобразование типа
	// w = mw.process();
	//работает с приведением
	w = (Wheat)mw.process();
	g = mw.process();
	 System.out.println(g);
	
	
	}
}
