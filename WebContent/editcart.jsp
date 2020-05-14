
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

<c:forEach var="song" items="${songDetails}">
                    <h1 class="title">Cart</h1>

                    <table class="songdetails">
                        <thead>
                            <tr>
                                <th>Song ID</th>
                                <th>Song Title</th>
                                <th>Price</th>
                                <th>Album</th>
                                <th>Artist</th>
                                <th>Quantity</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                        
                            <tr>
                            <form action="editcart" method="post">
                            
                                <td class="sdetails"><input type="text" value="${cart.songid}" READONLY size="1" name="songid"></td>
                                <td class="sdetails"><input type="text" value="${cart.title}" READONLY size="10" name="title"></td>
                                <td class="sdetails"><input type="text" value="${cart.price}" READONLY size="1" name="price"></td>
                                <td class="sdetails"><input type="text" value="${cart.album}" READONLY size="10" name="album"></td>
                                <td class="sdetails"><input type="text" value="${cart.artist}" READONLY size="15" name="artist"></td>
                                <td><input type="text" value="1" size="2" name="quantity"></td>
                                <td><input type="submit" value="Update" name="updatecart"></input></td>
                                </form>
                            </tr>
                        </tbody>
                    </table>


                </c:forEach>


</body>
</html>