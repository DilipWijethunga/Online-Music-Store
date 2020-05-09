<%@page import="com.oop.model.Songs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>

<head>

<link rel = "stylesheet" type = "text/css" href = "css/AddSongs.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta charset="UTF-8">
<title>Music Management</title>
</head>

<body>

	<jsp:include page="/WEB-INF/views/RegistrationHeader.jsp"></jsp:include>

	<% Songs songs = (Songs) request.getAttribute("songs"); %>

	<form method="POST" action="UpdateSongsServlet">
	
	 <div class="container">
	    <h1>Update Song Details</h1>
	    <hr>
	    
	    
	    <label class = "labels"><b>Song ID   </b></label>	    
	    <input type="text" class="inputs" name="songID" disabled="disabled"
					value="<%=songs.getSongID()%>" />
		<br>
		
		<label class = "labels"><b>Song Name   </b></label>	    
	    <input type="text" class="inputs" name="songName" value="<%=songs.getSongName()%>" />
		<br>
		
		<label class = "labels"><b>Artist      </b></label>	    
	    <input type="text" class="inputs" name="artist" value="<%=songs.getArtist()%>" />
		<br>

		<label class = "labels"><b>Duration    </b></label>
	    <input type="text" class="inputs" name="duration" value="<%=songs.getDuration()%>" />
	    <br>


		<label class = "labels"><b>Album       </b></label>
	   	<input type="text" class="inputs" name="album" value="<%=songs.getAlbum()%>" />
	    <br>
	  
	    <label class = "labels"><b>Genre       </b></label>
	    <input type="text" class="inputs" name="genre" value="<%=songs.getGenre()%>" />
		<br>
		
	    <label class = "labels"><b>Composer    </b></label>
	    <input type="text" class="inputs"  name="composer" value="<%=songs.getComposer()%>" />
		<br>
		
	    <label class = "labels"><b>Year        </b></label>
	    <input type="text" class="inputs"  name="year" value="<%=songs.getYear()%>" />
	    <br>
	    
	    <hr>
	
		<input type="hidden" name="songID" value="<%=songs.getSongID()%>" /> 
		
		<input type="submit" value="Update Song" class="btn"/></td>

	</form>

	<form method="POST" action="DeleteSongsServlet">
		<input type="hidden" name="songID" value="<%=songs.getSongID()%>" /> 
		<input type="submit" value="Delete Song" class="btn"/>
	</form>

	</div>

	<jsp:include page="/WEB-INF/views/RegistrationFooter.jsp"></jsp:include>

</body>
</html>