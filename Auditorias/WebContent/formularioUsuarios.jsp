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
<title>Crear Ususario</title>
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
		<a href="ServletCrearUsuario?action=home" class="brand-logo"> Sistema Auditorias</a> <a href="#!"
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
	<br>
	<div class="container">
		<div class="row">
			<form id="formulario" class="col s12" action="ServletCrearUsuario" method="post">
				<div class="row">
					<div class="input-field col s6">
						<i class="material-icons prefix">perm_identity</i> 
						<select id="select" name="empleado">
							<option value="" disabled selected>Selecciona al Empleado</option>
							<c:forEach items="${empleados}" var="empleado">
								<option value="<c:out value="${empleado.idEmpleado}" />"><c:out value="${empleado.nombre}" /> <c:out value="${empleado.apellidoPaterno}" />
								</option>
							</c:forEach>
						</select>
					</div>
					<div class="input-field col s6">
						<i class="material-icons prefix">search</i> 
						<input id="filtro" type="text" class="validate" > <label
							for="icon_prefix">Filtrar Por Nombre</label>
					</div>
				</div>
				
				<br> <br>
				<div class="row">
					<div class="input-field col s12">
						<i class="material-icons prefix">account_circle</i> <input name="usuario"
							id="usuario" type="text" class="validate"> <label
							for="icon_prefix">Usuario</label>
					</div>
				</div>
				<br> <br>
				<div class="row">
					<div class="input-field col s12">
						<i class="material-icons prefix">vpn_key</i> <input name="contrasenia"
							id="contrasenia" type="password" class="validate"> <label
							for="icon_telephone">Contraseña</label>
					</div>
				</div>
				<br> <br>
				<div class="row">
					<div class="input-field col s12">
						<i class="material-icons prefix">recent_actors</i> 
						<select id="grupo" name="grupo">
							<option value="" disabled selected>Selecciona el grupo</option>
							<c:forEach items="${grupos}" var="grupo">
								<option value="<c:out value="${grupo.idGrupo}" />"><c:out value="${grupo.nombre}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="input-field col s12">
						<p>
							<i class="material-icons prefix">verified_user</i> 
					      	<input type="checkbox" id="lider" name="lider" />
					      	<label for="lider">Usuario Lider</label>
					    </p>
					</div>
				</div>
				<br><br>
				<br><br>
				<div class="row">
					<div class="input-field col s11">
						<i class="material-icons prefix">work</i> 
						<select id="selectRol">
							<option value="" disabled selected>Selecciona el rol</option>
							<c:forEach items="${roles}" var="rol">
								<option value="<c:out value="${rol.nombre}" />"><c:out value="${rol.nombre}" />
								</option>
							</c:forEach>
						</select>
					</div>
					<div class="input-field col s1">
						<a id="agregar" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
					</div>
				</div>
				<br><br>
				<div class="row">
					<div class="input-field col s12">
						<i class="material-icons prefix">reorder</i>
						<label for="icon_telephone">Roles</label>
						<br><br>
						<ul id="lista" class="collection"></ul>
					</div>
				</div>
				<input id="roles" type="hidden" name="roles" value="">
				<input type="hidden" name="action" value="finalizarUsuario">
				<br><br>
				<div class="col s6 offset-s5">
					<input type="hidden" name="action" value="login" />
					<button class="btn waves-effect waves-light orange" type="submit"
						name="action">
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
	$(document).ready(function() {
		$(".button-collapse").sideNav();
	})
	
	$(document).ready(function() {
		$('select').material_select();
	});
	
	$(document).ready(function() {
		var tam = 0
		$("#agregar").click(function () {
			seleccion = $("#selectRol").val();
			if (seleccion != null){
				$("#lista").append('<li class="collection-item" >'+seleccion+'</li>');
				if (tam == 0) {
					dato = $("#roles").val();
					dato = dato + seleccion;
					$("#roles").val(dato);
				}else{
					dato = $("#roles").val();
					dato = dato +","+ seleccion;
					$("#roles").val(dato);
				}
				tam++
			}     
		 });
	});
	
	$('#formulario').submit(function(e) {
		if($("#lider").val() == null){
			$("#lider").val("NO");
		}
		
		if ($("#select").val() == null) {
			Materialize.toast('Tienes que seleccionar un empleado', 3000, 'rounded')
			return false;
		}else if ($("#usuario").val() == ""){
			Materialize.toast('El Usuario no puede estar vacio', 3000, 'rounded')
			return false;
		}else if ($("#contrasenia").val() == ""){
			Materialize.toast('La contraseña no puede estar vacia', 3000, 'rounded')
			return false;
		}else if ($("#grupo").val() == null){
			Materialize.toast('Es necesario seleccionar un grupo ', 3000, 'rounded')
			return false;
		}else if ($("#roles").val() == ""){
			Materialize.toast('Necesitas seleccionar almenos 1 rol', 3000, 'rounded')
			return false;
		}else{
			return true;
		}
	});
</script>
</html>