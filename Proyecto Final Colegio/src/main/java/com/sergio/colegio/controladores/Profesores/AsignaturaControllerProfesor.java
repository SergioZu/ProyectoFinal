package com.sergio.colegio.controladores.Profesores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.AsignaturaDAO;

@Controller
public class AsignaturaControllerProfesor {
	
	@Autowired
	private AsignaturaDAO asignatura;
	
	
	@GetMapping(value = "listadoasignaturasP")
	public String formulariolistarAsignaturas() {
		return "vistas/Profesor/asignaturas/listadoAsignaturas";
	}
	
	@PostMapping(value = "listadoasignaturasP")
	public String listarAsignatura(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam(value = "nombre") String nombre, 
			@RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa,
			ModelMap model) {
		
		
		model.addAttribute("lista", asignatura.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/Profesor/asignaturas/listadoAsignaturas";
	}
	
	
	@GetMapping(value = "insertarasignaturaP")
	public String formularioInsertarAsignatura() {
		return "vistas/Profesor/asignaturas/insertarAsignaturas";
	}
	
	@PostMapping(value = "insertarasignaturaP")
	public String insertarAsignatura(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "curso",  required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, 
			ModelMap model){
		
		
		model.addAttribute("resultado", asignatura.insertarAsignatura(id, nombre, curso, tasa));
		
		return "vistas/Profesor/asignaturas/insertarAsignaturas";	
		
	}
	
	@GetMapping(value = "formularioactualizarasignaturaP")
	public String mostrarFormularioActualizarAsignatura() {
			
		return "vistas/Profesor/asignaturas/actualizarAsignaturas";
	}
		
	@PostMapping(value = "formularioactualizarasignaturaP")
	public String formularioActualizarAsignatura(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "curso",  required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, 
			ModelMap model){
			
		model.addAttribute("lista", asignatura.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/Profesor/asignaturas/actualizarAsignaturas";
	}
		
	@PostMapping(value = "actualizarasignaturaP")
	public String actualizarAsignatura(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "curso",  required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, 
			ModelMap model) {		
				
		model.addAttribute("resultado", asignatura.actualizarAsignatura(id, nombre, curso, tasa));		
			
		return "vistas/Profesor/asignaturas/actualizarAsignaturas";
	}
	
	@GetMapping(value = "formularioborrarasignaturaP")
	public String mostrarFormularioBorrarAsignaturas() {
		return "vistas/Profesor/asignaturas/borrarAsignaturas";
	}
		
	@PostMapping(value = "formularioborrarasignaturaP")
	public String formularioBorrarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "curso",  required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, 
			ModelMap model) {
			
		model.addAttribute("lista", asignatura.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/Profesor/asignaturas/borrarAsignaturas";
	}
		
	@PostMapping(value = "borrarasignaturaP")
	public String borrarAsignaturas(
			@RequestParam(value = "id") Integer id,
			ModelMap modelMap) {
			
		modelMap.addAttribute("resultado", asignatura.eliminarAsignatura(id));
		return "vistas/Profesor/asignaturas/borrarAsignaturas";
	}
}
