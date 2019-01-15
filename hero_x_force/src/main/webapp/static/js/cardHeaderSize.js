function changeTitleFontSize(){
	var title = document.getElementsByClassName('heroName');
	var i;
	for (i = 0; i < title.length; i++) {
		var text= title[i].textContent;
		var n = text.length;
		if (n>21){
			title[i].style.fontSize= "14.28px";
		}
		else if (n>18){
			title[i].style.fontSize= "13.55px";
		}
		else if (n>16){
			title[i].style.fontSize= "15.805px";
		}

		else if(n >= 10){
			title[i].style.fontSize= "18.06px";
		}
	}
}