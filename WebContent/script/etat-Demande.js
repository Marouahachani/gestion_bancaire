
const elmnts = document.querySelectorAll('#idEtat');


for (const elmnt of elmnts) {


	if (elmnt.textContent == "En attente")
		elmnt.classList.add("table-warning");
	else if (elmnt.textContent == "Validee")
		elmnt.classList.add("table-success");

	else
		elmnt.classList.add("table-danger");
	console.log(elmnt.textContent);


}



