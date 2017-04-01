<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Sistema Auditoria</title>
</head>
<body>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>

	<nav class="teal">
	<div class="nav-wrapper container">
		<a href="#!" class="brand-logo center">Sistema de Auditorías</a>
	</div>
	</nav>

	<div class="section no-pad-bot" id="index-banner">
		<div class="container">
			<br> <br>
			<h1 class="header center orange-text">Sistema de Auditorías</h1>
			<div class="row center">
				<h5 class="header col s12 light">Sistema diseñado para la
					administración y asignación de actividades en una Auditorías</h5>
			</div>

			<div class="row center">
				<div class="col s12 center">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">group</i>
						</h2>
						<h5 class="center">Inicio de Sesión</h5>
					</div>
				</div>
			</div>

			<form action="ServletLogin" method="post">
				<div class="row center">
					<div class="input-field inline">
						<input id="usuario" name="usuario" type="text"
							class="validate center"> <label for="usuario">Usuario</label>
					</div>
				</div>

				<div class="row center">
					<div class="input-field inline">
						<input id="contrasenia" name="contrasenia" type="password"
							class="validate center"> <label for="contrasenia">Contraseña</label>
					</div>
				</div>

				<div class="row center">
					<input type="hidden" name="action" value="login" />
					<button class="btn waves-effect waves-light orange" type="submit"
						name="action">
						Submit <i class="material-icons right">send</i>
					</button>

				</div>
			</form>
			<br> <br>

		</div>
	</div>





	<footer class="page-footer teal">
	<div class="container">
		<div class="row">
			<div class="col l6 s12">
				<h5 class="white-text">Ayuda</h5>
				<p class="grey-text text-lighten-4">Cualquier duda o comentario
					ponerse en contacto.</p>
			</div>
			<div class="col l4 offset-l2 s12">
				<h5 class="white-text">Contacto</h5>
				<ul>
					<li><a target="blanck" class="grey-text text-lighten-3"
						href="https://www.facebook.com/gama136">Facebook</a></li>
					<li><a target="blanck" class="grey-text text-lighten-3"
						href="https://www.linkedin.com/in/jos%C3%A9-manuel-gama-estrada-97b4b6125/">LinkedIn</a></li>
					<li><a target="blanck" class="grey-text text-lighten-3"
						href="https://twitter.com/JoseGama196">Twitter</a></li>
					<li><p class="grey-text text-lighten-3">josegamaes@gmail.com</p></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="footer-copyright">
		<div class="container">© 2017 Copyright Gama Estrada José Manuel
		</div>
	</div>
	</footer>

</body>
</html>