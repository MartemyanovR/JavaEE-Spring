package nature;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Zoo {
		
/*	@Autowired
	@Qualifier("cat")*/
	private Animals dog;
	private Animals cat;
	private Animals bird;	
	
	@Value(value = "${nameZoo}")
	private String nameZoo;
	@Value("${address}")
	private String address;
	@Value("${number}")
	private int number; 
	
	public Zoo() {}
	
	@Autowired
	public Zoo(@Qualifier("dogi") Animals dog, @Qualifier("cat") Animals cat, @Qualifier("bird") Animals bird) {
		this.dog = dog;
		this.cat = cat; 
		this.bird = bird;
			
	}
	
/*	@Autowired	
	public Zoo(@Qualifier("dogi") Animals a) {
		this.dog = a;
	}*/
	
	public String askMe() {
		return cat.volume() ; /*dog.volume(); + " " + 
				" " + cat.volume() +  " " +  bird.volume();*/
	}
	
	public String moveMe(ChooseAnimal choose) {
		Random random = new Random();
		switch(choose) {
		case DOG :
			 return dog.getmove(random.nextInt(3));
		case CAT :
			 return cat.getmove(random.nextInt(3));
		case BIRD :
			 return bird.getmove(random.nextInt(3));
		}
		return null;
	}

/*	//c Autowired название метода не имее значение
	@Autowired
	public Animals setAnimals(@Qualifier("cat") Animals animal) {
		this.cat = animal;
		return animal;
	}
	*/
	
	public Animals getAnimal() {
		if(dog != null) 
			return dog;
		else if(cat != null)
			return cat;
		return bird;
	}
	
	public String toString() {
		return "Zoopark"  ;
	}
	public String getNameZoo() {
		return nameZoo;
	}

	public String getAddress() {
		return address;
	}

	public int getNumber() {
		return number;
	}
	
	
	
	
}
