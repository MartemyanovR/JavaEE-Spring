package patterns;

public class ProxyClassMath implements ProxyInterfaceMath{
	public double mult(double x, double y) {
		return x*y;
	}
	
	public double sub(double x, double y) {
		return x/y;
	}
	

}
