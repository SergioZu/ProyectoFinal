<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Matriculacion</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/index.css" rel="stylesheet" />
<link rel="stylesheet" href="css/formularios.css">
<link rel="stylesheet" href="css/tablas.css">
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
				<h1 class="my-4">Listar Matriculaciones</h1>
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
							action="http://localhost:8080/colegio/listadomatriculacionesA"
							method="post">
							<div class="form-group">
								<label for="idAsig">Id Asignatura</label> <input type="text"
									id="idAsig" name="idAsig" class="form-control">
							</div>
							<div class="form-group">
								<label for="nombreAsig">Nombre Asignatura</label> <input
									type="text" id="nombreAsig" name="nombreAsig"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="idAlum">Id Alumno</label> <input type="text"
									id="idAlum" name="idAlum" class="form-control">
							</div>
							<div class="form-group">
								<label for="nombreAlum">Nombre Alum</label> <input type="text"
									id="nombreAlum" name="nombreAlum" class="form-control">
							</div>
							<div class="form-group">
								<label for="fecha">Fecha</label> <input type="date" id="fecha"
									name="fecha" class="form-control">
							</div>
							<div class="form-group">
								<label for="activo">Activo</label> <input type="checkbox"
									name="activo" id="activo" value="1" readonly="readonly" checked
									onclick="javascript: return false;" class="form-control">
							</div>
							<input type="submit" value="Enviar">
						</form>
						<table>
							<tr>
								<th>Id Asignatura</th>
								<th>Nombre Asignatura</th>
								<th>Id Alumno</th>
								<th>Nombre Alumno</th>
								<th>Fecha</th>
								<th>Activo</th>
							</tr>

							<c:forEach items="${lista}" var="matriculacion">
								<tr>
									<td>${matriculacion.idAsignatura}</td>
									<td>${matriculacion.nombreAsignatura}</td>
									<td>${matriculacion.idAlumno}</td>
									<td>${matriculacion.nombreAlumno}</td>
									<td>${matriculacion.fecha}</td>
									<td><c:if test="${matriculacion.activo == 1 }">
											<input type="checkbox" name="activo" id="activo" value="1"
												readonly="readonly" checked
												onclick="javascript: return false;">
										</c:if></td>
								</tr>
							</c:forEach>

						</table>

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
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>