package com.sergio.colegio.controladores.Administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.AsignaturaDAO;

@Controller
public class AsignaturaController {
	
	@Autowired
	private AsignaturaDAO asignatura;
	
	
	@GetMapping(value = "listadoasignaturasA")
	public String formularioListadoAsignaturas() {
		return "vistas/Administrador/asignaturas/listadoAsignaturas";
	}
	
	@PostMapping(value = "listadoasignaturasA")
	public String listarAsignatura(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam(value = "nombre") String nombre, 
			@RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa,
			ModelMap model) {
		
		
		model.addAttribute("lista", asignatura.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/Administrador/asignaturas/listadoAsignaturas";
	}
	
	
	@GetMapping(value = "insertarasignaturaA")
	public String formularioinsertarAsignatura() {
		return "vistas/Administrador/asignaturas/insertarAsignaturas";
	}
	
	@PostMapping(value = "insertarasignaturaA")
	public String insertarAsignatura(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "curso",  required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, 
			ModelMap model){
		
		
		model.addAttribute("resultado", asignatura.insertarAsignatura(id, nombre, curso, tasa));
		
		return "vistas/Administrador/asignaturas/insertarAsignaturas";	
		
	}
	
	
	@GetMapping(value = "formularioactualizarasignaturaA")
	public String mostrarformularioActualizarAsignatura() {
			
		return "vistas/Administrador/asignaturas/actualizarAsignaturas";
	}
		
	@PostMapping(value = "formularioactualizarasignaturaA")
	public String formularioActualizarAsignatura(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "curso",  required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, 
			ModelMap model){
			
		model.addAttribute("lista", asignatura.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/Administrador/asignaturas/actualizarAsignaturas";
	}
		
	@PostMapping(value = "actualizarasignaturaA")
	public String actualizarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "curso",  required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, 
			ModelMap model) {		
				
		model.addAttribute("resultado", asignatura.actualizarAsignatura(id, nombre, curso, tasa));		
			
		return "vistas/Administrador/asignaturas/actualizarAsignaturas";
	}
	

	@GetMapping(value = "formularioborrarasignaturaA")
	public String mostrarFormularioBorrarAsignaturas() {
		return "vistas/Administrador/asignaturas/borrarAsignaturas";
	}
		
	@PostMapping(value = "formularioborrarasignaturaA")
	public String formularioBorrarAlumnos(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "curso",  required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, 
			ModelMap model) {
			
		model.addAttribute("lista", asignatura.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/Administrador/asignaturas/borrarAsignaturas";
	}
		
	@PostMapping(value = "borrarasignaturaA")
	public String borrarAlsignaturas(
			@RequestParam(value = "id") Integer id,
			ModelMap modelMap) {
			
		modelMap.addAttribute("resultado", asignatura.eliminarAsignatura(id));
		return "vistas/Administrador/asignaturas/borrarAsignaturas";
	}
}
