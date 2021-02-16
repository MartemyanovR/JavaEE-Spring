package patterns;

public class ProxyClassProxyMath implements ProxyInterfaceMath {
	// private ProxyClassMath math = new ProxyClassMath();    //почему не так, а через метод?
	private ProxyClassMath math; 
	
	public double mult(double x, double y) {
		lazyInitMath();
		return math.mult(x,y);
	}
	
	public double sub(double x, double y) {
		lazyInitMath();
		return math.sub(x,y);
	}
		
	
	private void lazyInitMath() {		
		if(math==null)
			math = new ProxyClassMath();
	}

}
