/* Drag & drop Javascript for deck-form view */

function drag(ev) {
	ev.dataTransfer.setData("text", ev.target.id);
}

function allowDrop(ev) {
	ev.preventDefault();
	var container = ev.target;
}

function drop(ev) {
	ev.preventDefault();
	var data = ev.dataTransfer.getData("text");
	ev.target.appendChild(document.getElementById(data));
	
	var span = document.createElement("SPAN");		// Create a <span> element
	span.textContent = "Pepe";
	ev.target.appendChild(span);
}