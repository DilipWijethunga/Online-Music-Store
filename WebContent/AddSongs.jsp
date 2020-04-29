<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/AddSongs.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Add Songs Page</title>

</head>
<body>

	<jsp:include page="/WEB-INF/views/RegistrationHeader.jsp"></jsp:include>
			
	<form method="POST" action="AddSongsServlet">

	  <div class="container">
	    <h1>Add Songs</h1>
	    <hr>
	
	    <label class = "labels"><b>Song Name   </b></label>	    
	    <input type="text" class="inputs" placeholder="Enter Song Name" name="songName" >
		<br>
		
	    <label class = "labels"><b>Artist      </b></label>
	    <input type="text" class="inputs" placeholder="Enter Artist" name="artist" >
		<br>
		
	    <label class = "labels"><b>Duration    </b></label>
	    <input type="text" class="inputs" placeholder="Enter Duration" name="duration" >
	    <br>
	    
	    <label class = "labels"><b>Album       </b></label>
	   	<input type="text" class="inputs" name="album" placeholder="Enter Album">
	    <br>
	  
	    <label class = "labels"><b>Genre       </b></label>
	    <input type="text" class="inputs" placeholder="Enter Genre" name="genre" >
		<br>
		
	    <label class = "labels"><b>Composer    </b></label>
	    <input type="text" class="inputs" placeholder="Enter Composer" name="composer" >
		<br>
		
	    <label class = "labels"><b>Year        </b></label>
	    <input type="text" class="inputs" placeholder="Enter Year" name="year" >
	    <br>
	    
	    <hr>
	
	    <input type="submit" class="btn" value="Add Songs">
		<br>
		<input type="reset" class="btn" value="Reset">	
		
	  
	  
	</form>
		
	<form method="POST" action="ListSongsServlet">
		<input type="submit" value="List All Songs" class="btn" />
	</form>
	
	</div>

	<jsp:include page="/WEB-INF/views/RegistrationFooter.jsp"></jsp:include>
	
</body>
</html>
