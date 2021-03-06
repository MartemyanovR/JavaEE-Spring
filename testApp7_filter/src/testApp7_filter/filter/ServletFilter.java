package testApp7_filter.filter;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/ServletFilter")
public class ServletFilter implements Filter {
	private FilterConfig config;
	private static ArrayList<String> pages;  //��������� �������
	
	
	public ServletFilter() {
		if(pages == null) {
			pages = new ArrayList<String>();
		}
	}
	
	/*
	 * ��� ������������� ������� � ������ init(FilterConfig) ������������ �������� ������������,
	 *  ������� �������� ���� ���������� ������� "active", ������������ � ����������� ���������� web.xml.
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}

	
	/*
	 *  ���� ��������� ����������� � ���, ��� ���� ����������� ���� �� �� �������� main.jsp,
	 *  �� ������������ �������� ����������� � ��������� pages. ���� ����������� �������� main.jsp,
	 *  �� ����������� �������� �� ������� � ��������� ������� ����������� ��� �����������.
	 *   ��� ������� ���������� ��������, ������ ��������� ������ ��������, 
	 *   � ��������� ������ �������������� �� �������� �����������.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//���� ������ ��������
		if(config.getInitParameter("actve").equalsIgnoreCase("true")) {
			//��������� ��������
			//����� ����� �������
			HttpServletRequest req = (HttpServletRequest)request;
			//������������ ����� �� ������������
			String[] list = req.getRequestURI().split("/");			
			//���������� ������������� ��������
			String page = null;
			//���� � ���� � ��� ���� jsp ����, �� ����������� ��� page
			if(list[list.length - 1].indexOf(".jsp") > 0) {
				page = list[list.length-1];
			}
			//���� ����������� ������� ��������
			if(page!=null && page.equalsIgnoreCase("main.jsp")) {
				//��������� ��������
				// ���� ���� �������������� ������� ���� �� ������� 
                // login.jsp ��� registration.jsp, �� �������� ����������
                // ���������� �������� ������� �������
				if(pages.contains("login.lsp") || pages.contains("registration.jsp")) {
					chain.doFilter(request, response);
					return;
				} else {
					//��������������� �� �������� login.jsp
					ServletContext scx = config.getServletContext();
					RequestDispatcher dispatcher = scx.getRequestDispatcher("/login.jsp");
					dispatcher.forward(request, response);
					return;
				}
			} else if(page != null) {
				//��������� �������� � ������
				if(!pages.contains(page)) {
					pages.add(page);
				}
			}	
			chain.doFilter(request, response);
		}	
	}

	
	/**
     * ����� ������������ ��������
     * @see Filter#destroy()
     */
	@Override
	public void destroy() {
		
		config = null;
	}

}
