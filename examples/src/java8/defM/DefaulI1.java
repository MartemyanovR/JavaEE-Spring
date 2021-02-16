package java8.defM;

public interface DefaulI1 {
	long getId();
	
	default String getName() {
		System.out.println("DefaulI1");
		return getClass().getName();
	}
}
