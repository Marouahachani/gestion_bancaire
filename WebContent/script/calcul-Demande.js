const btnCalcul=document.querySelector('#btn-calcul');

btnCalcul.onclick = function (){
	
	let montant =document.getElementById("inputMontant").value;
	let duree =document.getElementById("inputDuree").value;
	let taux =document.getElementById("inputTaux").value;
	let inputMensualite =document.getElementById("inputMensualite");
	taux/=100;
	const tauxMensual = taux/12;
	
	const mensualite =(montant* tauxMensual)/ (1- Math.pow(1+tauxMensual, -duree));
	
	
	inputMensualite.value= mensualite.toFixed(0);
	
	



	console.log(mensualite);
}
