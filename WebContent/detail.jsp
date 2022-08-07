
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Détails Client</title>
</head>
<body>
<%@include file="layout/navbar.jsp" %>
<div class="container-lg mt-50">

<div class="card" style="width: 35rem;"> 
<div class="card-body"> 
<h5 class="card-title">Client ${client.getId()} </h5>
 <p class="card-text">Nom : ${client.getNom()}</p> 
 <p class="card-text">Prénom : ${client.getPrenom()}</p> 
 <p class="card-text">Date de naissance : ${client.getDateNaissance()}</p> 
 <p class="card-text">Adresse : ${client.getAdresse()}</p> 
 <p class="card-text">Tél : ${client.getTel()}</p> 
 <p class="card-text">Mail : ${client.getMail()}</p> 
 <p class="card-text">Civilité : ${client.getCivilite()}</p> 
 <a href="list-Demande?idclient=${client.getId()}" class="btn btn-warning">Demande de crédits</a>
  <a href="list-compte?idclient=${client.getId()}" class="btn btn-success">Comptes</a>
  </div> 
  </div> 
  </div>
  </body>
</html>