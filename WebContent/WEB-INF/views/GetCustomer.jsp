<%@page import="com.oop.model.Customers"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>

<head>
<link rel = "stylesheet" type = "text/css" href = "css/AddSongs.css" />
<meta charset="UTF-8">
<title>Music Management</title>
</head>

<body>

	<jsp:include page="/WEB-INF/views/RegistrationHeader.jsp"></jsp:include>

	<% Customers customer = (Customers) request.getAttribute("customer"); %>

	<form method="POST" action="UpdateCustomerServlet">
		
		<div class="container">
	    <h1>Update Customer Details</h1>
	    <hr>
		
		 <label class = "labels"><b>Customer ID   </b></label>	    
	     <input type="text" class="inputs" name="customerID" disabled="disabled"
					value="<%=customer.getCustomerID()%>" />
		 <br>
		
		
		 <label class = "labels"><b>Name    </b></label>	    
		 <input type="text" class="inputs" name="customerName"	value="<%=customer.getCustomerName()%>" /></td>
		 <br>	
			
		 <label class = "labels"><b>Phone    </b></label>	
		 <input type="text" class="inputs"  name="customerPhone"	value="<%=customer.getCustomerPhone()%>" /></td>
		 <br>

         <label class = "labels"><b>Address    </b></label>
		 <input type="text" class="inputs"  name="customerAddress" value="<%=customer.getCustomerAddress()%>" /></td>
			
		
		
		
		<label class = "labels"><b>Gender</b></label>
		
		<label class = "label">Male
			<input type="radio" name="gender" value="male" checked="checked"  tabindex="1" /> 
			<span class="checkmark"></span>
			</label> 
			
			<label class = "label">Female
			<input type="radio" name="gender" value="female" tabindex="2" /> 
			<span class="checkmark"></span>
			</label>
			<br>

		<br><br>
		
		
		<label class = "labels"><b>Email    </b></label>
		<input type="text" class="inputs"  name="customerEmail" value="<%=customer.getCustomerEmail()%>" /></td>
		<br>
		
		<label class = "labels"><b>UserName    </b></label>
		<input type="text" class="inputs"  name="UserName" value="<%=customer.getUserName()%>" /></td>
		<br>

		<label class = "labels"><b>Password    </b></label>
		<input type="text" class="inputs"  name="password" value="<%=customer.getPassword()%>" /></td>
		<br>
	
		<input type="hidden" name="customerID" value="<%=customer.getCustomerID()%>" /> 
		
		<input type="submit" value="Update Employee" class="btn"/></td>

	</form>


	<form method="POST" action="DeleteCustomerServlet">
		<input type="hidden" name="customerID" value="<%=customer.getCustomerID()%>" /> 
		<input type="submit" value="Delete Employee" class="btn"/>
	</form>

	</div>

	<jsp:include page="/WEB-INF/views/RegistrationFooter.jsp"></jsp:include>

</body>
</html>