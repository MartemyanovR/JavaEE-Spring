package innerClasses;

import innerClasses.Static_InnerClass.InnerStat;;

public class StaticInnerClassTest {

	public static void main(String[] args) {
		//ожно при импорте внутреннего класса
		InnerStat inx = new  InnerStat(5,5);
		// создаем ссылку на статический внутренний класс, и вызываем обьект статического внутренего класса
		//через метод minMax
		Static_InnerClass.InnerStat in = Static_InnerClass.minMax();
		in.showResult();
		Static_InnerClass.InnerStat.OutShow(new Static_InnerClass());

	}

}
