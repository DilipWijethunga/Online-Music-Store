<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table>
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
	
			<th><input type="text" name="itemid"></th>
			<th><input type="text" name="songid"></th>
			<th><input type="text" name="title"></th>
			<th><input type="text" name="album"></th>
			<th><input type="text" name="artist"></th>
			<th><input type="text" name="quantity"></th>
			<th><input type="text" name="price"></th>
			<th><button type="submit">Save Item</button></th>
	</form>
		
	</tr>

	</table>
	
</body>
</html>