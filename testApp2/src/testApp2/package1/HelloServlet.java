package testApp2.package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(urlPatterns = "/HelloServlet", initParams = @WebInitParam(name = "id", value = "1"))
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������������� ���� id - null!
		 String id = request.getParameter("id");
	        if(id == null) {	             
	            String path = request.getContextPath() + "/notFound";
	            response.sendRedirect(path);
	        }
	        else {
	            response.setContentType("text/html");
	            PrintWriter writer = response.getWriter();
	            try {
	            	writer.println("<h2>Value ID define</h2>");
	                writer.println("<h2>Hello Id " + id + "</h2>");
	            } finally {
	                writer.close();  
	            }
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
