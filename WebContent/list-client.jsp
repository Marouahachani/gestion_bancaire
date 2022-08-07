<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<!DOCTYPE html> 
<html> 
<head>
 <meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <title>Liste des clients</title> 
  </head> 
  <body> 
  
  <%@include file="layout/navbar.jsp" %>
  
  <div class="container">
  <h4class="mt-4">Liste des clients</h4> 
  <form method = "post" action="find"> 
  <div class="form-group row mb-3"> 
  <div class="col-sm-3"> 
  <input type="text" class="form-control" name="nom" placeholder="Nom"> 
  </div> 
  <div class="col-sm-3"> 
  <input type="text" class="form-control" name="prenom" placeholder="Prénom">
   </div> 
   <button type="submit" class="btn btn-primary col-sm-2 mb-2">Chercher</button>
    </div>
     </form> 
  
  
  
  
  <table class="table table-striped">
  	<thead> 
   		<tr>
    		<th>Indentifiant</th>
    	    <th>Nom</th> 
   		    <th>Prénom</th> 
            <th>Adresse</th>
            <th>Tél</th>
            <th>Date naissance</th> 
            <th>Mail</th>
            <th>Civilité</th> 
            <th></th>
            <th></th>
        </tr> 
 	</thead>
    <tbody>
    	<c:forEach var= "c" items = "${clients }">
        <tr>
           <th scope="row">${c.getId() }</th> 
           <td>${c.getNom() }</td> 
           <td>${c.getPrenom() }</td>
           <td>${c.getAdresse() }</td> 
           <td>${c.getTel() }</td>
           <td>${c.getDateNaissance() }</td>
           <td>${c.getMail() }</td>
           <td>${c.getCivilite() }</td>
           <td>
           		<a class="btn btn-danger" href="delete-client?id=${c.getId()}">  
          			 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  						<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
  						<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
					</svg>
           		</a>
           </td>
           <td>
           		<a class="btn btn-info" href="detail-client?id=${c.getId()}"> 
           			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
  						<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  						<path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
					</svg>
           		</a>
           </td>
        </tr> 
        </c:forEach>
       
 </tbody> 
 </table>
  </div>
 </body>
 </html> 