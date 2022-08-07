<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<title>Modifier Demande</title>
</head>
<body>

<%@ include file = "layout/navbar-Demande.jsp" %>
<div class="container-lg mt-20">
	<h2 style="margin-top: 5rem; margin-bottom: 3rem;">Modifier la demande</h2>
	<form class="row g-3" method = "post" action = "update-Demande" style="margin-top: 15px;">
		  <div class="col-md-6">
		    <label for="inputNum" class="form-label">Numero de Demande</label>
		    <input  type="text" class="form-control" id="inputNum" name="num" readonly value = ${demande.getNum()}>		    
		  </div>
		  
		  <div class="col-6">
		     <label for="inputDate" class="form-label">Date </label>
		    <input type="date" class="form-control" id="inputDate" name="date" readonly value = ${demande.getDate()}>
		  </div>
		  
		  <div class="col-md-6">
		   <label for="inputMontant" class="form-label">Montant</label>
		    <input type="number" class="form-control" id="inputmontant" name="montant" readonly value = ${demande.getMontant()}>
		   
		  </div>
		  
		   <div class="col-md-6">
		   <label for="inputDuree" class="form-label">Duree</label>
		    <input type="number" class="form-control" id="inputDuree" name="duree" readonly value = ${demande.getDuree()}>
		    
		     </div>
		  <div class="col-md-6">
		   <label for="inputTaux" class="form-label">Taux</label>
		    <input type="number" class="form-control" id="inputTaux" name="taux" readonly value = ${demande.getTaux()}>
		    
		  </div>
		  
		  <div class="col-md-6">
		   <label for="inputMensualite" class="form-label">Mensualite</label>
		    <input type="number" class="form-control" id="inputMensualite" name="mensualite" readonly value = ${demande.getMensualite()}>
		  </div>
		  
		  <div class="col-md-6">
		    <label for="inputEtat" class="form-label">Etat</label>
		    <select id="inputEtat" class="form-select" name="etat" >
		      <option selected value = ${demande.getEtat()}>${demande.getEtat()}</option>
		      <option value="En attente">En attente</option>
		      <option value="Validee">Validee</option>
		      <option value="Refusee">Refusee</option>
		      
		    </select>
		  </div>
		  
		 
		  <div class="col-md-6">
		    <label for="inputId" class="form-label">Numero de Client</label>
		    <input type="number" class="form-control" id="inputIdclient" name="idClient" readonly value =${demande.getClient().getId()}>
		  </div>
		
		  
		  <div class="col-12" style="margin-top: 20px;">
		    <button type="submit" class="btn btn-primary" style="padding: 10px;width:10rem; font-size:1.5rem;">Enregistrer les modification</button>
		  </div>
	</form>
</div>

</body>
</html>