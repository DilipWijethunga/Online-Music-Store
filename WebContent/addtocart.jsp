<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



			<p>${message}</p>

			
	<form action="${pageContext.request.contextPath}/CartControllerServlet" method="post">
	
			
			SongID<input type="text" name="songid" value="${cart.songid}"/><br/>
			Title<input type="text" name="title" value="${cart.title}"/><br/>
			Album<input type="text" name="album" value="${cart.album}"/><br/>
			Artist<input type="text" name="artist" value="${cart.artist}"/><br/>
			Quantity<input type="text" name="quantity" value="${cart.quantity}"/><br/>
			Price<input type="text" name="price" value="${cart.price}"/><br/>
			<input type="hidden" name="itemid" value="${cart.itemid}"/>
			<button type="submit">Save Item</button></th>
	</form>
		
	

	
	
</body>
</html>