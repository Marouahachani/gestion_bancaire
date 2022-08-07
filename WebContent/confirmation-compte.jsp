<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<title>Confirmation Compte</title>
</head>
<body>
<%@ include file ="layout/navbar-compte.jsp" %>
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Confirmation </h5>
    <p class="card-text">Id Client : ${compte.getClient().getId() }</p>
    <p class="card-text">Numéro du compte : ${compte.getNumCompte()}</p>
    <p class="card-text">Solde du Compte : ${compte.getSoldeCompte()}</p>
    <p class="card-text">Date de création du compte : ${compte.getDateCreationCompte()}</p>
    <p class="card-text">Type de compte : ${compte.getTypeCompte()}</p>
    <p class="card-text">Taux : ${compte.getTaux()}</p>
    <p class="card-text">Découvert : ${compte.getDecouvert()}</p>
   
    <a href="list-compte?idclient=${compte.getClient().getId()}" class="btn btn-primary">Liste des comptes</a>
  </div>
</div>
</body>
</html>