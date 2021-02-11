<% String exception = pageContext.getException().getMessage();
	String message = pageContext.getException().getClass().toString();	
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Exception occurred while processing the request</h2>
<p> Type <%= exception %></p>
<p>Message: <%= message %></p>
</body>
</html>