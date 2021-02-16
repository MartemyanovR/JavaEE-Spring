package example;

import java.io.Serializable;

public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T<Job> t = new T<>();
		t.setT(new Job());
		System.out.println(t.getE(new Integer(5)));
		//t.setT((byte)130);
		t.doJob();
		
		T<ChildJob> t1 = new T<>();
		t1.setT(new ChildJob());
		t1.doJob();
	}
}
	class Job implements Serializable{
		void doIt() {
			System.out.println("This job");
		}
	}
	class ChildJob extends Job {
		
	}

	class  T<T extends Job & Serializable > {
		private T t;		
		//<X> T (X x){}
		public <E> E getE(E e) {return e;}
		public void setT(T t) {this.t = t;}
		public void doJob(){
			t.doIt();
		}
	}
	interface X{};
	interface Y{};
	class Gif{};
	class Parc <T extends Gif & Y,X>{};   //один обобщенный параметр с ограниченими, всего 2 дженерик параметра
	
