package com.sergio.colegio.controladores.Profesores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.ComboDAO;
import com.sergio.colegio.dao.NotaDAO;


@Controller
public class NotaControllerProfesor {
	
	@Autowired
	private NotaDAO notaImpl;
	
	@Autowired
	private ComboDAO combo;
	
	
	@GetMapping(value = "listadonotasP")
	public String formularioListadoNotas() {
		return "vistas/Profesor/notas/listadoNotas";
	}
	
	@PostMapping(value = "listadonotasP")
	public String listarNotas(
			@RequestParam(value = "id", required = false) Integer idAlumno,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha,
			ModelMap model){		
		
		model.addAttribute("lista", notaImpl.obtenerNotaPorIdNombreAsignaturaNotaFecha(idAlumno, nombre, asignatura, nota, fecha));
		return "vistas/Profesor/notas/listadoNotas";
	}
	
	
	
	@GetMapping(value = "insertarnotaP")
	public String formularioInsertarNotas(ModelMap model) {
		
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		
		return "vistas/Profesor/notas/insertarNotas";
	}
	
	@PostMapping(value = "insertarnotaP")
	public String insertarNota(
			@RequestParam(value = "alumnos") Integer idAlumno, 
			@RequestParam(value = "asignaturas") Integer idAsignatura,
			@RequestParam(value = "nota",  required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha, 
			ModelMap model){
		
		
		model.addAttribute("resultado", notaImpl.insertarNota(idAlumno, idAsignatura, nota, fecha));
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		
		return "vistas/Profesor/notas/insertarNotas";
		
	}
	
	
	@GetMapping(value = "formularioactualizarnotaP")
	public String mostrarFormularioActualizarNotas() {			
		return "vistas/Profesor/notas/actualizarNotas";
	}
		
	@PostMapping(value = "formularioactualizarnotaP")
	public String formularioActualizarNotas(
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha,
			ModelMap model) {
			
		model.addAttribute("lista", notaImpl.obtenerNotaPorNombreAsignaturaFecha(nombre, nombre, nombre));
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		
		return "vistas/Profesor/notas/actualizarNotas";
	}
		
	@PostMapping(value = "actualizarnotaP")
	public String actualizarNotas(
			@RequestParam(value = "idNota") Integer idNota,
			@RequestParam(value = "alumnos") Integer idAlumno, 
			@RequestParam(value = "asignaturas") Integer idAsignatura,
			@RequestParam(value = "nota",  required = false) Double curso,
			@RequestParam(value = "fecha", required = false) String tasa,
			ModelMap model) {		
			
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
			
		model.addAttribute("resultado", notaImpl.actualizarNota(idNota, idAlumno, idAsignatura, curso, tasa));
		
		return "vistas/Profesor/notas/actualizarNotas";
	}
	
	
	@GetMapping(value = "formularioborrarnotaP")
	public String mostrarFormularioBorrarNotas() {
		return "vistas/Profesor/notas/borrarNotas";
	}
		
	@PostMapping(value = "formularioborrarnotaP")
	public String formularioBorrarNotas(
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha,
			ModelMap model) {
			
		model.addAttribute("lista", notaImpl.obtenerNotaPorNombreAsignaturaFecha(nombre, asignatura, fecha));
		return "vistas/Profesor/notas/borrarNotas";
	}
		
		@PostMapping(value = "borrarnotaP")
		public String borrarNota(
				@RequestParam(value = "idNota") Integer idNota,
				ModelMap modelMap) {
			
			modelMap.addAttribute("resultado", notaImpl.eliminarNota(idNota));
			return "vistas/Profesor/notas/borrarNotas";
		}
}
