<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Liste des clients</title>
</head>
<body>

	<%@include file="layout/navbar-compte.jsp"%>

	<div class="container">
		<h4class="mt-4">Liste des comptes
		</h4>


		<div class="form-group row mb-3 col-sm-6">
			<label class="col-sm-4 col-form-label">Identifiant client:
				${client.getId()}</label> <label class="col-sm-4 col-form-label">Nom:
				${client.getNom()}</label> <label class="col-sm-4 col-form-label">Prénom:
				${client.getPrenom()}</label>
			<div class="col-sm-8">
				<input hidden type="text" class="form-control" name="idclient"
					value=${client.getId()}>
			</div>
		</div>



		<table class="table table-striped">
			<thead>
				<tr>
					<th>Numéro de Compte</th>
					<th>Date de création</th>
					<th>Solde</th>
					<th>Type</th>
					<th>Taux</th>
					<th>Découvert</th>

					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cpt" items="${comptes }">
					<tr>
						<th scope="row" >${cpt.getNumCompte()}</th>
						<td >${cpt.getDateCreationCompte() }</td>
						<td >${cpt.getSoldeCompte() }</td>
						<td >${cpt.getTypeCompte() }</td>
						<td >${cpt.getTaux() }</td>
						<td >${cpt.getDecouvert() }</td>
						<td><a class="btn btn-danger" href="delete-compte?numCompte=${cpt.getNumCompte()}"> 
						        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  									<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
  									<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
								</svg>
						</a></td>
						<td><a class="btn btn-info" href="modifier-compte?numCompte=${cpt.getNumCompte()}">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
							  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
							  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
							</svg>
						
						</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>
