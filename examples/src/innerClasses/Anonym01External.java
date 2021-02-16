package innerClasses;

public class Anonym01External {
	static String str = "Anonym01External";
	// конструктор
	Anonym01External(){}
	Object getThis() {return this;}
	//объявление анонимного класса представляет собой выражение, если без static, то stackOverFlow
	//То есть мы можем использовать его как часть другого выражения
	
	 static Anonym01External ext = new Anonym01External() {
		};
	}
