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
	private static ArrayList<String> pages;  //хранилище страниц
	
	
	public ServletFilter() {
		if(pages == null) {
			pages = new ArrayList<String>();
		}
	}
	
	/*
	 * При инициализации фильтра в методе init(FilterConfig) определяется параметр конфигурации,
	 *  который содержит флаг активности фильтра "active", определенный в дескрипторе приложения web.xml.
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}

	
	/*
	 *  Суть обработки заключается в том, что если выполняется вход не на страницу main.jsp,
	 *  то наименование страницы сохраняется в хранилище pages. Если открывается страница main.jsp,
	 *  то выполняется проверка на наличие в хранилище страниц авторизации или регистрации.
	 *   При удачном результате проверки, сервер открывает нужную страницу, 
	 *   в противном случае перенаправляет на страницу авторизации.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//если фильтр активный
		if(config.getInitParameter("actve").equalsIgnoreCase("true")) {
			//выполняем проверку
			//берем копию запроса
			HttpServletRequest req = (HttpServletRequest)request;
			//раскладываем адрес на состовляющие
			String[] list = req.getRequestURI().split("/");			
			//извлекааем наименлование страницы
			String page = null;
			//если в пути у нас есть jsp файл, то присваеваем его page
			if(list[list.length - 1].indexOf(".jsp") > 0) {
				page = list[list.length-1];
			}
			//если открывается главная страница
			if(page!=null && page.equalsIgnoreCase("main.jsp")) {
				//выполняем проверку
				// Если была предварительно открыта одна из страниц 
                // login.jsp или registration.jsp, то передаем управление
                // следующему элементу цепочки фильтра
				if(pages.contains("login.lsp") || pages.contains("registration.jsp")) {
					chain.doFilter(request, response);
					return;
				} else {
					//перенаправление на страницу login.jsp
					ServletContext scx = config.getServletContext();
					RequestDispatcher dispatcher = scx.getRequestDispatcher("/login.jsp");
					dispatcher.forward(request, response);
					return;
				}
			} else if(page != null) {
				//добавляем страницу в список
				if(!pages.contains(page)) {
					pages.add(page);
				}
			}	
			chain.doFilter(request, response);
		}	
	}

	
	/**
     * Метод освобождения ресурсов
     * @see Filter#destroy()
     */
	@Override
	public void destroy() {
		
		config = null;
	}

}
