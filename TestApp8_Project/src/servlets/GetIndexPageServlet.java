package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import utils.Utils;


/**
 * Servlet implementation class GetIndexPageServlet
 */
public class GetIndexPageServlet extends HttpServlet {
	private final String index = "WEB-INF/view/index.jsp";
	private static final long serialVersionUID = 1L;
	private Map<Integer, User> users;

	@Override
	public void init() throws ServletException {
		//достаем атрибут который инициализировали в контексте
		final Object users = getServletContext().getAttribute("users");
		this.users = (ConcurrentHashMap<Integer,User>) Utils.checkUserOnNullAndInit(users);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//возвращаем список значений Map
		request.setAttribute("users", users.values());
		request.getRequestDispatcher(index).forward(request, response);
	}

}
