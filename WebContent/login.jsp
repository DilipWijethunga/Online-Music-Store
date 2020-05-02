<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="log" method="post">
<table style="background-color:gray;margin-left:240px;margin-top:120px;">
<tr>
<td>
<h3 align="center">login</h3>
</td>
        <td></td>
       <tr>
         <td>Email :</td>
         <td><input type="text"name="email"></td>
         </tr>
<tr>
     <td>Password :</td>
     <td><input type="Password"name="password"></td>
     </tr>
<tr><td><input type="submit"name="submit"value="login"></td><td><a href="forgot.jsp">forgotPassword?</a></td></tr>

</table>
</form>

</body>
</html>