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
	ev.target.appendChild(document.getElementById(data));		// ev.target is the container where the element is being dropped
}