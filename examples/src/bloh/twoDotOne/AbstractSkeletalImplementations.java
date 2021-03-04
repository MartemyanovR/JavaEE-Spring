package bloh.twoDotOne;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class AbstractSkeletalImplementations {

	public static void main(String[] args) {
		int[] a = {4,32,2,1};
 		List<Integer> al = intArrayAsList(a);
 		System.out.println(al.get(1));

	}
	
	static List<Integer> intArrayAsList(int[] a) {
		Objects.requireNonNull(a);
		// Оператор "ромб" о корректен здесь только в Java 9
		//и более поздних версиях. При использовании более
		// ранних версий указывайте <Integer>
		return new AbstractList<Integer>() {
			@Override public Integer get(int i)
			{
				System.out.println("!!!");
				return a[i]; // Автоупаковка (раздел 2.6)
			}
			@Override public Integer set(int i, Integer val) {
				int oldVal = a[i];
				a[i] = val; // Автораспаковка
				return oldVal; // Автоупаковка
			}
			@Override public int size()
			{
				return a.length;
			}
		};
	}

}
