<%@page import="com.oop.model.Songs"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.SongServiceImpl"%>
<%@page import="com.oop.service.ISongService"%>
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

		 <p class="topic" >List of Songs</p>
		 
		 <a class = "btn" href="AddSongs.jsp">Add Songs</a>

		 <table cellspacing="0" cellpadding="0" class="center" id = "songs">
		 
		  <tr>
                <th>Song ID</th>
                <th>Song Name</th>
                <th>Artist</th>
                <th>Duration</th>
                <th>Album</th>
                <th>Genre</th>
                <th>Composer</th>
                <th>Year</th>
                <th>Select</th>
            </tr>
            <%
            ISongService iSongService = new SongServiceImpl();
			ArrayList<Songs> arrayList = iSongService.getSongs();
			
			for(Songs songs : arrayList){
			%>
			 <tr>
				<td> <%=songs.getSongID() %> </td>
				<td> <%=songs.getSongName() %> </td>
				<td> <%=songs.getArtist() %> </td>
				<td> <%=songs.getDuration() %> </td>
				<td> <%=songs.getAlbum() %> </td>	
				<td> <%=songs.getGenre() %> </td>
				<td> <%=songs.getComposer() %> </td>											
				<td> <%=songs.getYear() %> </td>
				
				<td> 
				<form method="POST" action="GetSongsServlet">
				<input type="hidden" name="songID" value="<%=songs.getSongID()%>"/>
				 <input type="submit" value= "Select Songs" class="select-button" /> 
				 </form>
				 </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>

		
</body>
</html>