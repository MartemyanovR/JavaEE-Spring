package collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class University implements Iterable<Student>{
	
	private final Student[] student;
	
	public University(Student[] student) {
		this.student = student;
	}
	
	public Iterator<Student> iterator(){
		List<Student> printStudent = Arrays.asList(student);
		return printStudent.iterator();
	}

}
