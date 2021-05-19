package com.sergio.colegio.controladores.Administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.ComboDAO;
import com.sergio.colegio.dao.TemasDAO;

@Controller
public class TemasController {

	@Autowired
	private TemasDAO temaImpl;

	@Autowired
	private ComboDAO combo;

	@GetMapping(value = "listadotemasA")
	public String formularioListadoTemas() {
		return "vistas/Administrador/temas/listadoTemas";
	}

	@PostMapping(value = "listadotemasA")
	public String listarTemas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "nombre", required = false) String nombre, ModelMap model) {

		model.addAttribute("lista", temaImpl.obtenerTemaPorIdAsignaturaNombre(id, asignatura, nombre));
		return "vistas/Administrador/temas/listadoTemas";
	}

	@GetMapping(value = "insertartemasA")
	public String formularioInsertarTemas(ModelMap model) {
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		return "vistas/Administrador/temas/insertarTemas";
	}

	@PostMapping(value = "insertartemasA")
	public String insertarTemas(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "asignaturas") Integer idAsignatura,
			@RequestParam(value = "nombre") String nombre, ModelMap model) {

		model.addAttribute("resultado", temaImpl.insertarTemas(id, idAsignatura, nombre));
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());

		return "vistas/Administrador/temas/insertarTemas";

	}
	
	@GetMapping(value = "formularioactualizartemasA")
	public String mostrarFormularioActualizarTema() {			
		return "vistas/Administrador/temas/actualizarTemas";
	}
	
	@PostMapping(value = "formularioactualizartemasA")
	public String formularioActualizarTema(
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "nombre", required = false) String nombre, 
			ModelMap model) {
			
		model.addAttribute("lista", temaImpl.obtenerTemaPorAsignaturaNombre(asignatura, nombre));
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		
		return "vistas/Administrador/temas/actualizarTemas";
	}
	
	@PostMapping(value = "actualizartemaA")
	public String actualizarTema(
			@RequestParam(value = "idTema") Integer idTemas,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignaturas") Integer idAsignatura,
			ModelMap model) {		
			
		
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
			
		model.addAttribute("resultado", temaImpl.actualizarTemas(idTemas, idAsignatura, nombre));
		
		return "vistas/Administrador/temas/actualizarTemas";
	}

	

		@GetMapping(value = "formularioborrartemasA")
		public String mostrarFormularioBorrarTemas() {
			return "vistas/Administrador/temas/eliminarTemas";
		}
			
		@PostMapping(value = "formularioborrartemasA")
		public String formularioBorrarTemas(
				@RequestParam(value = "asignatura") String asignatura,
				@RequestParam(value = "nombre", required = false) String nombre, 
				ModelMap model) {
				
			model.addAttribute("lista", temaImpl.obtenerTemaPorAsignaturaNombre(asignatura, nombre));
			model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
			
			return "vistas/Administrador/temas/eliminarTemas";
		}
			
			@PostMapping(value = "borrartemasA")
			public String borrarTemas(
					@RequestParam(value = "idTema") Integer idTema,
					ModelMap modelMap) {
				
				modelMap.addAttribute("resultado", temaImpl.eliminarTemas(idTema));
				return "vistas/Administrador/temas/eliminarTemas";
			}
}
