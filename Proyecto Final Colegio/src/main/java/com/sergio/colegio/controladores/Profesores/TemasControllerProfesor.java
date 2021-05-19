package com.sergio.colegio.controladores.Profesores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.ComboDAO;
import com.sergio.colegio.dao.TemasDAO;

@Controller
public class TemasControllerProfesor {

	@Autowired
	private TemasDAO temaImpl;

	@Autowired
	private ComboDAO combo;

	@GetMapping(value = "listadotemasP")
	public String formularioListadoTemas() {
		return "vistas/Profesor/temas/listadoTemas";
	}

	@PostMapping(value = "listadotemasP")
	public String listarTemas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "nombre", required = false) String nombre, ModelMap model) {

		model.addAttribute("lista", temaImpl.obtenerTemaPorIdAsignaturaNombre(id, asignatura, nombre));
		return "vistas/Profesor/temas/listadoTemas";
	}

	@GetMapping(value = "insertartemasP")
	public String formularioInsertarTemas(ModelMap model) {
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		return "vistas/Profesor/temas/insertarTemas";
	}

	@PostMapping(value = "insertartemasP")
	public String insertarTemas(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "asignaturas") Integer idAsignatura,
			@RequestParam(value = "nombre") String nombre, ModelMap model) {

		model.addAttribute("resultado", temaImpl.insertarTemas(id, idAsignatura, nombre));
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());

		return "vistas/Profesor/temas/insertarTemas";

	}
	
	@GetMapping(value = "formularioactualizartemasP")
	public String mostrarFormularioActualizarTemas() {			
		return "vistas/Profesor/temas/actualizarTemas";
	}
	
	@PostMapping(value = "formularioactualizartemasP")
	public String formularioActualizarTemas(
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "nombre", required = false) String nombre, 
			ModelMap model) {
			
		model.addAttribute("lista", temaImpl.obtenerTemaPorAsignaturaNombre(asignatura, nombre));
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		
		return "vistas/Profesor/temas/actualizarTemas";
	}
	
	@PostMapping(value = "actualizartemaP")
	public String actualizarTemas(
			@RequestParam(value = "idTema") Integer idTemas,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignaturas") Integer idAsignatura,
			ModelMap model) {		
			
		
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
			
		model.addAttribute("resultado", temaImpl.actualizarTemas(idTemas, idAsignatura, nombre));
		
		return "vistas/Profesor/temas/actualizarTemas";
	}

	
		@GetMapping(value = "formularioborrartemasP")
		public String mostrarFormularioBorrarTemas() {
			return "vistas/Profesor/temas/eliminarTemas";
		}
			
		@PostMapping(value = "formularioborrartemasP")
		public String formularioBorrarTemas(
				@RequestParam(value = "asignatura") String asignatura,
				@RequestParam(value = "nombre", required = false) String nombre, 
				ModelMap model) {
				
			model.addAttribute("lista", temaImpl.obtenerTemaPorAsignaturaNombre(asignatura, nombre));
			model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
			
			return "vistas/Profesor/temas/eliminarTemas";
		}
			
			@PostMapping(value = "borrartemasP")
			public String borrarTemas(
					@RequestParam(value = "idTema") Integer idTema,
					ModelMap modelMap) {
				
				modelMap.addAttribute("resultado", temaImpl.eliminarTemas(idTema));
				return "vistas/Profesor/temas/eliminarTemas";
			}
}
