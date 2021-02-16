package innerClasses;

public class HumanApp {
public static void main(String[] args) {
		
		// создали объект вложенного класса Relations
		 Human.Relations hr = new Human.Relations("married");
		
		System.out.println(hr.getRelatons());
	
		// создали объект внешненго класса Human
		 Human h = new Human();
		
		// присвоили объект hr полю relations обекта h
		h.relations = hr;
		
		System.out.println(h.relations.getRelatons());
		
	}

}
