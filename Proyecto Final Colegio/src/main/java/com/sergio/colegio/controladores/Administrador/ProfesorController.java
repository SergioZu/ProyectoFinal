package com.sergio.colegio.controladores.Administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.ProfesorDAO;

@Controller
public class ProfesorController {

	@Autowired
	private ProfesorDAO profesorImpl;

	@GetMapping(value = "listadoprofesorA")
	public String formularioListadoAsignaturas() {
		return "vistas/Administrador/profesor/listadoProfesor";
	}

	@PostMapping(value = "listadoprofesorA")
	public String listarAsignatura(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "curso") String curso,
			ModelMap model) {

		model.addAttribute("lista", profesorImpl.obtenerProfesorporIdyNombre(id, nombre, curso));
		return "vistas/Administrador/profesor/listadoProfesor";
	}

	@GetMapping(value = "insertarprofesorA")
	public String formularioinsertarAsignatura() {
		return "vistas/Administrador/profesor/insertarProfesor";
	}

	@PostMapping(value = "insertarprofesorA")
	public String insertarAsignatura(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "curso") String curso,
			ModelMap model) {

		model.addAttribute("resultado", profesorImpl.insertarProfesor(id, nombre, curso));

		return "vistas/Administrador/profesor/insertarProfesor";

	}

	@GetMapping(value = "formularioactualizarprofesorA")
	public String mostrarformularioActualizarAsignatura() {

		return "vistas/Administrador/profesor/actualizarProfesor";
	}

	@PostMapping(value = "formularioactualizarprofesorA")
	public String formularioActualizarAsignatura(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "curso") String curso,
			ModelMap model) {

		model.addAttribute("lista", profesorImpl.obtenerProfesorporIdyNombre(id, nombre, curso));
		return "vistas/Administrador/profesor/actualizarProfesor";
	}

	@PostMapping(value = "actualizarprofesorA")
	public String actualizarAsignaturas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "curso") String curso,
			ModelMap model) {

		model.addAttribute("resultado", profesorImpl.actualizarProfesor(id, nombre, curso));

		return "vistas/Administrador/profesor/actualizarProfesor";
	}

	@GetMapping(value = "formularioborrarprofesorA")
	public String mostrarFormularioBorrarAsignaturas() {
		return "vistas/Administrador/profesor/borrarProfesor";
	}

	@PostMapping(value = "formularioborrarprofesorA")
	public String formularioBorrarAlumnos(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "curso") String curso,
			ModelMap model) {

		model.addAttribute("lista", profesorImpl.obtenerProfesorporIdyNombre(id, nombre, curso));
		return "vistas/Administrador/profesor/borrarProfesor";
	}

	@PostMapping(value = "borrarprofesorA")
	public String borrarAlsignaturas(@RequestParam(value = "id") Integer id, ModelMap modelMap) {

		modelMap.addAttribute("resultado", profesorImpl.eliminarProfesor(id));
		return "vistas/Administrador/profesor/borrarProfesor";
	}

}
