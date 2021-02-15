package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import utils.Utils;

/**
 * Servlet implementation class AddUserServlet
 */
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<Integer,User> users;
	private AtomicInteger id;
       
	@Override
	public void init() throws ServletException {
		final Object users = getServletContext().getAttribute("users");		
		this.users = (ConcurrentHashMap<Integer,User>) Utils.checkUserOnNullAndInit(users);
		id = new AtomicInteger(2);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		final String name = request.getParameter("name");
		final String age = request.getParameter("age");	
		
		
		if(Utils.requestValid(request,name,age)) {						
			final int id = this.id.getAndIncrement();
			final User user = Utils.createStubUser(id,name, Integer.valueOf(age));
			users.put(id, user);
					
		}
		
		//этот метод отправляет клиенту в браузер  что необходимо сделать новый запрос 
		response.sendRedirect(request.getContextPath() + "/" );
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
