/* Drag & drop Javascript for deck-form view */

function drag(ev) {
	ev.dataTransfer.setData("text", ev.target.id);		// ev.target is the element being dragged (the img)
}

function allowDrop(ev) {
	ev.preventDefault();
}

function drop(ev) {
	ev.preventDefault();
	var data = ev.dataTransfer.getData("text");
	ev.target.appendChild(document.getElementById(data));
	
	/* Remove name span from previous container */
	var previousSlot = document.getElementsByClassName("slot-contains-card-" + data);
	
	for (var i = 0; i < previousSlot.length; i++) {
		var childList = previousSlot[i].children;
		for (var j = 0; j < childList.length; j++) {
			if (childList[j].tagName == "SPAN") {
				previousSlot[i].removeChild(childList[j]);
			}
		}
	}
	
	/* Add name span to new container */	
	if (ev.target.classList.contains("card-slot")) {		// ev.target is the container where the element is being dropped
		var span = document.createElement("SPAN");
		span.textContent = "Pepe";
		ev.target.appendChild(span);
		ev.target.classList.add("slot-contains-card-" + data);
	}
}