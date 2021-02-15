package nature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestZoo {

	public static void main(String[] args) {
			@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("applicationContext.xml");		
		
		
	//used postConstruction and preDestroy->for destroy need close context
		Animals bird = context.getBean("bird", Bird.class);
		context.close(); 
		
			// scope
/*		Dog dog = context.getBean("dogi", Dog.class);		
		Dog dog2 = context.getBean("dogi", Dog.class);		
		System.out.println(dog==dog2);
		Cat cat = context.getBean("cat", Cat.class);
		Cat cat2 = context.getBean("cat", Cat.class);
		System.out.println(cat == cat2); 
		
		//task Enum value
		Zoo zoo = context.getBean("zoo", Zoo.class);
		System.out.println(zoo.moveMe(ChooseAnimal.CAT));
		System.out.println(zoo.moveMe(ChooseAnimal.DOG));
		System.out.println(zoo.moveMe(ChooseAnimal.BIRD));
		//property
		System.out.println(zoo.getNameZoo() + ", " + zoo.getAddress() + "," +  zoo.getNumber());
		City city = context.getBean("city", City.class);
		System.out.println(city);		
				
		//DI through autowired annotation
		Zoo zoo = context.getBean("zoo", Zoo.class);		
		zoo.askMe();		
		context.close();
		
		//example with used component annotation
		Animals cat = context.getBean("cat" , Cat.class);
		Zoo zoo = new Zoo();
		zoo.setAnimals(cat);
		System.out.println(zoo.askMe());
		
		Animals dog = context.getBean("dogi" , Dog.class);
		Zoo zoo2 = new Zoo(dog);
		System.out.println(zoo2.askMe());*/
		
	}

}
