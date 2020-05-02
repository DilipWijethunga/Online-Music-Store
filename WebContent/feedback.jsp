<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="feedback">
   <form action="insert" method = "post">
   <table style="background-color:gray;margin-left:240px;margin-top:80px;">
<tr><td><input type="text" name="nm" placeholder = "enter name" autofocus></td></tr>
<tr><td><input type="text" name="email" placeholder = "enter email"></td></tr>
<tr><td><textarea name="msg" placeholder = "Enter message"></textarea></td></tr>
<tr><td><input type = "submit"  name ="sab" value = "send" align ="center" ></td></tr>
<tr><td><input type = "reset" name = "reset" value = "Reset"></td></tr>

  </table> 
   
   </form>

</div>
</body>
</html>