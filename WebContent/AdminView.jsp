<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Admin</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/AdminView.css" rel="stylesheet" type="text/css" media="all" />

</head>


<body>

	<br><br><br><br><br>
	<a class = "btn" href="AddSongs.jsp">Administrator Login</a>
	
    <a class = "btn" href="RegistrationHomeView.jsp">Register Customers</a>
    
	<a class = "btn" href="F:/SLIIT/Year 02/Information Technology/IT2030 - Object Oriented Programming/08. JSP & Servlets/Online-Music-Store/WebContent/WEB-INF/views/ListCustomers.jsp">List All Registered Customers</a>

	<a class = "btn" href="AddSongs.jsp">Add Songs</a>
	
	<a class = "btn" href="WEB-INF/views/ListSongs.jsp">List All Songs</a>
	
    <a class = "btn" href="AdminLogout.jsp">Logout</a>
    

	<ul class="slideshow">
		<li><span></span></li>
	    <li><span></span></li>
		<li><span></span></li>
		<li><span></span></li>
		<li><span></span></li>
	</ul>

</body>

<!-- 	
    	String a = session.getAttribute("username").toString();
        out.println("Hello  " + a);
    %>
     -->
</html>


