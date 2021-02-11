<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Title update</title>
<style type="text/css">
   .block1 { 
    width: 200px; 
    background: #ccc;
    padding: 5px;
    padding-right: 20px; 
    border: solid 1px black; 
    float: left;
   }   
  </style> 
</head>
<body>	
	<div class="block1"><p>name: <c:out value="${requestScope.user.name}"/></p>
		 				<p>age: <c:out value="${requestScope.user.age}"/></p>
    </div>
	<br />	
	<form method="post" action="<c:url value='/update'/>">
			<label>New name: <input type="text" name="name" value="" /></label><br>
			<input type="number" hidden name="id" value="${requestScope.user.id}"/>
			<input type="submit" name="OK" value="OK"/>
	</form>	
</body>
</html>