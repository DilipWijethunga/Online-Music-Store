<%@page import="com.oop.model.Customers"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.CustomerServiceImpl"%>
<%@page import="com.oop.service.ICustomerService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel = "stylesheet" type = "text/css" href = "css/ListSongs.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Song Management</title>
</head>

<body>

	 <p class="topic" >List of Registered Customers</p>
		 
     <a class = "btn" href="RegistrationHomeView.jsp">Register Customer</a>

	 <table cellspacing="0" cellpadding="0" class="center" id = "songs">
		 
		  <tr>
                <th>Customer ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Gender</th>
                <th>Email</th>
                <th>UserName</th>
                <th>Password</th>
                <th>Select</th>
            </tr>
            <%
            ICustomerService iCustomerService = new CustomerServiceImpl();
			ArrayList<Customers> arrayList = iCustomerService.getCustomers();
			
			for(Customers customer : arrayList){
			%>
			 <tr>
				<td> <%=customer.getCustomerID() %> </td>
				<td> <%=customer.getCustomerName() %> </td>
				<td> <%=customer.getCustomerPhone() %> </td>
				<td> <%=customer.getCustomerAddress() %> </td>
				<td> <%=customer.getGender() %> </td>	
				<td> <%=customer.getCustomerEmail() %> </td>
				<td> <%=customer.getUserName() %> </td>											
				<td> <%=customer.getPassword() %> </td>
				
				<td> 
				<form method="POST" action="GetCustomerServlet">
				<input type="hidden" name="customerID" value="<%=customer.getCustomerID()%>"/>
				 <input type="submit" value= "Select Customers" class="select-button" /> 
				 </form>
				 </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
		</div>
		
</body>
</html>