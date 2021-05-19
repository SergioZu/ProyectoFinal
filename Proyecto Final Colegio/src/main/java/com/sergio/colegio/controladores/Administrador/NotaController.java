package com.sergio.colegio.controladores.Administrador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.ComboDAO;
import com.sergio.colegio.dao.NotaDAO;


@Controller
public class NotaController {
	
	@Autowired
	private NotaDAO notaImpl;
	
	@Autowired
	private ComboDAO combo;
	
	
	@GetMapping(value = "listadonotasA")
	public String formularioListadoNotas() {
		return "vistas/Administrador/notas/listadoNotas";
	}
	
	@PostMapping(value = "listadonotasA")
	public String listarNotas(
			@RequestParam(value = "id", required = false) Integer idAlumno,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha,
			ModelMap model){		
		
		model.addAttribute("lista", notaImpl.obtenerNotaPorIdNombreAsignaturaNotaFecha(idAlumno, nombre, asignatura, nota, fecha));
		return "vistas/Administrador/notas/listadoNotas";
	}
	
	

	@GetMapping(value = "insertarnotaA")
	public String insertarAsignatura(ModelMap model) {
		
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		
		return "vistas/Administrador/notas/insertarNotas";
	}
	
	@PostMapping(value = "insertarnotaA")
	public String insertarNota(
			@RequestParam(value = "alumnos") Integer idAlumno, 
			@RequestParam(value = "asignaturas") Integer idAsignatura,
			@RequestParam(value = "nota",  required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha, 
			ModelMap model){
		
		
		model.addAttribute("resultado", notaImpl.insertarNota(idAlumno, idAsignatura, nota, fecha));
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		
		return "vistas/Administrador/notas/insertarNotas";
		
	}
	
	
	@GetMapping(value = "formularioactualizarnotaA")
	public String FormularioActualizarNotas() {			
		return "vistas/Administrador/notas/actualizarNotas";
	}
		
	@PostMapping(value = "formularioactualizarnotaA")
	public String BuscarFormularioActualizarNotas(
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha,
			ModelMap model) {
			
		model.addAttribute("lista", notaImpl.obtenerNotaPorNombreAsignaturaFecha(nombre, nombre, nombre));
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		
		return "vistas/Administrador/notas/actualizarNotas";
	}
		
	@PostMapping(value = "actualizarnotaA")
	public String ActualizarNotas(
			@RequestParam(value = "idNota") Integer idNota,
			@RequestParam(value = "alumnos") Integer idAlumno, 
			@RequestParam(value = "asignaturas") Integer idAsignatura,
			@RequestParam(value = "nota",  required = false) Double curso,
			@RequestParam(value = "fecha", required = false) String tasa,
			ModelMap model) {		
			
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
			
		model.addAttribute("resultado", notaImpl.actualizarNota(idNota, idAlumno, idAsignatura, curso, tasa));
		
		return "vistas/Administrador/notas/actualizarNotas";
	}
	
	
	@GetMapping(value = "formularioborrarnotaA")
	public String MostrarFormularioBorrarNotas() {
		return "vistas/Administrador/notas/borrarNotas";
	}
		
	@PostMapping(value = "formularioborrarnotaA")
	public String FormularioBorrarNotas(
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha,
			ModelMap model) {
			
		model.addAttribute("lista", notaImpl.obtenerNotaPorNombreAsignaturaFecha(nombre, asignatura, fecha));
		return "vistas/Administrador/notas/borrarNotas";
	}
		
		@PostMapping(value = "borrarnotaA")
		public String BorrarNota(
				@RequestParam(value = "idNota") Integer idNota,
				ModelMap modelMap) {
			
			modelMap.addAttribute("resultado", notaImpl.eliminarNota(idNota));
			return "vistas/Administrador/notas/borrarNotas";
		}
}
