<%@page import="tn.iit.glid23.model.Autorisation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@page import="java.util.List"%>
<%@page import="tn.iit.glid23.model.Enseignant"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha384-pzjwEgb7dDROfBM9fSHARuoP4z7MU6vFK8i/hf5B0tnF8fkudVO5+oKd3n0n2YLs"
	crossorigin="anonymous">

</head>
</head>
<body>

<% List<Autorisation> listAutorisations = (List<Autorisation>) application.getAttribute("tabAutorisations"); %>
	
 

	<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto sidenav" id="navAccordion">
				<li class="nav-item"><a class="nav-link" href="index.jsp">Acceuil</a></li>
				<li class="nav-item"><a class="nav-link" href="liste-enseignants.jsp">Gestion des enseignants</a></li>
				<li class="nav-item"><a class="nav-link" href="autorisation.jsp">Gestion des autorisations</a></li>
				<li class="nav-item"><a class="nav-link" href="liste-autorisations.jsp">Liste des autorisations</a></li>
			
				
				
				
				<!--
				
				<li class="nav-item"><a class="nav-link nav-link-collapse"
					href="#" id="hasSubItems" data-toggle="collapse"
					data-target="#collapseSubItems2" aria-controls="collapseSubItems2"
					aria-expanded="false">Item 2</a>
					<ul class="nav-second-level collapse" id="collapseSubItems2"
						data-parent="#navAccordion">
						<li class="nav-item"><a class="nav-link" href="#"> <span
								class="nav-link-text">Item 2.1</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								class="nav-link-text">Item 2.2</span>
						</a></li>  
					</ul></li>-->
				
			</ul>
			<div class="form-inline ml-auto mt-2 mt-md-0">
				<a href="auth.jsp" style="color: #fff" class="w3-padding-large w3-hover-red w3-hide-small w3-right">Deconnexion</i></a>

			</div>
		</div>
	</nav>

	<main class="content-wrapper">
		<div class="container-fluid">
			<div id="main">


				<div class="w3-top">
					<div class="w3-bar w3-card" style="background-color: #3b8724">

						<a href="index.jsp" style="color: #fff" class="w3-bar-item w3-button w3-padding-large">Acceuil</a> 
						<a href="auth.jsp" style="color: #fff" class="w3-padding-large w3-hover-red w3-hide-small w3-right">deconnexion</i></a>

					</div>
				</div>
				 <br>


				<div class="container-fluid">
					
					<div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Liste des autorisations</h3>
                    <hr>
			<div class="container text-left">

				<a href="autorisation.jsp" class="btn btn-success">Ajouter autorisation
					</a>
			</div>
			<br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                               
                                <th>Date</th>
                                <th>Nombre d'heures autorisé</th>
                                <th>Semaine actuelle</th>
                                <th>Enseignant</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="aut" items="${tabAutorisations}">

                                <tr>
                                    
                                    <td>
                                        <c:out value="${aut.date}" />
                                    </td>
                                     <td>
                                        <c:out value="${aut.nb_heures}" />
                                    </td>
                                    <td>
                                        <c:out value="${aut.nb_semaine}" />
                                    </td>
                                    <td>
                                        <c:out value="${aut.id_enseignant }" />
                                    </td>
                                    <td><a href="edit-enseignant.jsp?id=<c:out value='${aut.id}' />"><i class="fa fa-pencil" style='font-size:25px;color:orange'></i>
                                    </a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="DeleteEnseignantController?id=<c:out value='${aut.id}' />"><i class='fas fa-trash' style='font-size:20px;color:red'></a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
					
				</div>
			</div>
		</div>
	</main>

	<footer class="footer">
		<div class="container">
			<div class="text-center">
				<span>developpe par Amina & Mohamed
				</span>
			</div>
		</div>
	</footer>








  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  <style>
body {
	font-family: "Lato", sans-serif;
}

html {
	position: relative;
	min-height: 100%;
}

body {
	padding-top: 4.5rem;
	margin-bottom: 4.5rem;
}

.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 3.5rem;
	line-height: 3.5rem;
	background-color: #ccc;
}

.nav-link:hover {
	transition: all 0.4s;
}

.nav-link-collapse:after {
	float: right;
	content: '\f067';
	font-family: 'FontAwesome';
}

.nav-link-show:after {
	float: right;
	content: '\f068';
	font-family: 'FontAwesome';
}

.nav-item ul.nav-second-level {
	padding-left: 0;
}

.nav-item ul.nav-second-level>.nav-item {
	padding-left: 20px;
}

@media ( min-width : 992px) {
	.sidenav {
		position: absolute;
		top: 0;
		left: 0;
		width: 230px;
		height: calc(100vh - 3.5rem);
		margin-top: 3.5rem;
		background: #343a40;
		box-sizing: border-box;
		border-top: 1px solid rgba(0, 0, 0, 0);
	}
	.navbar-expand-lg .sidenav {
		flex-direction: column;
	}
	.content-wrapper {
		margin-left: 230px;
	}
	.footer {
		width: calc(100% - 230px);
		margin-left: 230px;
	}
}

#main {
	transition: margin-left .5s;
	padding: 16px;
}

/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
	.sidebar {
		padding-top: 15px;
	}
	.sidebar a {
		font-size: 18px;
	}
}

.mySlides {
	display: none
}

@media print {
	button, a, .w3-top, #btn {
		display: none;
	}
}
</style>
</body>
</html>