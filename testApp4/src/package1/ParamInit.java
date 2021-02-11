package package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamInit
 */
@WebServlet(urlPatterns="/ParamInit", 
	initParams = {
		@WebInitParam(name = "firstNam", value="Roman"),
		@WebInitParam(name="lastNam", value="Martemyanov")
		}
)
public class ParamInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamInit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*генерирует ошибку и отправляет пользователю
		response.sendError(403, "Access denied!!!");*/
		
		ServletContext context = getServletContext();
		String firstName = getInitParameter("firstName");
		String lastName = getInitParameter("lastName");
		if (firstName == null && lastName == null) {
			//перенаправление
		//	request.getRequestDispatcher("/ParamNotFound").forward(request, response);
			//переадреация
			String path = request.getContextPath() + "/ParamNotFound";
			response.sendRedirect(path);  
		}
		response.setContentType("text/html");
		try(PrintWriter print = response.getWriter()) {
			print.println("<h2>Your name: " + firstName + "<h2>");
			print.println("<h2>Your lastName: " + lastName + "<h2>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
