
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<title>Nouveu Compte</title>
</head>
<body>
<%@ include file = "layout/navbar-compte.jsp" %>
<div class="container-lg mt-20">
	<h2 style="margin-top: 5rem; margin-bottom: 3rem;">Créer Un nouveau Compte</h2>
	<form class="row g-3" method = "post" action = "save-compte" style="margin-top: 15px;">
		  <div class="col-md-6">
		    <label for="inputNum" class="form-label">Numero de Compte</label>
		    <input type="text" class="form-control" id="inputNumCompte" name="numCompte">
		  </div>
		  <div class="col-md-6">
		   <label for="inputSoldes" class="form-label">Soldes</label>
		    <input type="number" class="form-control" id="inputsoldeCompte" name="soldeCompte">
		   
		  </div>
		  <div class="col-6">
		     <label for="inputDateCree" class="form-label">Date de Création</label>
		    <input type="date" class="form-control" id="inputDateCreationCompte" name="dateCreationCompte">
		  </div>
		  <div class="col-md-6">
		    <label for="inputType" class="form-label">Type</label>
		    <select id="inputType" class="form-select" name="typeCompte">
		      <option selected>Choose...</option>
		      <option value="Compte Courant">Compte Courant</option>
		      <option value="Compte Epargne">Compte Epargne</option>
		      
		    </select>
		  </div>
		  <div class="col-md-6">
		   <label for="inputTaux" class="form-label">Taux</label>
		    <input type="number" class="form-control" id="inputTaux" name="taux">
		    
		  </div>
		  <div class="col-md-6">
		   <label for="inputDecouvert" class="form-label">Decouvert</label>
		    <input type="number" class="form-control" id="inputDecouvert" name="decouvert">
		  </div>
		  
		  <div class="col-md-6">
		    <label for="inputId" class="form-label">Numero de Client</label>
		    <input type="number" class="form-control" id="inputIdclient" name="idClient">
		  </div>
		  
		  <div class="col-12" style="margin-top: 20px;">
		    <button type="submit" class="btn btn-primary" style="padding: 10px;width:10rem; font-size:1.5rem;">Enregistrer</button>
		  </div>
	</form>
</div>

</body>
</html>