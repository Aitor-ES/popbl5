// When the user scrolls down 200px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
    document.getElementById("topButton").style.display = "block";
  } else {
    document.getElementById("topButton").style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}

$(document).ready(function() {
  // When the user clicks on a link, change status to active to show it activated
  $('li.active').removeClass('active');
  $('a[href="' + location.pathname + '"]').closest('li').addClass('active'); 
});

// Contact us progress bar
function contactUsProgress() {
	var username = document.forms["contactUs"]["username"].value;
    var subject = document.forms["contactUs"]["subject"].value;
    var message = document.forms["contactUs"]["message"].value;
    
    if (username != "" && subject != "" && message != "")
    {
    	$('#myProgressBar').fadeIn();
    }
}

// Forgot progress bar
function forgotProgress() {
	var email = document.forms["forgotForm"]["email"].value;

	if (email != "") {
		$('#myProgressBar').fadeIn();
	}
}

// Register & Profile edit progress bar
function userProgress() {
	var username = document.forms["userForm"]["username"].value;
    var email = document.forms["userForm"]["email"].value;
    var password = document.forms["userForm"]["password"].value;
    var confirmPassword = document.forms["userForm"]["confirmPassword"].value;
    
    if (username != "" && email != "" && password != "" && confirmPassword != "")
    {
    	$('#myProgressBar').fadeIn();
    }
}