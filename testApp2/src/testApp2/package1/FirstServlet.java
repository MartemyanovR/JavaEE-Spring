package testApp2.package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
//������������� URL in web.xml ������� ���������
@WebServlet("/notUse")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    //��������� javax.servlet.ServletConfig ������������ ��� �������� ���������������� ���������� ��������
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet name: " + config.getServletName() 
										+ "\nSerlet versoin: " + config.getInitParameter("version"));
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		
		request.getRequestDispatcher("firstJSP.jsp").forward(request, response);
		
		// � �������� ��������� ������ ����� ��������� ����� �������������. 
		//����� ����� ���� ���������, ����������, � ����� ���� � �������.
	//	response.sendRedirect(path);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
