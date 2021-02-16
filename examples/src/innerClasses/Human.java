package innerClasses;

public class Human {
		 Relations relations;
		 static  int i = 5;
		  int j = 5;
		 
		 
		public static class Relations extends Human  {

			private String relations;

			Relations(String relations) {
				this.relations = relations;
				Human.i = 9;
				j = 5;
			}

			String getRelatons() {
				return relations;
			}

		}
		
		public static void main (String[] args) {
			Relations r = new Relations("A");
			Human h = new Human();
			r = (Relations)h;
			
			System.out.println(Human.i);
			
			Object obj = new java.util.Date();
	        Integer int1 = (Integer) obj;
		}

}
