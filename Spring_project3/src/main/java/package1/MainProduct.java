package package1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainProduct {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
			

		Store store = (Store) context.getBean("store");
		store.doing();		
		System.out.println(store.toString());		
		context.close();
		
		
		
				
	}

}
