
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"> 
<title>Nouveau client</title>
</head>
<body>
  <%@include file="layout/navbar.jsp" %>
  <div class="container">
<h5>Nouveau client</h5>
	<form method = "post" action = "save-client" >
	<div class = "d-flex justify-content-center  flex-column col-12">
	  <div class="form-group row mb-3 col-sm-6">
	    <label class="col-sm-4 col-form-label">Nom : </label>
	    <div class="col-sm-8">
	      <input type="text" class="form-control" name="nom">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Prénom : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="prenom">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Date de naissance : </label>
	    <div class="col-sm-4">
	      <input type="date" class="form-control" name="date-naissance">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Adresse : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="adresse">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Tél : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="tel">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Mail : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="mail">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Civilité : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="civilite">
	    </div>
	  </div>
	  <button type="submit" class="btn btn-primary mb-2">Enregistrer</button>
	  </div>
	</form>
	</div>

</body>
</html>