package cook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetterCookies
 */
@WebServlet("/GetterCookies")
public class GetterCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetterCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession();
		String msg = "";
		String sessionId = session.getId();
		Date sessionCreat = new Date(session.getCreationTime());
		Enumeration<String> sessionIter = session.getAttributeNames();
		if (session.isNew()) {
			msg = "Welcome to this page";
        } else {
        	msg = "Glad to see You again";
        }		
		Cookie[] cookies = request.getCookies();   //запрос кук на сервере			
		
		response.setContentType("text/html");
		try(PrintWriter writer = response.getWriter()) {
			writer.println("<p>" +  msg  + "</p>");
			writer.println("<p> Session ID: "+ sessionId + "</p>");
			writer.println("<p> Time create session: "+ sessionCreat + "</p>");
			
			if (cookies != null) {						//если массив кук не пуст
				for (Cookie c : cookies ) { 				//обходим его
					writer.println("<p> Value cookie: "+ c.getValue() + "</p>");
					//эти данные получить не взможно
				   /* writer.println("<p> Domain cookie: "+ c.getDomain() + "</p>");
				    writer.println("<p> Age cookie: "+ c.getMaxAge() + "</p>");
				    writer.println("<p> Age cookie: "+ c.getPath() + "</p>");  */
				}				
			}
			else {
					System.out.println("Cookies not found");
					writer.println("<p>Cookies not found</p>");				   
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
