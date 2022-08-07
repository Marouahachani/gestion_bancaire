
const etats = document.querySelectorAll('#etat');
const demande = document.querySelectorAll('#demande');

for (const etat of etats) {
	if (etat.textContent == "En attente")
		demande.disabled = true;
	else
		demande.disabled = false;

}








