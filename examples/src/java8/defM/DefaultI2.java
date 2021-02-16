package java8.defM;

public interface DefaultI2 {
//	long getId();
	
	default long getId() {
		return 11111;
	}
	
	default String getName() {
		System.out.println("DefaulI2");
		return getClass().getName();
	}

}
