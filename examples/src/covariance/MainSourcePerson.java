package covariance;

import java.io.Serializable;

import javax.swing.JButton;

public class MainSourcePerson {
	
	//нужно понять как сравнить emp с обобщенным классом ISource<Integer>
	
	public static void main(String[] args) {
		ISource<Employee> emp = new Source<>();
		ISource<Employee> emp1 = new Source<>();
		System.out.println(emp.equals(emp1));
		JButton jb = new JButton();
		//Type mismatch: cannot convert from Object & Serializable & Comparable<?> to JButton
		//jb = getMiddle("1",0, new Source);
	}
	public static <T> T getMiddle(T ...a) {
		return a[a.length / 2];
	}
	//ограничение на перемененную T 
	public static <T extends Number & Comparable<T>> T min(T[] a) {
		if(a == null || a.length == 0) return null;
		T smallest = a[0];
		for(int i=1; i<a.length; i++)
			if(smallest.compareTo(a[i]) > 0) smallest = a[i];
			return smallest;
		}
}
