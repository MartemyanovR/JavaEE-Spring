package covariance;

public class CovarianceTest {
	
	public static void main(String[] args) {
		/*переопределенный метод производного класса может вернуть тип,
		 *  производный от типа, возвращаемого методом базового класса. 
		 *  обратите внимание: ковариантными могут быть возвращаемые значения, но не типы аргументов
		 */
	
	Shape s = new BuildShape().build();
	System.out.println(s);
	Circle s1 = new BuildeCircle().build();
	System.out.println(s1);
	
	
	}

}
