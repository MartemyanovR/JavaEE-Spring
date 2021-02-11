<%!
	String getName(String name) {
		return name;
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>declaration jsp</title>
</head>
<body>
	
		<p> <%= getName("<li>Roman</li>") %> </p>	
		<ul>
			<% for(int i = 0; i< 5; i++)
				out.println(getName("<li>Roman</li>"));
					%>
		</ul>
		

</body>
</html>