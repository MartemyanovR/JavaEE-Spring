package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import package1.DemoEJB;

public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //Аннотация над полем класса — @EJB осуществляет инъекцию зависимости (DI)
	//Переменная ejb автоматически инициализируется новым экземпляром, когда это потребуется. 
	@EJB
    private DemoEJB demoEJB;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write(DemoEJB.hello());
	}


}
