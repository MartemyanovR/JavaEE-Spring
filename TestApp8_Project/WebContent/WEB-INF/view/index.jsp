<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD</title>
</head>
<body>
	<h1>Working users</h1>
	<h2>All users</h2>
	<c:forEach var="user" items="${requestScope.users}">	
		
		<li>Name: <c:out value="${user.name}"/></li>
		<li>Age: <c:out value ="${user.age}"/></li>	
		<form action="<c:url value='/delete'/>" method="post" >
			<input type="number" hidden name="id" value="${user.id}"/>
			<input type="submit" name="delete" value="Delete"/>
		</form>
		<form  action="<c:url value='/update'/>" method="get" >
			<input type="number" hidden name="id" value="${user.id}"/>
			<input type="submit" name="update" value="Edit"/>
		</form>		
		
	<hr />
	</c:forEach>
	
	<h2>Create new user</h2>
	<form action='<c:url value="/add_user"/>' method="post" >
		<input type="text" name="name" value="">Name<br/> 
		<input type="number" name="age" value="">Age<br/>
		<input type="submit" value="OK" name="OK"><br/>	
	</form>
		
</body>
</html>