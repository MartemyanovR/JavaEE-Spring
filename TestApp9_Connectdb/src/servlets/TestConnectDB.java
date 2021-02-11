package servlets;

import java.sql.Statement;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import package1.City;
import package1.ConnectionDB;

public class TestConnectDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionDB connectJDBC;
	
	@Override
	public void init() throws ServletException {
		connectJDBC = new ConnectionDB();
		System.out.println("!!!!!!!!!!!!");		
		}

   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<City> listCity = new ArrayList<>();
		if(request.getCharacterEncoding() == null) {
		    request.setCharacterEncoding("UTF-8");
		}
		System.out.println(request.getCharacterEncoding());
		try(Connection connect = connectJDBC.getConnection()) {
			String sql = "SELECT * FROM CITY";
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(sql);				
			while(rs.next()) {
				City city = new City();
				city.setCityCode(rs.getInt("CITYCODE"));
				city.setCityName(rs.getString("CITYNAME"));
				city.setPeoples(rs.getLong("PEOPLES"));	
				listCity.add(city);
			}				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//отправляем данные в jsp
		request.setAttribute("listCity", listCity);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher requestDisp = getServletContext().getRequestDispatcher("/list.jsp");
		requestDisp.forward(request, response);
	}

	
}
