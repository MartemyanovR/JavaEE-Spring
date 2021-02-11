package package1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(name = "HelloServlet" , urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
	private String index = "/index.html";
	private static final long serialVersionUID = 1L;
       
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();			
			String name =request.getParameter("username");
			String age =request.getParameter("userAge");
			String gender =request.getParameter("gender");
			String country =request.getParameter("country");
			String[] courses =request.getParameterValues("courses");
			
			try {
			writer.println("<p>Name:" + name + "</p>");
			writer.println("<p>Age:" + age + "</p>");
			writer.println("<p>Gender:" + gender + "</p>");
			writer.println("<p>Country:" + country + "</p>");
			writer.println("<h4>Courses</h4>");
			if(courses != null) {
				for(String s : courses) {
					writer.println("<li>" + 
							 s + "</li>");					
				}
			}	
			}finally {
				writer.close();
			}	
			
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		request.getRequestDispatcher(index).forward(request, response);
		doPost(request, response);
	}
	
	
	
	
}
