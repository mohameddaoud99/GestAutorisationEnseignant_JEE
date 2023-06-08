<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

  <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
     <link rel="stylesheet" href="css/index.css">
  
  
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
  
</head>
<body>
	
	<jsp:useBean id="courant" class="tn.iit.glid23.model.Utilisateur" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="courant"/>




	<div class="container-fluid bg-full p-0">
        <h1 class=" text-center pt-5 py-4 display-3 text-white">Corriger ou Valider <span class="color1"> vos cordonnées</span></h1>
          <div class="row col-sm-10 text-center m-auto">

			<div class="col-lg-12 item-fa example p-2">
				<div class="item-container">
					<div class="wrapper">
						
						<div class="item-title clearfix ">
							<h1 class="text-light pt-3 ">${courant.nom}&nbsp;
								${courant.prenom}</h1>
						</div>
						<div class="icon my-4">
							<img
								src="https://tinypic.host/images/2023/02/21/pikrepo.com-2.jpg">
						</div>
						<div class="item-description text-white">
							<p class="name">${courant.nom}&nbsp; ${courant.prenom}</p>
							<a class="name" class="mail">${courant.email}</a>
							<p class="job">${courant.mdp}</p>

						</div>
						<div class="item-category">
							<a href="inscription.jsp">Corriger</a>
							<a href="InscriptionController">Valider</a>
						</div>
					</div>
				</div>
			</div>



		</div>
      </div>







<style>


body {
    background-image: url(https://tinypic.host/images/2023/03/20/Shapes-Abstraction-Background-2466799.jpg);
    height: 100%;
    min-height: 800px;
    background-size: cover;
    background-repeat: no-repeat;
    font-family: 'Josefin Sans', sans-serif;
    }

.clearfix {
    display: block;
    content: "";
    clear: both;
}
.wrapper {
    position: relative;
    min-height: 450px;
}
.color1 {color:#e91e63}

.item-container {
    border: 5px solid #fff;
    padding: 12px;
    background: #0000008a;
    transition: all .2s linear;
    border-radius: 5px;
}
.item-container:hover {
    background: #000000db;
    box-shadow: 1px 1px 20px -6px #1b1b1b;
}

.item-category a {
    float: center;
    background: #e91e63;
    padding: 4px;
    color: #fff;
}
.item-date {
    float: left;
    padding: 4px;
    color: #fff;
  z-index:99999;
}

.icon img {
    border-radius: 58%;
    height: 150px;
    border: 4px solid #fff;
    width: 150px;
    transition: all .2s linear;
}
.item-container:hover .icon img {
    width: 160px;
    height: 160px;
}
.sd3d {
    color: #fff;
    text-align: center;
    font-size: 11px;
    margin-top: 21px;
}
.sd3d a {
    color: #e91f63;
    text-align: center;
    font-size: 11px;
    margin-top: 21px;
}



</style>


    
</body>
</html>