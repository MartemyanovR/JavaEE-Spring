package clone;

public class MainClone {

	public static void main(String[] args) {
		UserClone user = new UserClone(1,"RedStreet", new AdressClone("GreenStreet",1));
		System.out.println(user.toString());
		UserClone user2 = null;
		try {
			user2 = user.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		user2.setId(2);
		user2.setArrClone(0, 10);
	//	user2.setName("Red");
		user2.getAddress().setHouse(2);
		System.out.println(user.toString());
		System.out.println(user2.toString());
		
	}

}
