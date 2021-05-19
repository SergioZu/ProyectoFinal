package com.sergio.colegio.controladores.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.AlumnoDAO;
import com.sergio.colegio.dao.ComboDAO;

@Controller
public class AlumnoControllerAlumno {

	@Autowired
	private ComboDAO combo;

	@Autowired
	private AlumnoDAO alumnoImpl;

	@GetMapping(value = "listadoalumnosAL")
	public String formularioListadoAlumnos(ModelMap model) {
		return "vistas/Alumno/alumnos/listadoAlumnos";
	}

	@PostMapping(value = "listadoalumnosAL")
	public String listarAlumnos(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, ModelMap model) {

		model.addAttribute("lista", alumnoImpl.obtenerAlumnosporIdyNombre(id, nombre));
		return "vistas/Alumno/alumnos/listadoAlumnos";
	}

	
}
