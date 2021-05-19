package com.sergio.colegio.controladores.Administrador;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sergio.colegio.dao.ComboDAO;
import com.sergio.colegio.dao.MatriculacionDAO;
import com.sergio.colegio.negocio.INegocio;

@Controller
public class MatriculacionController {
	@Autowired
	private MatriculacionDAO matriculacionImpl;
	
	@Autowired
	private ComboDAO comboImpl;
	
	@Autowired 
	private INegocio negocioImpl;
	
	
	@GetMapping(value = "listadomatriculacionesA")
	public String formularioListadoMatriculaciones() {
		return "vistas/Administrador/matriculaciones/listadoMatriculaciones";
	}
	
	@PostMapping(value = "listadomatriculacionesA")
	public String listadoMatriculaciones(
			@RequestParam(value = "idAsig", required = false) Integer idAsig,
			@RequestParam(value = "nombreAsig", required = false) String nombreAsig,
			@RequestParam(value = "idAlum", required = false) Integer idAlum,
			@RequestParam(value= "nombreAlum", required = false) String nombreAlum,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "activo") Integer activo,
			ModelMap model) {
		
		model.addAttribute("lista", matriculacionImpl.obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(idAsig, nombreAsig, idAlum, nombreAlum, fecha, activo));
		return "vistas/Administrador/matriculaciones/listadoMatriculaciones";
	}
	
	
	@GetMapping(value = "insertarmatriculacionA")
	public String insertarMatriculaFormulario(ModelMap model) {
			
		model.addAttribute("listaAlumnos", comboImpl.comboAlumnos());
		model.addAttribute("listaAsignaturas", comboImpl.comboAsignaturas());
			
		return "vistas/Administrador/matriculaciones/insertarMatriculaciones";
	}
		
		@PostMapping(value = "insertarmatriculacionA")
		public String insertarMatricula(
				@RequestParam(value = "alumnos") Integer idAlumno, 
				@RequestParam(value = "asignaturas") Integer idAsignatura,
				@RequestParam(value = "tasa",  required = false) Double tasa,
				@RequestParam(value = "fecha", required = false) String fecha, 
				ModelMap model){			
			
			model.addAttribute("resultado", matriculacionImpl.insertarMatriculacion(idAlumno, idAsignatura, tasa, fecha));
			
			model.addAttribute("listaAlumnos", comboImpl.comboAlumnos());
			model.addAttribute("listaAsignaturas", comboImpl.comboAsignaturas());
			
			return "vistas/Administrador/matriculaciones/insertarMatriculaciones";
			
		}
		
		
		@PostMapping(value = "tasa")
		@ResponseBody
		public Double calculoTasa(
				@RequestParam(value = "alumnos") Integer idAlumno,
				@RequestParam(value = "asignaturas") Integer idAsignatura) {	
			
			return negocioImpl.calcularTasa(idAlumno, idAsignatura); 
		}
		
		
		@GetMapping(value = "formularioborrarmatriculacionesA")
		public String mostrarFormularioBorrarMatricula() {
			return "vistas/Administrador/matriculaciones/borrarMatriculaciones";
		}
			
		@PostMapping(value = "formularioborrarmatriculacionesA")
		public String formularioBorrarMatriculaciones(
				@RequestParam(value = "idAsig", required = false) Integer idAsig,
				@RequestParam(value = "nombreAsig", required = false) String nombreAsig,
				@RequestParam(value = "idAlum", required = false) Integer idAlum,
				@RequestParam(value= "nombreAlum", required = false) String nombreAlum,
				@RequestParam(value = "fecha", required = false) String fecha,
				@RequestParam(value = "activo") Integer activo,
				ModelMap model) {
				
			model.addAttribute("lista", matriculacionImpl.obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(idAsig, nombreAsig, idAlum, nombreAlum, fecha, activo));
			return "vistas/Administrador/matriculaciones/borrarMatriculaciones";
		}
			
		@PostMapping(value = "borrarmatriculacionesA")
		public String morrarMatricula(
				@RequestParam(value = "idMatricula") Integer idMatricula,
				ModelMap modelMap) {
				
			modelMap.addAttribute("resultado", matriculacionImpl.borrarMatriculacion(idMatricula));
			return "vistas/Administrador/matriculaciones/borrarMatriculaciones";
		}
}
