package innerClasses;

public class UniversityTest {

	public static void main(String[] args) {
		University univ = new University("KUBGU", "Stavropol'skaya_99");
		University.Student stud1 = University.creratStudent(univ, "Roman", 2);
		University.Student stud2 = University.creratStudent(univ, "neRoman", 3);
		University.Student stud3 = University.creratStudent(univ, "neman", 1);
		univ.showAllStudents();
	}

}
