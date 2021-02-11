<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First JSP-file</title>
</head>
<body>
	<h1>Testing JSP</h1>
	<%@ page import="java.util.Date, testApp2.package1.LogicJSP" %>
	<%LogicJSP logic = new LogicJSP(); %>	
	<p><%= logic.getName("Roman") %></p>
	<p><%= logic.getTime(new Date()) %></p>
	
</body>
</html>