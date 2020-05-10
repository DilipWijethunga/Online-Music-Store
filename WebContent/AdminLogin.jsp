<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/AdminLogin.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/AdminLogin.js" type="text/javascript"> </script>
<title>Admin Login Page</title>

				
</head>

<body>

	<button onclick="document.getElementById('id01').style.display='block'" class="login" >Login</button>
	
	<div id="id01" class="modal">
  
	  	<form class="modal-content animate" action="LoginCheck.jsp" method="post">
	    
		    <div class="imgcontainer">
		      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
		      <img src="images/AdminLogin.png" alt="Avatar" class="avatar">
		    </div>
		
		    <div class="container">
		     
		      <label for="uname"><b>Username</b></label>
		      <input type="text" id="username" placeholder="Enter Username" name="username" required>
		
		      <label for="psw"><b>Password</b></label>
		      <input type="password" id="password" placeholder="Enter Password" name="password" required>
		      
		      <input type="checkbox" onclick="myFunction()">Show Password
		      
		      <button id="validation" >Login</button>
		
		    </div>
		
		    <div class="container" style="background-color:#f1f1f1">
		    <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
		    </div>
	    
	  </form>
	</div>
	
	
	

</body>
</html>