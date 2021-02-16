package annotation.testAnnotation2;

public class MainTest {

	public static void main(String[] args) {
		try {
			Sample2 s2 = new Sample2();
			Sample2 s3 =s2.clone();
			System.out.println(s2.equals(s3));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
