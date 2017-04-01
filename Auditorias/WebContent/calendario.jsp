<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- Respomsive slider -->
<link href="css/responsive-calendar.css" rel="stylesheet">
<title>Calendario</title>
</head>
<body>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>

	<ul id="dropdown1" class="dropdown-content">
		<li><a href="#!">Crear Auditoria</a></li>
		<li><a href="ServletCrearUsuario?action=crearUsuario">Crear
				Usuario</a></li>
		<li class="divider"></li>
		<li><a href="#!">Crear Grupo</a></li>
	</ul>
	<ul id="dropdown2" class="dropdown-content">
		<li><a href="#!">Crear Auditoria</a></li>
		<li><a href="ServletCrearUsuario?action=crearUsuario">Crear
				Usuario</a></li>
		<li class="divider"></li>
		<li><a href="#!">Crear Grupo</a></li>
	</ul>
	<nav class="teal">
	<div class="nav-wrapper container">
		<a href="ServletCalendario?action=home" class="brand-logo"> Sistema Auditorias</a> <a href="#"
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

	<div class="container">
		<!-- Responsive calendar - START -->
		<div class="responsive-calendar">
			<div class="controls">
				<div class="row">
					<a class="pull-left col s3" data-go="prev"><div
							class="btn btn-primary orange">Prev</div></a>
					<h4 class="col s6">
						<span data-head-year></span> <span data-head-month></span>
					</h4>
					<a class="pull-right col s3" data-go="next"><div
							class="btn btn-primary orange">Next</div></a>
				</div>
			</div>
			<hr />
			<div class="day-headers">
				<div class="day header">Mon</div>
				<div class="day header">Tue</div>
				<div class="day header">Wed</div>
				<div class="day header">Thu</div>
				<div class="day header">Fri</div>
				<div class="day header">Sat</div>
				<div class="day header">Sun</div>
			</div>
			<div class="days" data-group="days"></div>
		</div>
		<!-- Responsive calendar - END -->
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
<script>
	$(document).ready(function() {
		$(".button-collapse").sideNav();
	})
	$(document).ready(function () {
		var f = new Date();
    	var fecha = (f.getFullYear() + "-" + (f.getMonth() +1));
        $(".responsive-calendar").responsiveCalendar({
        	
          time: fecha,
          events: {
            "2017-03-30": {"number": 5, "url": "ServletCalendario?action=calendario"},
            "2017-03-26": {"number": 1, "url": "ServletCalendario?action=calendario"}, 
            "2017-03-03":{"number": 1}}
        });
      });
</script>
<script src="js/responsive-calendar.js"></script>
</html>