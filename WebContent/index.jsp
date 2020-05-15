<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
    <link rel="stylesheet" href="css/index.css">

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
                    	<td><input type="image" class="avatar" src="images/cart.svg" onclick="window.location.href='showcart.jsp'"></td>
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
                <h1 class="title">Songs</h1>
                <div class="images">
                
			
                    <div class="img-container">
                        <div class="thumbnail">
                            <form action="displaysongs" method="post" class="img-button">
                                <input type="image" src="images/closer.jpg" class="prodimg" id="1">
                                <input type="hidden" name="id" value="1" />
                                <span><input type="submit" name="buy" class="show" value="Show Details" ></span> 
                            </form>
                            
                            <form action="displaysongs" method="post" class="img-button">
                                <input type="image" src="images/perfect.jpg" class="prodimg">
                                <input type="hidden" name="id" value="2" />
                                <span><input type="submit" name="buy" class="show" value="Show Details" ></span> 
                            </form>
                            
                            <form action="displaysongs" method="post" class="img-button">
                                <input type="image" src="images/seeyou.jpg" class="prodimg" id="1">
                                <input type="hidden" name="id" value="3" />
                                <span><input type="submit" name="buy" class="show" value="Show Details" ></span> 
                            </form>
                            <form action="displaysongs" method="post" class="img-button">
                                <input type="image" src="images/CountingStars.jpg" class="prodimg">
                                <input type="hidden" name="id" value="4" />
                                <span><input type="submit" name="buy" class="show" value="Show Details" ></span> 
                            </form>
                            <form action="displaysongs" method="post" class="img-button">
                                <input type="image" src="images/lovestory.jpg" class="prodimg" id="1">
                                <input type="hidden" name="id" value="5" />
                                <span><input type="submit" name="buy" class="show" value="Show Details" ></span> 
                            </form>
                            
                            <form action="displaysongs" method="post" class="img-button">
                                <input type="image" src="images/uptownf.jpg" class="prodimg">
                                <input type="hidden" name="id" value="6" />
                                <span><input type="submit" name="buy" class="show" value="Show Details" ></span> 
                            </form>
                            
                            <form action="displaysongs" method="post" class="img-button">
                                <input type="image" src="images/lovetheway.jpg" class="prodimg" id="1">
                                <input type="hidden" name="id" value="7" />
                                <span><input type="submit" name="buy" class="show" value="Show Details" ></span> 
                            </form>
                            <form action="displaysongs" method="post" class="img-button">
                                <input type="image" src="images/ThinkingOutLoud.jpg" class="prodimg">
                                <input type="hidden" name="id" value="8" />
                                <span><input type="submit" name="buy" class="show" value="Show Details" ></span> 
                            </form>
                            <form action="displaysongs" method="post" class="img-button">
                                <input type="image" src="images/Senorita.jpg" class="prodimg" id="1">
                                <input type="hidden" name="id" value="9" />
                                <span><input type="submit" name="buy" class="show" value="Show Details" ></span> 
                            </form>
                            
                            <form action="displaysongs" method="post" class="img-button">
                                <input type="image" src="images/treatyou.jpg" class="prodimg">
                                <input type="hidden" name="id" value="10" />
                                <span><input type="submit" name="buy" class="show" value="Show Details" ></span> 
                            </form>
                            
                            <form action="displaysongs" method="post" class="img-button">
                                <input type="image" src="images/lovemelike.jpg" class="prodimg" id="1">
                                <input type="hidden" name="id" value="11" />
                                <span><input type="submit" name="buy" class="show" value="Show Details" ></span> 
                            </form>
                            <form action="displaysongs" method="post" class="img-button">
                                <input type="image" src="images/Imagine-Dragons-Believer-art.jpg" class="prodimg">
                                <input type="hidden" name="id" value="12" />
                                <span><input type="submit" name="buy" class="show" value="Show Details" ></span> 
                            </form>
                            
                        </div>

                    </div>
                   
                    
                </div>

            </div>
        </div>

        <div class="row">
            <div class="col-2">
                <div class="sidebar">

                </div>
            </div>
            <div class="col-10">
                <h1 class="title">Artists</h1>
                <div class="images">

                    <div class="img-container">
                        <div class="thumbnail">
                            <p class="img-button">
                                <input type="image" src="images/01.jpg" class="prodimg" id="1">
                                <span><input type="button" name="buy" class="show" value="Show Details"></span> 
                            </p>
                            <p class="img-button">
                                <input type="image" src="images/02.jpg" class="prodimg" id="1">
                                <span><input type="button" name="buy" class="show" value="Show Details"></span> 
                            </p>
                            <p class="img-button">
                                <input type="image" src="images/03.jpg" class="prodimg" id="1">
                                <span><input type="button" name="buy" class="show" value="Show Details"></span> 
                            </p>
                            <p class="img-button">
                                <input type="image" src="images/04.jpg" class="prodimg" id="1">
                                <span><input type="button" name="buy" class="show" value="Show Details"></span> 
                            </p>
                            <p class="img-button">
                                <input type="image" src="images/05.jpg" class="prodimg" id="1">
                                <span><input type="button" name="buy" class="show" value="Show Details"></span> 
                            </p>
                            <p class="img-button">
                                <input type="image" src="images/06.jpg" class="prodimg" id="1">
                                <span><input type="button" name="buy" class="show" value="Show Details"></span> 
                            </p>
                            <p class="img-button">
                                <input type="image" src="images/07.jpg" class="prodimg" id="1">
                                <span><input type="button" name="buy" class="show" value="Show Details"></span> 
                            </p>
                            <p class="img-button">
                                <input type="image" src="images/08.jpg" class="prodimg" id="1">
                                <span><input type="button" name="buy" class="show" value="Show Details"></span> 
                            </p>
                            <p class="img-button">
                                <input type="image" src="images/09.jpg" class="prodimg" id="1">
                                <span><input type="button" name="buy" class="show" value="Show Details"></span> 
                            </p>
                            <p class="img-button">
                                <input type="image" src="images/10.jpg" class="prodimg" id="1">
                                <span><input type="button" name="buy" class="show" value="Show Details"></span> 
                            </p>
                            <p class="img-button">
                                <input type="image" src="images/11.jpg" class="prodimg" id="1">
                                <span><input type="button" name="buy" class="show" value="Show Details"></span> 
                            </p>
                            <p class="img-button">
                                <input type="image" src="images/12.jpg" class="prodimg" id="1">
                                <span><input type="button" name="buy" class="show" value="Show Details"></span> 
                            </p>
                            
                        </div>

                    </div>
                </div>

            </div>
        </div>

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