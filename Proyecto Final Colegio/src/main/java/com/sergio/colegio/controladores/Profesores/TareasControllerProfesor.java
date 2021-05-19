package com.sergio.colegio.controladores.Profesores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.ComboDAO;
import com.sergio.colegio.dao.TareasDAO;

@Controller
public class TareasControllerProfesor {

	@Autowired
	private TareasDAO tareasImpl;

	@Autowired
	private ComboDAO combo;

	@GetMapping(value = "listadotareasP")
	public String formularioListadoTareas() {
		return "vistas/Profesor/tareas/listadoTareas";
	}

	@PostMapping(value = "listadotareasP")
	public String listarTareas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "titulo") String titulo,
			@RequestParam(value = "tema", required = false) String tema,
			@RequestParam(value = "contenido", required = false) String contenido,
			@RequestParam(value = "fecha", required = false) String fecha,ModelMap model) {

		model.addAttribute("lista", tareasImpl.obtenerTemaPorIdAsignaturaNombre(id, tema, titulo, contenido, fecha));
		return "vistas/Profesor/tareas/listadoTareas";
	}

	@GetMapping(value = "insertartareasP")
	public String formularioInsertarTareas(ModelMap model) {
		model.addAttribute("listaTemas", combo.comboTemas());
		return "vistas/Profesor/tareas/insertarTareas";
	}

	@PostMapping(value = "insertartareasP")
	public String insertarTareas(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "temas") Integer idtemas,
			@RequestParam(value = "titulo") String titulo,
			@RequestParam(value = "contenido") String contenido,
			@RequestParam(value = "fecha") String fecha,
			ModelMap model) {

		model.addAttribute("lista", tareasImpl.insertarTareas(id, idtemas, titulo, contenido, fecha));
		model.addAttribute("listaTemas", combo.comboTemas());

		return "vistas/Profesor/tareas/insertarTareas";

	}
	
	@GetMapping(value = "formularioactualizartareasP")
	public String mostrarFormularioActualizarTareas() {			
		return "vistas/Profesor/tareas/actualizarTareas";
	}
	
	@PostMapping(value = "formularioactualizartareasP")
	public String formularioActualizarTareas(
			@RequestParam(value = "titulo") String titulo,
			@RequestParam(value = "temas", required = false) String tema,
			@RequestParam(value = "contenido", required = false) String contenido,
			@RequestParam(value = "fecha", required = false) String fecha,ModelMap model) {
			
		model.addAttribute("lista", tareasImpl.obtenerTemaPorAsignaturaNombre(tema, titulo, contenido, fecha));
		model.addAttribute("listaTemas", combo.comboTemas());
		
		return "vistas/Profesor/tareas/actualizarTareas";
	}
	
	@PostMapping(value = "actualizartareasP")
	public String actualizarTareas(
			@RequestParam(value = "idTareas") Integer id,
			@RequestParam(value = "temas") Integer idtemas,
			@RequestParam(value = "titulo") String titulo,
			@RequestParam(value = "contenido") String contenido,
			@RequestParam(value = "fecha") String fecha,
			ModelMap model) {		
			
		
		model.addAttribute("resultado", tareasImpl.actualizarTareas(id, idtemas, titulo, contenido, fecha));
		model.addAttribute("listaTemas", combo.comboTemas());
			
			
		
		
		return "vistas/Profesor/tareas/actualizarTareas";
	}

	
		@GetMapping(value = "formularioborrartareasP")
		public String mostrarFormularioBorrarTareas() {
			return "vistas/Profesor/tareas/eliminarTareas";
		}
			
		@PostMapping(value = "formularioborrartareasP")
		public String formularioBorrarTareas(
				@RequestParam(value = "titulo") String titulo,
				@RequestParam(value = "temas", required = false) String tema,
				@RequestParam(value = "contenido", required = false) String contenido,
				@RequestParam(value = "fecha", required = false) String fecha,ModelMap model) {
				
			model.addAttribute("lista", tareasImpl.obtenerTemaPorAsignaturaNombre(tema, titulo, contenido, fecha));
			model.addAttribute("listaTemas", combo.comboTemas());
			
			
			return "vistas/Profesor/tareas/eliminarTareas";
		}
			
			@PostMapping(value = "borrartareasP")
			public String borrarTareas(
					@RequestParam(value = "idTareas") Integer idTareas,
					ModelMap modelMap) {
				
				modelMap.addAttribute("resultado", tareasImpl.eliminarTareas(idTareas));
				return "vistas/Profesor/tareas/eliminarTareas";
			}
}
