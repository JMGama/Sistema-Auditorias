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
<title>Crear Auditoria</title>
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
		<li class="divider"></li>
		<li><a href="#!">Crear Grupo</a></li>
	</ul>
	<ul id="dropdown2" class="dropdown-content">
		<li><a href="ServletCrearAuditoria?action=crearAuditoria">Crear
				Auditoria</a></li>
		<li><a href="ServletCrearUsuario?action=crearUsuario">Crear
				Usuario</a></li>
		<li class="divider"></li>
		<li><a href="#!">Crear Grupo</a></li>
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
			<form id="formulario" class="col s12" action="ServletCrearUsuario"
				method="post">
				<div class="row">
					<div class="input-field col s6">
						<i class="material-icons prefix">store_mall_directory</i> <input
							name="usuario" id="usuario" type="text" class="validate">
						<label for="icon_prefix">Clave del negocio</label>
					</div>
					<div class="input-field col s6">
						<i class="material-icons prefix">today</i> <input id="fecha"
							type="text" class="validate" disabled> <label
							for="icon_prefix"> Fecha</label>
					</div>
				</div>

				<br> <br>
				<div class="row">
					<div class="input-field col s11">
						<i class="material-icons prefix">assignment</i> <select
							id="selectRol">
							<option value="" disabled selected>Selecciona el proceso</option>
						</select>
					</div>
					<div class="input-field col s1">
						<a id="agregar"
							class="btn-floating btn-large waves-effect waves-light red"><i
							class="material-icons">add</i></a>
					</div>
				</div>
				<br> <br>
				<div class="row">
					<div class="input-field col s12">
						<i class="material-icons prefix">layers</i> <label
							for="icon_telephone">Procesos</label> <br> <br>
						<table id="lista" class="card-panel">
							<tr>
								<th class="center">Proceso</th>
								<th class="center">Nombre</th>
								<th class="center">Accion</th>
							</tr>
						</table>
					</div>
				</div>
				<br> <br>
				<div class="row">
					<div class="input-field col s12">
						<i class="material-icons prefix">verified_user</i> <select
							id="grupo" name="grupo">
							<option value="" disabled selected>Auditor lider</option>
							<c:forEach items="${usuarios}" var="usuario">
								<option value="<c:out value="${usuario.idUsuario}" />"><c:out
										value="${usuario.usuario}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<br>
				<br>
				<div class="row">
					<div class="input-field col s11">
						<i class="material-icons prefix">people</i> <select
							id="selectGrupo">
							<option value="" disabled selected>Selecciona el grupo</option>
							<c:forEach items="${grupos}" var="grupo">
								<option value="<c:out value="${grupo.nombre}" />"><c:out
										value="${grupo.nombre}" />
								</option>
							</c:forEach>
						</select>
					</div>
					<div class="input-field col s1">
						<a id="agregarGrupo"
							class="btn-floating btn-large waves-effect waves-light red"><i
							class="material-icons">add</i></a>
					</div>
				</div>
				<br> <br>
				<div class="row">
					<div class="input-field col s12">
						<i class="material-icons prefix">folder_shared</i> <label
							for="icon_telephone">Grupos</label> <br> <br>
						<table id="tablaGrupos" class="card-panel">
							<tr>
								<th class="center">Nombre del grupo</th>
								<th class="center">Acciones</th>
							</tr>
						</table>
					</div>
				</div>
				<br>
				<br>
				<div class="row">
					<div class="input-field col s6">
						<i class="material-icons prefix">equalizer</i>
						<textarea id="textarea1" class="materialize-textarea"></textarea>
						<label for="textarea1">Objetivo</label>
					</div>
					<div class="input-field col s6">
						<i class="material-icons prefix">trending_up</i>
						<textarea id="textarea1" class="materialize-textarea"></textarea>
						<label for="textarea1">Alcance</label>
					</div>
				</div>
				<br>
				<br>
				<div class="row">
					<div class="file-field input-field">
						<div class="btn red">
							<span>File</span> <input type="file" multiple>
						</div>
						<div class="file-path-wrapper">
							<input class="file-path validate" type="text"
								placeholder="Documentos para la auditoria">
						</div>
					</div>
				</div>
				<br>
				<br>
				<div class="col s6 offset-s5">
					<input type="hidden" name="action" value="login" />
					<button class="btn waves-effect waves-light orange" type="submit"
						name="action">
						Submit <i class="material-icons right">send</i>
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
		<div class="container">� 2017 Copyright Gama Estrada Jos� Manuel
		</div>
	</div>
	</footer>


</body>
<script>
	$(document).ready(function() {
		$(".button-collapse").sideNav();
	})

	$(document).ready(function() {
		$('select').material_select();
	});

	$(document).ready(
			function() {
				var f = new Date();
				var fecha = (f.getDate() + "/" + (f.getMonth() + 1) + "/" + f
						.getFullYear());
				$("#fecha").val(fecha);

			})

	$(document)
			.ready(
					function() {
						var tam = 0
						var cuenta = 0;
						$("#agregarGrupo")
								.click(
										function() {
											seleccion = $("#selectGrupo").val();
											if (seleccion != null) {
												$("#tablaGrupos")
														.append(
																'<tr id="'+cuenta+'">'
																		+ '<td class="center">'
																		+ seleccion
																		+ '</td>'
																		+ '<td class="center"> <a onclick="quitarFila('
																		+ cuenta
																		+ ')" class="waves-effect waves-light btn-floating red"> <i class="material-icons left"> delete </i> </a> </td>'
																		+ '</tr>');
												cuenta++;
											}
										});
					});

	function quitarFila(fila) {
		var parent = document.getElementById(fila).parentNode;
		parent.removeChild(document.getElementById(fila));
	};
</script>
</html>