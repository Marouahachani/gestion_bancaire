<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<!DOCTYPE html> 
<html> 
<head>
 <meta charset="UTF-8"> 
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <title>Liste des demandes</title> 
  </head> 
  <body> 
  
<%@include file="layout/navbar-Demande.jsp" %>
  
  <div class="container">
  <h4class="mt-4">Liste des demandes</h4> 
  
  
 <div class="form-group row mb-3 col-sm-6">
 	<label class="col-sm-4 col-form-label">Identifiant client: ${client.getId()}</label>
 	<label class="col-sm-4 col-form-label">Nom: ${client.getNom()}</label>
 	<label class="col-sm-4 col-form-label">Prénom: ${client.getPrenom()}</label>
 	<div class="col-sm-8">
 		<input hidden type="text" class="form-control" name="idclient" value=${client.getId()}>
 	</div>
 </div>
 
  
  
  <table class="table table-striped">
  	<thead> 
   		<tr>
    		<th> Numéro de demande </th>
    	    <th> Date de demande </th> 
   		    <th> Montant de demande </th> 
            <th> Durée  </th>
            <th> Taux </th>
            <th> Mensualité </th> 
            <th > Etat de demande </th> 
            <th></th>
            <th></th>
            <th></th>
        </tr> 
 	</thead>
    <tbody>
    	<c:forEach var= "dmn" items = "${demande }">
        <tr >
           <th scope="row">${dmn.getNum() }</th> 
           <td>${dmn.getDate() }</td> 
           <td>${dmn.getMontant() }</td>
           <td>${dmn.getDuree() }</td> 
           <td>${dmn.getTaux() }</td>
           <td>${dmn.getMensualite() }</td>
           <td id= "idEtat" class="etat">${dmn.getEtat() }</td>
           <td><a href="modifier-Demande?num=${dmn.getNum()}">Modifier</</a></td>
           <td><a href="delete-Demande?num=${dmn.getNum()}">Supprimer</</a></td>
         
        </tr> 
        </c:forEach>
       
 </tbody> 
 </table>
  </div>
  <!-- Inserer un script javascript -->
	<script type="text/javascript">
		
	<%@ include file = "script/etat-Demande.js" %>
		
	</script>
	<script type="text/javascript">
		
	<%@ include file = "script/condition-etat-Demande.js" %>
		
	</script>
 </body>
 </html> 