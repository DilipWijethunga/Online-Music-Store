
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>



<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/index.css">

    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/addtocart.css">

    <title>Online Music</title>



</head>


<body>

    <div class="container-fluid p-0">

        <div class="row header">
            <div class="col-12">
                <div class="header">
                    <ul class="navtab">
                        <a href="index.jsp">HOME</a>
                        <a href="#">CONTACT US</a>
                        <a href="#">ABOUT US</a>
                        <a href="#">USER</a>
                        <a href="#">ADMIN</a>
                    </ul>
                    <div class="search-box">
                    
                    	<table>
                    	<tr>
                    	<form action="search" method="post">
                    	<td><input type="text" placeholder="Search..." class="search" name="srchtext"></input></td>
                    	<td><input type="image" class="search-btn" src="images/search.svg" name="searchbtn" value="searchbt"></td>
                    	</form>
                    	
                    	<form action="#" method="post">
                    	<td><input type="image" class="avatar" src="images/cart.svg"></td>
                    	</form>
                    	
                    	<form action="#" method="post">
                    	<td><input type="image" class="avatar" src="images/avatar.svg"></td>
                    	</form>
                    	</tr>
                    
                    </table>
                        
                        
                    </div>
                    <div class="user-profile">

                    </div>
                </div>
            </div>
        </div>
        <!--end of first row-->

        <div class="row">
            <div class="col-2">
                <div class="sidebar">
                    <div class="categories">
                        <ul>
                            <li><a href="#"> Jazz </a></li>
                            <li><a href="#"> Hip hop music </a></li>
                            <li><a href="#"> Rock </a></li>
                            <li><a href="#"> Pop music </a></li>
                            <li><a href="#"> Blues </a></li>
                            <li><a href="#"> Musical theatre </a></li>
                            <li><a href="#"> Folk music </a></li>
                            <li><a href="#"> Classical music </a></li>
                            <li><a href="#"> Country music </a></li>
                            <li><a href="#"> Heavy metal </a></li>
                            <li><a href="#"> Rhythm and blues </a></li>
                            <li><a href="#"> Reggae </a></li>
                            <li><a href="#"> Funk </a></li>
                            <li><a href="#"> Soul music </a></li>
                            <li><a href="#"> Disco </a></li>
                            <li><a href="#"> Techno </a></li>
                            <li><a href="#"> Dance music</a></li>
                            <li><a href="#"> Opera </a></li>
                        </ul>

                    </div>
                </div>
            </div>
            <div class="col-10">
                
                
                
		
				
                
                <p>${message}</p>
                
               
                    <h1 class="title">Cart</h1>

                    <table class="songdetails">
                        <thead>
                            <tr>
                                <th>Song ID</th>
                                <th>Song Title</th>
                                <th>Album</th>
                                <th>Artist</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Action</th>
                            </tr>
                        </thead>

                        <tbody>
                        
                            <tr>
                            <form action="${pageContext.request.contextPath}/cartcontroller" method="post">
                            
                                <td class="sdetails"><input type="text" name="songid" value="${cart.songid}"/></td>
                                <td class="sdetails"><input type="text" name="title" value="${cart.title}"/></td>
                                <td class="sdetails"><input type="text" name="album" value="${cart.album}"/></td>
                                <td class="sdetails"><input type="text" name="artist" value="${cart.artist}"/></td>
                                <td><input type="text" name="quantity" value="${cart.quantity}" size="1"/></td>
                                <td class="sdetails"><input type="text" name="price" value="${cart.price}"/></td>
                                <td><input type="hidden" name="itemid" value="${cart.itemid}"/>
								<button type="submit">Save Item</button></td>
                                </form>
                            </tr>
                        </tbody>
                    </table>


              

            </div>
        </div>



			<p>${message}</p>

			
	<form action="${pageContext.request.contextPath}/cartcontroller" method="post">
	
			
			SongID<input type="text" name="songid" value="${cart.songid}"/><br/>
			Title<br/>
			Album<br/>
			Artist<br/>
			Quantity<br/>
			Price<br/>
			<input type="hidden" name="itemid" value="${cart.itemid}"/>
			<button type="submit">Save Item</button></th>
	</form>
	
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        <div class="row footer">
            <div class="col-12">
                <div class="footer">
                    <!-- Site footer -->
                    <footer class="site-footer">
                        <div class="container">
                            <div class="row">
                                <div class="col-sm-12 col-md-6">
                                    <h6>About</h6>
                                    <p class="text-justify">online music store ..............</p>
                                </div>

                                <div class="col-xs-6 col-md-3">
                                    <h6>Categories</h6>
                                    <ul class="footer-links">
                                        <li><a href="">Jazz</a></li>
                                        <li><a href="">Rock</a></li>
                                        <li><a href="">Folk music</a></li>
                                        <li><a href="">Reggae</a></li>
                                        <li><a href="">Disco</a></li>
                                        <li><a href="">Dance music</a></li>
                                    </ul>
                                </div>

                                <div class="col-xs-6 col-md-3">
                                    <h6>Quick Links</h6>
                                    <ul class="footer-links">
                                        <li><a href="#">About Us</a></li>
                                        <li><a href="#">Contact Us</a></li>
                                        <li><a href="#">Contribute</a></li>
                                        <li><a href="#">Privacy Policy</a></li>
                                    </ul>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-8 col-sm-6 col-xs-12">
                                    <p class="copyright-text">Copyright &copy; 2017 All Rights Reserved by
                                        <a href="#">OnlineMusic</a>.
                                    </p>
                                </div>

                                <div class="col-md-4 col-sm-6 col-xs-12">
                                    <ul class="social-icons">
                                        <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                                        <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
                                        <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </footer>
                </div>
            </div>

        </div>
    </div>
    <!--end of first row-->




    <!--main Container end-->


</body>