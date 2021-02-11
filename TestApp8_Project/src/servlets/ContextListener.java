package servlets;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.User;
import utils.Utils;

@WebListener
public class ContextListener implements ServletContextListener {
	
	private Map<Integer,User> users;
	
	/**
	 * создаем начальные данные до инициализации сервлетов
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
	
		final ServletContext context = sce.getServletContext();
		users = new ConcurrentHashMap<>();
		context.setAttribute("users", users);
		final User user = Utils.createStubUser(1, "First", 10);
		this.users.put(user.getId(), user);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//close resource
		users = null;		
	}
	
	

}
