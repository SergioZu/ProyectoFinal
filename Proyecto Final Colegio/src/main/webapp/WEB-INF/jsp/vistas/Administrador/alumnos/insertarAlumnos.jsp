<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>


<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Insertar Alumnos</title>
<!-- Favicon-->
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
				<h1 class="my-4">Insertar Alumnos</h1>
				<div class="list-group">
					<a href="http://localhost:8080/colegio/listadoalumnosA">Listar
						Alumnos</a> <a href="http://localhost:8080/colegio/insertaralumnoA">Insertar
						Alumnos</a> <a
						href="http://localhost:8080/colegio/formularioactualizaralumnosA">Modificar
						Alumnos</a> <a
						href="http://localhost:8080/colegio/formularioeliminaralumnoA">Borrar
						Alumnos</a>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="row">
					<div class="container">
						<form action="http://localhost:8080/colegio/insertaralumnoA"
							method="post">
							<div class="form-group">
								<label for="id">ID Alumno</label> <input type="text" id="id"
									name="id" class="form-control">
							</div>
							<div class="form-group">
								<label for="nombre">Nombre Alumno</label> <input type="text"
									id="nombre" name="nombre" class="form-control">
							</div>
							<div class="form-group">
								<label for="nombre">Municipios</label> <select name="municipios"
									id="municipios" class="form-control">
									<c:forEach items="${listaMunicipios}" var="municipio">
										<option value="${municipio.id}">
											${municipio.descripcion}</option>
									</c:forEach>
									<option value="${alumno.idMunicipio}" selected>${alumno.municipio}</option>
								</select >
							</div>
							<div class="form-group">
								<label for="familiaNumerosa">Familia numerosa <input
									type="checkbox" id="familiaNumerosa" name="familiaNumerosa"
									value="1" class="form-control"></label>
							</div>
							<input type="submit" value="Enviar">
						</form>
						<c:if test="${resultado == 1}">
							<b>Alumno insertado correctamente</b>
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
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>

</html>

<html>
<head>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/formularios.css">
</head>
<body>