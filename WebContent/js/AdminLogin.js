
// Get the modal
var modal = document.getElementById('id01');


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}


function myFunction() {
	var x = document.getElementById("password");
	if (x.type === "password") {
		x.type = "text";
	}
	else {
		x.type = "password";
	}
}


/*
function validateCredentials() {
	
    window.location.assign("https://www.tutorialspoint.com");

	
	//location.href = "https://www.tutorialspoint.com";

	/*
	var a = document.getElementById("username").value;
	var b = document.getElementById("password").value;
	
	if( a == 'a' ) {	
		if ( a == 'a' && b == 'a' ) {
			//alert("Correct password!!!");	
			//response.sendRedirect("signupSuccess.jsp");
           // window.location = "https://www.tutorialspoint.com";
			//window.location.replace("http://stackoverflow.com");

			 //location.replace("https://www.w3schools.com")
			document.getElementById("validation").href = "https://www.tutorialspoint.com";
		}
		
		else {
			alert("Incorrect password!!! Please enter the correct password.");
		}
	}
	
	else {
		alert("Invalid Username");		
	}	 */


