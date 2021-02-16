package innerClasses;

import java.util.List;
import java.util.ArrayList;

/**  Модуль 8. Урок 2. Inner (non-static) классы в Java. 
 * 
 * @author Roman
 *
 */

public class University {
	private final String name;
	private  final String address;
	private final List<Student> students;
	
	public University(final String name, final String address) {
		this.name = name;
		this.address = address;
		students = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public List<Student> getStudents() {
		return students;
	}
	
	void showAllStudents() {
		System.out.println("Student list: ");
		for(Student s : students) {
			System.out.println(s);
		}		
	}
	
	static University.Student creratStudent(University univ, final String name, final int grade) {
		 return univ.new Student(name,grade);
	}
	
	 class Student {
		private final String name;
		private final int grade;
		
		public Student (final String name, final int grade) {
			this.name = name;
			this.grade = grade;			
			students.add(this);
		}

		public String getName() {
			return name;
		}

		public int getGrade() {
			return grade;
		}
		public String toString() {
			return String.format("name: %s , grade: %d", name, grade);
		}
		public University getUniversity() {
			return University.this;
		}
	 }
}
