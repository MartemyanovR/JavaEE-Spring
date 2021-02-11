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
 * Servlet implementation class DeleteUsserServlet
 */
public class DeleteUsserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<Integer,User> users;
	
	@Override
	public void init() throws ServletException {
		final Object users = getServletContext().getAttribute("users");
		this.users = (ConcurrentHashMap<Integer,User>) Utils.checkUserOnNullAndInit(users);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		
		if(id != null && id.chars().allMatch(Character::isDigit) && id != "")
			users.remove(Integer.valueOf(id));
		response.sendRedirect(request.getContextPath() + "/");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
