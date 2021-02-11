package servlets;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import utils.Utils;

/**
 * Servlet implementation class UpdateUsersServlet
 */
public class UpdateUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<Integer,User> users;
	private final String index = "WEB-INF/view/update.jsp";
	
	@Override
	public void init() throws ServletException {
		final Object users = getServletContext().getAttribute("users");
		this.users = (ConcurrentHashMap<Integer,User>) Utils.checkUserOnNullAndInit(users);
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//нажиая на кнопку "edit" мы отправляем сюда id
		final String id = request.getParameter("id");	
		
		if(!(id != null && request.getParameter("id").chars().allMatch(Character::isDigit)&& id != "")) {
			response.sendRedirect(request.getContextPath() + "/");
		}
		final User user = users.get(Integer.parseInt(id));
		request.setAttribute("user", user);
		request.getRequestDispatcher(index).forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		final String id = request.getParameter("id");
		final String name = request.getParameter("name");
		User user = users.get(Integer.parseInt(id));
		user.setName(name);
		response.sendRedirect(request.getContextPath() + "/");
	}

}
