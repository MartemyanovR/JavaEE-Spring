<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List citys</title>
</head>
<body>
	<table>
		<tr>
			<th>CityCode</th>
			<th>CityName</th>
			<th>Peoples</th>		
		</tr>
	<c:forEach items="${listCity}" var="city">
		<tr>
			<td><c:out value="${city.cityCode}"/></td>
			<td><c:out value="${city.cityName}"/></td>
			<td><c:out value="${city.peoples}"/></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>