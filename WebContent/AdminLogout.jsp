<%@ page contentType="text/html; charset=iso-8859-1" language="java" %> 

<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

<title>JSP Page</title> 

</head> 

<body> 

<% 
	session.removeAttribute("username"); 
	session.removeAttribute("password"); 
	session.invalidate(); 
	
	response.sendRedirect("AdminLogin.jsp"); 
%>
	
</body> 

</html>

