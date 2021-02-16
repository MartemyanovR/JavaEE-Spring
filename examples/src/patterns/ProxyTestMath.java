package patterns;

public class ProxyTestMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProxyInterfaceMath mat = new ProxyClassProxyMath();
		System.out.println (mat.mult(5, 9));
		System.out.println(mat.sub(10,2));

	}

}
