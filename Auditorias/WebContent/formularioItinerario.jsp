<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>Crear Itinerario</title>
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
		<a href="ServletCrearUsuario?action=home" class="brand-logo">
			Sistema Auditorias</a> <a href="#!" data-activates="mobile-demo"
			class="button-collapse"><i class="material-icons">menu</i></a>
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
	<br>
	<div class="container">
		<div class="row">
			<form id="formulario" class="col s12" action="ServletCrearAuditoria"
				method="post">
				<div class="row">
					<div class="input-field col s6">
						<i class="material-icons prefix" name="icono">today</i><label
							for="icono">Fecha</label><br> <input id="fecha" type="date"
							class="datepicker" name="fecha" >
					</div>
					<div class="input-field col s2">
						<i class="material-icons prefix">alarm</i> <br>
						<input id="hora" type="number" class="validate" >
						<label for="icon_prefix">Hora</label>
					</div>
					<div class="input-field col s0">
						<br>
						<p style="font-weight: bold;">:</p>
					</div>
					<div class="input-field col s2">
						<br>
						<input id="minutos" type="number" class="validate" >
						<label for="icon_prefix">Minutos</label>
					</div>
				</div>

				<br> <br>
				<div class="row">
					<div class="input-field col s12">
						<i class="material-icons prefix">place</i> <select
							id="procesos" name="procesos">
							<option value="" disabled selected>Selecciona la ubicacion</option>
							<c:forEach items="${procesos}" var="proceso">
								<option value="<c:out value="${proceso.idProceso}" />"><c:out
										value="${proceso.nombre}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<br> <br>
				<div class="row">
					<div class="input-field col s11">
						<i class="material-icons prefix" name="icono">assignment</i><label
							for="icono">Actividad</label><br> <input id="fecha" type="text"
							class="validate" name="fecha">
					</div>
					<div class="input-field col s1">
						<a id="agregar" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
					</div>
				</div>
				<br> <br>
				<div class="col s6 offset-s5">
					<input type="hidden" name="action" value="finalizarAuditoria" />
					<button class="btn waves-effect waves-light orange" type="submit">
						Guardar <i class="material-icons right">send</i>
					</button>
				</div>
			</form>
		</div>
	</div>
	<br>
	<br>
	<br>
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
	$('.datepicker').pickadate({
		selectMonths : true, // Creates a dropdown to control month
		selectYears : 15
	// Creates a dropdown of 15 years to control year
	});

	$(document).ready(function() {
		$(".button-collapse").sideNav();
	})

	$(document).ready(function() {
		$('select').material_select();
	});

	$('#formulario').submit(
			function(e) {
				if ($("#claveNegocio").val() == ""
						|| $("#claveNegocio").val() == null) {
					Materialize.toast(
							'Es necesario definir la Clave del Negocio', 3000,
							'rounded')
					return false;
				} else if ($("#procesos").val() == ""
						|| $("#procesos").val() == null) {
					Materialize.toast(
							'Es necesario seleccionar almenos un Proceso',
							3000, 'rounded')
					return false;
				} else if ($("#auditorLider").val() == ""
						|| $("#auditorLider").val() == null) {
					Materialize.toast(
							'Es necesario seleccionar un Auditor Lider', 3000,
							'rounded')
					return false;
				} else if ($("#grupos").val() == ""
						|| $("#grupos").val() == null) {
					Materialize.toast(
							'Es necesario seleccionar almenos un Grupo', 3000,
							'rounded')
					return false;
				} else if ($("#objetivo").val() == ""
						|| $("#objetivo").val() == null) {
					Materialize.toast('Es necesario definir el Objetivo', 3000,
							'rounded')
					return false;
				} else {
					return true;
				}
			});
</script>