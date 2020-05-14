<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
		<tr>
			<th>ItemID</th>
			<th>SongID</th>
			<th>Title</th>
			<th>Album</th>
			<th>Artist</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>action</th>
		
		</tr>

			<tr>
			<form action="${pageContext.request.contextPath}/CartControllerServlet" method="post">
				<td><input type="text" name="itemid"></td>
				<td><input type="text" name="songid"></td>
				<td><input type="text" name="title"></td>
				<td><input type="text" name="album"></td>
				<td><input type="text" name="artist"></td>
				<td><input type="text" name="quantity"></td>
				<td><input type="text" name="price"></td>
				<td><button type="submit" >Add Item</button></td>
			</form>
			</tr>
			
		
	
	
	</table>




</body>
</html>