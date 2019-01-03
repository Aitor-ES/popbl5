/* Footer java script */

window.setTimeout(function() {
	// console.log("Function loaded");
    $(".alert-success").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 4000);