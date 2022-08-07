
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<title>Nouveu Demande</title>
</head>
<body>
	<%@ include file="layout/navbar-Demande.jsp"%>

	<div class="container-lg mt-20">
		<h2 style="margin-top: 5rem; margin-bottom: 3rem;">Créer Un
			Demande</h2>
		<form class="row g-3" method="post" action="save-Demande"
			style="margin-top: 15px;">
			<div class="col-md-6">
				<label for="inputNum" class="form-label">Numero de Demande</label> <input
					type="text" class="form-control" id="inputNumDemande" name="num">
			</div>
			<div class="col-md-6">
				<label for="inputDate" class="form-label">Date</label> <input
					type="date" class="form-control" id="inputdate" name="date">

			</div>
			<div class="col-6">
				<label for="inputMontant" class="form-label">Montant de
					Crédit</label> <input  type="number" class="form-control" id="inputMontant"
					name="montant">
			</div>
			<div class="col-md-6">
				<label for="inputType" class="form-label">durée</label> <input
					 type="number" class="form-control" id="inputDuree" name="duree">



			</div>
			<div class="col-md-6">
				<label for="inputTaux" class="form-label">Taux</label> <input
					type="number" class="form-control" id="inputTaux" name="taux">

			</div>
			<div class="col-md-6">
				<label for="inputDecouvert" class="form-label">Mensualité</label> <input
					 type="number" class="form-control" id="inputMensualite"
					name="mensualite">
			</div>
			<div class="col-md-6">
				<label for="inputDecouvert" class="form-label">Etat de
					demande</label> <select id="inputEtat" class="form-select" name="etat">
					<option selected>Choose...</option>
					<option value="En attente">En attente</option>
					<option value="Validee">Validée</option>
					<option value="Refusee">Refusée</option>
				</select>
			</div>


			<div class="col-md-6">
				<label for="inputId" class="form-label">Numero de Client</label> <input
					type="number" class="form-control" id="inputIdclient"
					name="idClient">
			</div>

			<div class="col-12" style="margin-top: 20px;">
				<button type="submit" class="btn btn-primary"
					style="padding: 10px; width: 10rem; font-size: 1.5rem;">Enregistrer</button>
			</div>



			<div class="col-12" style="margin-top: 20px;">
				<a id="btn-calcul" class="btn btn-primary">Calculer la
					mensualité</a>

			</div>


		</form>
	</div>
	<!-- Inserer un script javascript -->
	<script type="text/javascript">
		
	<%@ include file = "script/calcul-Demande.js" %>
		
	</script>
</body>
</html>