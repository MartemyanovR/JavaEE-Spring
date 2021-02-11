package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import package1.IHelloWorld;

/**
 * Servlet implementation class NewServle
 */
@WebServlet("/sayHello")
public class NewServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Следует обратить внимание, что компонент EJB (hello) не инициализируется, а сразу же вызывается его метод.
	@EJB
	private IHelloWorld helloW;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String answer = helloW.sayHello(req.getParameter("name"));
			req.getSession().setAttribute("answer", answer);
			RequestDispatcher rd;
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		} catch(Exception e) {
			throw new ServletException(e.getMessage());
			//e.printStackTrace();
		}
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}



}
