package exception;

import java.io.IOException;

public class CheckedMyException {

	/*
	 * Напишите класс с методом, который возбуждает исключение, созданное вами
	 *  в упражнении 4. Попробуйте откомпилировать его без спецификации исключений
	 *  и посмотрите, что «скажет» компилятор. После этого добавьте необходимую 
	 *  спецификацию исключений. Протестируйте свой класс и его исключение внутри блока try-catch.
	 */
	//указывем что метод может генерировать несколько исключений
	public void checkMeth(final Integer i) throws MyException, MyException2, MyException3 // без генерации спецификации исключения 
											   //- Unhandled exception type MyException
	{
		//генерируем(возбуждаем) исключения, при разных условиях 
		System.out.println("CheckedMyException.checkMeth()");
		if(i < 0) throw new MyException(" i less then zero");
		if(i == 0) throw new MyException2("i equal zero"); 		
		if(i > 0) throw new MyException3("i above zero");		
		
	}
	
	public void Meth(final Integer i) throws MyException2, MyException3 {
		try {
			if(i < 0) throw new MyException(" i less then zero");
			if(i == 0) throw new MyException2("i equal zero"); 		
			if(i > 0) throw new MyException3("i above zero");		
		}
		catch(MyException  e) {
			e = new MyException();
		}
		//если использовать мульти блок, то ссылочная переменная e1 становится final
		catch(MyException2 | MyException3  e1) {
		//	e1 = new MyException();
		}
	}
	
}
