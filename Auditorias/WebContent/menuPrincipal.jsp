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
<title>Sistema Auditorias</title>
</head>
<body>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>

	<ul id="dropdown1" class="dropdown-content">
		<li><a href="ServletCrearAuditoria?action=crearAuditoria">Crear
				Auditoria</a></li>
		<li><a href="ServletCrearUsuario?action=crearUsuario">Crear
				Usuario</a></li>
		<li><a href="#!">Crear Grupo</a></li>
		<li><a href="ServletCrearProceso?action=crearProceso">Crear
				Proceso</a></li>
	</ul>
	<ul id="dropdown2" class="dropdown-content">
		<li><a href="ServletCrearAuditoria?action=crearAuditoria">Crear
				Auditoria</a></li>
		<li><a href="ServletCrearUsuario?action=crearUsuario">Crear
				Usuario</a></li>
		<li><a href="#!">Crear Grupo</a></li>
		<li><a href="ServletCrearProceso?action=crearProceso">Crear
				Proceso</a></li>
	</ul>
	<nav class="teal">
	<div class="nav-wrapper container">
		<a href="ServletCrearUsuario?action=home" class="brand-logo"> Sistema Auditorias</a> <a href="#"
			data-activates="mobile-demo" class="button-collapse"><i
			class="material-icons">menu</i></a>
		<ul class="right hide-on-med-and-down">
			<li><a href="ServletCalendario?action=calendario">Calendario</a></li>
			<li><a href="ServletAuditorias?action=auditorias">Auditorias</a></li>
			<!-- Dropdown Trigger -->
			<li><a class="dropdown-button" href="#!"
				data-activates="dropdown1">Catalogo<i
					class="material-icons right">arrow_drop_down</i></a></li>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="ServletCalendario?action=calendario">Calendario</a></li>
			<li><a href="ServletAuditorias?action=auditorias">Auditorias</a></li>
			<!-- Dropdown Trigger -->
			<li><a class="dropdown-button" href="#!"
				data-activates="dropdown2">Catalogo<i
					class="material-icons right">arrow_drop_down</i></a></li>
		</ul>
	</div>
	</nav>
	<br>
	<div class="center row">
		<img class="responsive-img" src="imagenes/Welcome.jpg">
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
		<div class="container">� 2017 Copyright Gama Estrada Jos� Manuel
		</div>
	</div>
	</footer>


</body>
<script>
	$(document).ready(function() {
		$(".button-collapse").sideNav();
	})
</script>
</html>