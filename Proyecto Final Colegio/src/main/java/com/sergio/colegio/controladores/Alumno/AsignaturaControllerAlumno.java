package com.sergio.colegio.controladores.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.AsignaturaDAO;

@Controller
public class AsignaturaControllerAlumno {
	
	@Autowired
	private AsignaturaDAO asignatura;
	
	
	@GetMapping(value = "listadoasignaturasAL")
	public String formularioListarAsignaturas() {
		return "vistas/Alumno/asignaturas/listadoAsignaturas";
	}
	
	@PostMapping(value = "listadoasignaturasAL")
	public String listarAsignatura(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam(value = "nombre") String nombre, 
			@RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa,
			ModelMap model) {
		
		
		model.addAttribute("lista", asignatura.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/Alumno/asignaturas/listadoAsignaturas";
	}
	
	
}
