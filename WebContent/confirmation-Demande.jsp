<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<title>Confirmation Demande</title>
</head>
<body>
<%@ include file ="layout/navbar-Demande.jsp" %>
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Confirmation demande</h5>
    <p class="card-text">Id Client : ${demande.getClient().getId() }</p>
    <p class="card-text">Numéro de Demande: ${demande.getNum()}</p>
    <p class="card-text">Date de Demande: ${demande.getDate()}</p>
    <p class="card-text">Montant de Demande : ${demande.getMontant()}</p>
    <p class="card-text">Durée: ${demande.getDuree()}</p>
    <p class="card-text">Taux : ${demande.getTaux()}</p>
    <p class="card-text">Mensualité : ${demande.getMensualite()}</p>
     <p class="card-text">Etat de Demande : ${demande.getEtat()}</p>
   
    <a href="list-Demande?idclient=${demande.getClient().getId()}" class="btn btn-primary">Afficher les demandes</a>
  </div>
</div>
</body>
</html>