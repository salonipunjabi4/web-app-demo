<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	boolean result = (boolean)request.getAttribute("status");
	if(result){
		out.print("Login Successful!");
	}else{
		out.print("Id and password did not match!");
	}
	%>
</body>
</html>