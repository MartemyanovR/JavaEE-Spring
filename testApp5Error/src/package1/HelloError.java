package package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloError
 */

public class HelloError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloError() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	//by zero (���������� � error.jsp)
		int a=0;
		int b=1;
		int c = b/a;	*/
		
		// Analyze the servlet exception       
	      Throwable throwable = (Throwable)
	      request.getAttribute("javax.servlet.error.exception");
	      Integer statusCode = (Integer)
	      request.getAttribute("javax.servlet.error.status_code");
	      System.out.println(statusCode);
	      String servletName = (String)
	      request.getAttribute("javax.servlet.error.servlet_name");
	         
	      if (servletName == null) {
	         servletName = "Unknown";
	      }
	      String requestUri = (String)
	      request.getAttribute("javax.servlet.error.request_uri");
	      
	      if (requestUri == null) {
	         requestUri = "Unknown";
	      }

	      // Set response content type
	      response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
	      String title = "Error/Exception Information";
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
	         
	      out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor = \"#f0f0f0\">\n");

	      if (throwable == null && statusCode == null) {
	         out.println("<h2>Error information is missing</h2>");
	         out.println("Please return to the <a href=\"" + 
	            response.encodeURL("http://localhost:8080/") + 
	            "\">Home Page</a>.");
	      } else if (statusCode != null) {
	         out.println("The status code : " + statusCode);
	      } else {
	         out.println("<h2>Error information</h2>");
	         out.println("Servlet Name : " + servletName + "</br></br>");
	         out.println("Exception Type : " + throwable.getClass( ).getName( ) + "</br></br>");
	         out.println("The request URI: " + requestUri + "<br><br>");
	         out.println("The exception message: " + throwable.getMessage( ));
	      }
	      out.println("</body>");
	      out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
