package java8.linkOfConstructor;

public class LambdaApp {
	
	 public static void main(String[] args) {
		 
    	 CreaterUser<User> userBuilder = User::new;
    	 //При использовании конструкторов методы функциональных интерфейсов должны принимать тот же список параметров,
    	 // что и конструкторы класса, и должны возвращать объект данного класса.
	     User user = userBuilder.create("Tom");
	     System.out.println(user.getName());
	     
	     CreatorUserTwoArgs userTwoArgs = User::new;
	     User userTwo = userTwoArgs.create("Bob", "Marley");
	     System.out.println(userTwo.getName() + " " + userTwo.getLName());
	     
	     CreaterUser<User> userBuilderUsersurrogate = (name) -> new Usersurrogate(name);
	     User userSurrogate = userBuilderUsersurrogate.create("Surrogate");
	     System.out.println(userSurrogate.getName());
	     System.out.println(userSurrogate.getClass().getName());
	 }

}
