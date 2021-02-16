package collection;

import java.util.Iterator;

public class studentTest {
	public static void main(String[] args) {
		final int studentCount = 100;
		Student[] student = new Student[studentCount];
		for(int i = 0; i < studentCount; i++)
			student[i] = new Student("1");		
		Student[] student1 = {new Student("1"),new Student("1")};
		final University univer = new University(student);
		//final University univer1 = new University(student1);
		//final Iterator<Student> studentIterator = univer.iterator(); 
		//int y = 0;
		try {
		for(Student stud : univer) {
			System.out.format("Student %s \n", stud.toString());
			//y++;
		}
	}catch(NullPointerException e) {
		System.out.println("Warning, put null element");
		System.out.println(e);
		}
		//System.out.println(y);
		//for(Student stud : univer1) 
			//System.out.format("Student %s \n", stud.toString());
	}
}
