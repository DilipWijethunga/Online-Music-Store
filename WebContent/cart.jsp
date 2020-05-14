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

	<button onclick="window.location.href='addtocart.jsp'"> Add item</button>
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
			
		<c:forEach items="${list}" var="cart">
			
			<tr>
				<td>${cart.itemid}</td>
				<td>${cart.songid}</td>
				<td>${cart.title}</td>
				<td>${cart.album}</td>
				<td>${cart.artist}</td>
				<td>${cart.quantity}</td>
				<td>${cart.price}</td>
				<td><a href="${pageContex.request.contexPath}/CartControllerServlet?action=EDIT&id=${cart.itemid}">Edit</a></td>
			</tr>
		</c:forEach>
	
	
	</table>




</body>
</html>