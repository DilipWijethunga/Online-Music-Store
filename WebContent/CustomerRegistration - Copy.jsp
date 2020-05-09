<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Registration</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css/Registration.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
<!-- //web font -->
</head>


<body class="body">

	<jsp:include page="/WEB-INF/views/RegistrationHeader.jsp"></jsp:include>

		
		<div class="container">
		
		<p align="center" class="signup">SignUp</p>

		<form method="POST" action="AddCustomerServlet">
			
			
			<input class="text" type="text" name="customerName" placeholder="Name" required=""><br>
			
			
			<input class="text" type="text" name="customerPhone" placeholder="Phone"><br>
			
			
			<input class="text" type="text" name="customerAddress" placeholder="Address"><br>
			
			<br>
			<label class = "label">Gender</label> <br> <br>
			
			<label class = "labels">Male
			<input type="radio" name="gender" value="male" checked="checked"  tabindex="1" /> 
			<span class="checkmark"></span>
			</label> 
			
			<label class = "labels">Female
			<input type="radio" name="gender" value="female" tabindex="2" /> 
			<span class="checkmark"></span>
			</label>
			<br>
			
		
			<input class="text" type="email" name="customerEmail" placeholder="Email"><br>
			
			
			<input class="text" type="text" name="UserName" placeholder="UserName"><br>
			
			
			<input class="text" type="password" name="password" placeholder="Password"><br>
				

			<input class="button" type="submit" value="SIGNUP">

			<input class="button" type="reset" value="Reset">		
									
		</form>
		</div>


</body>
</html>

