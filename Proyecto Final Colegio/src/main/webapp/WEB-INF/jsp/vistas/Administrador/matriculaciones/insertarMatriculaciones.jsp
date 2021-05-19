<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar Matriculacion</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/index.css" rel="stylesheet" />
<link rel="stylesheet" href="css/formularios.css">
<link rel="stylesheet" href="css/tablas.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	 $(document).ready(function(){
		$(document).on('change','#alumnos, #asignaturas', function(){
			$.ajax({
					  type: "POST",
					  url: 'http://localhost:8080/colegio/tasa',
					  data: {
						 alumnos: $("#alumnos").val(),
						 asignaturas: $("#asignaturas").val(),
						 fecha: $("fecha").val()
					  },
					  success: function(data) {
						 $('#tasa').val(data)
					  }
			});
		});
	 });
	 
	 

	 </script>
</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#!">Aula Virtual Administrador</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="http://localhost:8080/colegio/MenuA"> Inicio <span
							class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/colegio/listadoprofesorA">Profesor</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/colegio/listadoalumnosA">Alumnos</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/colegio/listadoasignaturasA">Asignaturas</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/colegio/listadonotasA">Notas</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/colegio/listadomatriculacionesA">Matriculaciones</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/colegio/listadotemasA">Temas</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/colegio/listadotareasA">Tareas</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Page Content-->
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<h1 class="my-4">Insertar Matriculaciones</h1>
				<div class="list-group">
					<a href="http://localhost:8080/colegio/listadomatriculacionesA">Listar
						Matriculacion</a> <a
						href="http://localhost:8080/colegio/insertarmatriculacionA">Insertar
						Matriculacion</a> <a
						href="http://localhost:8080/colegio/formularioborrarmatriculacionesA">Borrar
						Matriculacion</a>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="row">
					<div class="container">
						<form
							action="http://localhost:8080/colegio/insertarmatriculacionA"
							method="post">
							<div class="form-group">
								<label for="alumnos">Alumnos</label> <select name="alumnos"
									id="alumnos" class="form-control">
									<c:forEach items="${listaAlumnos}" var="alumno">
										<option value="${alumno.id}">${alumno.id}-${alumno.descripcion}
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="asignaturas">Asignaturas</label> <select
									name="asignaturas" id="asignaturas" class="form-control">
									<c:forEach items="${listaAsignaturas}" var="asignatura">
										<option value="${asignatura.id}">${asignatura.id}-${asignatura.descripcion}
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="tasa">Tasa</label> <input readonly type="text"
									id="tasa" name="tasa" class="form-control">
							</div>
							<div class="form-group">
								<label for="fecha">Fecha</label> <input type="date" id="fecha"
									name="fecha" class="form-control">
							</div>

							<input type="submit" value="Insertar">
						</form>
						<c:if test="${resultado == 1}">
							<b>Matriculación insertada correctamente</b>
						</c:if>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2021</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	
</body>

</html>