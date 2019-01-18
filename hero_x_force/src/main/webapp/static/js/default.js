/* Success message remover
 *********************************************************/
window.setTimeout(function() {
	// console.log("Function loaded");
    $(".alert-success").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 5000);

/* Error message remover
 *********************************************************/
window.setTimeout(function() {
	// console.log("Function loaded");
    $(".alert-danger").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 10000);

/* Top button: show & hide
 *********************************************************/
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
	  if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
	    document.getElementById("topButton").style.display = "block";
	  } else {
	    document.getElementById("topButton").style.display = "none";
	  }
	}

function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}

/* Databases: initialize
 *********************************************************/
$(document).ready(function() {
    $('.myTable	').DataTable();
} );

$(document).ready(function() {
    $('.mySimpleTable').DataTable({
    	"bPaginate": false,
    	"bFilter": false,
    });
} );

/* Nav: set active link
 *********************************************************/
$(document).ready(function() {
  $('li.active').removeClass('active');
  $('a[href="' + location.pathname + '"]').closest('li').addClass('active'); 
});

/* Progress bar: show
 *********************************************************/
function homeProgress() {
	var username = document.forms["homeForm"]["username"].value;
    var subject = document.forms["homeForm"]["subject"].value;
    var message = document.forms["homeForm"]["message"].value;
    
    if (username != "" && subject != "" && message != "")
    {
    	$('#myProgressBar').fadeIn();
    }
}

function forgotProgress() {
	var email = document.forms["forgotForm"]["email"].value;

	if (email != "") {
		$('#myProgressBar').fadeIn();
	}
}

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

window.onscroll = function() {stickyFunction()};

function stickyFunction() {
	  
	}