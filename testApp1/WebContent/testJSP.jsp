<% 
String header = "User list";		
String[] hello = new String[10]; 
double d = -9;
%>
<%@ page import = "java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> <%=header  %> </h1>
	<p> 2 + 2 = <%= 2+2%> </p>
	<p> 5 > 2 = <%= 5>2%> </p>
	<p><%= new String("Hello").toUpperCase() %> </p>
	<p> <%= new Double(Math.abs(d)) %>  </p>
	<p> Today <%= new Date() %></p>
	<p> <% for(int i = 0; i < hello.length ; i++) {
					hello[i] = "Hello" + i; 			
					}%> </p>
	<ul>
	 <% for(String s : hello){
		out.println("<li>" + s + "</li> <br>" ); 		 
	 }			 
	  %>
	</ul>
</body>
</html>