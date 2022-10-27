<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript"
    src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">

<img class="mx-auto d-block" src="data:image/png;base64,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" data-deferred="1" class="rg_i Q4LuWd" jsname="Q4LuWd" width="208" height="208" alt="Bank icon in the circle stock vector. Illustration of facade - 145525569" data-iml="865.5999999977648" data-atf="true">


		<section class="w-100 p-4 d-flex justify-content-center pb-4">
			<form style="width: 22rem;" action="login" method="post" >
				<!-- Email input -->
				<div class="form-outline mb-4">
					<input type="text" id="form2Example1" name="login" class="form-control">
					<label class="form-label" for="form2Example1"
						style="margin-left: 0px;">Nom d'utilisateur</label>
					<div class="form-notch">
						<div class="form-notch-leading" style="width: 9px;"></div>
						<div class="form-notch-middle" style="width: 88.8px;"></div>
						<div class="form-notch-trailing"></div>
					</div>
				</div>

				<!-- Password input -->
				<div class="form-outline mb-4">
					<input type="password" id="form2Example2" name="pass" class="form-control">
					<label class="form-label" for="form2Example2"
						style="margin-left: 0px;">Mot de passe</label>
					<div class="form-notch">
						<div class="form-notch-leading" style="width: 9px;"></div>
						<div class="form-notch-middle" style="width: 64px;"></div>
						<div class="form-notch-trailing"></div>
					</div>
				</div>
				${message}
                       
            <button type="submit" class="btn btn-primary btn-block mb-4">se connecter</button>

				<!-- 2 column grid layout for inline styling -->
				<div class="row mb-4">
					<div class="col d-flex justify-content-center">
						<!-- Checkbox -->
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value=""
								id="form2Example31" checked=""> <label
								class="form-check-label" for="form2Example31"> rester
								connecté </label>
						</div>
					</div>

					<div class="col">
						<!-- Simple link -->
						<a href="#!">Mot de passe oublié!?</a>
					</div>
				</div>

				<!-- Submit button -->
<!-- 						<a class="btn btn-primary btn-block mb-4" href="index.jsp">se connecter</a> -->
				<!-- Register buttons -->
				
				
            
				
				
				<div class="text-center">
					<p>
					</p>
					<button type="button" class="btn btn-link btn-floating mx-1">
						<i class="fab fa-facebook-f"></i>
					</button>

					<button type="button" class="btn btn-link btn-floating mx-1">
						<i class="fab fa-google"></i>
					</button>

					<button type="button" class="btn btn-link btn-floating mx-1">
						<i class="fab fa-twitter"></i>
					</button>

					<button type="button" class="btn btn-link btn-floating mx-1">
						<i class="fab fa-github"></i>
					</button>
				</div>
			</form>
		</section>
	</div>
</body>
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
         
                password: "required",
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },
                 
                password: "Please enter password"
            }
        });
 
    });
</script>
</html>