/* Drag & drop Javascript for deck-form view
 *********************************************************/
function drag(ev) {
	ev.dataTransfer.setData("text", ev.target.id); // ev.target is the element being dragged (the img)
}

function allowDrop(ev) {
	ev.preventDefault();
}

function drop(ev) {
	ev.preventDefault();
	var data = ev.dataTransfer.getData("text");
	var elementToDrop = document.getElementById(data);
	ev.target.appendChild(elementToDrop); // ev.target is the container where the element is being dropped
	
	if (ev.target.classList[0] == "selected-card-slot") {
		var slotId = ev.target.id;
		var id = slotId.substring(slotId.length - 1, slotId.length);
		
		var input = document.getElementById("selected-card-name-" + id);
		input.value = "#" + elementToDrop.id;
	} else {
		var inputList = document.getElementsByClassName("selected-card-name");
		
		for (var i = 0; i < inputList.length; i++) {
			if (inputList[i].value == "#" + elementToDrop.id) {
				inputList[i].value = "";
			}
		}
	}
}