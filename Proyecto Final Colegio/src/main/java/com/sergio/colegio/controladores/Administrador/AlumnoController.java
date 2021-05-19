package com.sergio.colegio.controladores.Administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.AlumnoDAO;
import com.sergio.colegio.dao.ComboDAO;

@Controller
public class AlumnoController {

	@Autowired
	private ComboDAO combo;

	@Autowired
	private AlumnoDAO alumnoImpl;

	@GetMapping(value = "listadoalumnosA")
	public String formularioListadoAlumnos(ModelMap model) {
		return "vistas/Administrador/alumnos/listadoAlumnos";
	}

	@PostMapping(value = "listadoalumnosA")
	public String listarAlumnos(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, ModelMap model) {

		model.addAttribute("lista", alumnoImpl.obtenerAlumnosporIdyNombre(id, nombre));
		return "vistas/Administrador/alumnos/listadoAlumnos";
	}

	@GetMapping(value = "insertaralumnoA")
	public String formularioInsertarAlumno(ModelMap model) {
		model.addAttribute("listaMunicipios", combo.comboMunicipios());

		return "vistas/Administrador/alumnos/insertarAlumnos";
	}

	@PostMapping(value = "insertaralumnoA")
	public String insertarAlumno(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "municipios") Integer idMunicipio,
			@RequestParam(value = "familiaNumerosa", required = false) Integer familiaNumerosa, ModelMap model) {
		
		
		model.addAttribute("listaMunicipios", combo.comboMunicipios());
		model.addAttribute("resultado", alumnoImpl.insertarAlumno(id, nombre, idMunicipio, familiaNumerosa));
		
		
		

		return "vistas/Administrador/alumnos/insertarAlumnos";

	}

	
	@GetMapping(value = "formularioeliminaralumnoA")
	public String mostrarFormularioBorrarAlumnos() {
		return "vistas/Administrador/alumnos/eliminarAlumnos";
	}

	@PostMapping(value = "formularioeliminaralumnoA")
	public String formularioBorrarAlumnos(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, ModelMap model) {

		model.addAttribute("lista", alumnoImpl.obtenerAlumnosporIdyNombre(id, nombre));
		return "vistas/Administrador/alumnos/eliminarAlumnos";
	}

	@PostMapping(value = "eliminaralumnoA")
	public String borrarAlumnos(@RequestParam(value = "id") Integer id, ModelMap modelMap) {

		modelMap.addAttribute("resultado", alumnoImpl.eliminarAlumno(id));
		return "vistas/Administrador/alumnos/eliminarAlumnos";
	}

	
	@GetMapping(value = "formularioactualizaralumnosA")
	public String mostrarFormularioActualizarAlumnos() {

		return "vistas/Administrador/alumnos/actualizarAlumnos";
	}

	@PostMapping(value = "formularioactualizaralumnosA")
	public String formularioActualizarAlumnos(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nombre") String nombre, ModelMap model) {

		model.addAttribute("lista", alumnoImpl.obtenerAlumnosporIdyNombre(id, nombre));
		model.addAttribute("listaMunicipios", combo.comboMunicipios());
		return "vistas/Administrador/alumnos/actualizarAlumnos";
	}

	@PostMapping(value = "actualizaralumnoA")
	public String actualizarAlumnos(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "municipios") Integer idMunicipio,
			@RequestParam(value = "familiaNumerosa", required = false) Integer famNumerosa, ModelMap modelMap) {

		modelMap.addAttribute("listaMunicipios", combo.comboMunicipios());
		modelMap.addAttribute("resultado", alumnoImpl.actualizarAlumno(id, nombre, idMunicipio, famNumerosa));

		return "vistas/Administrador/alumnos/actualizarAlumnos";
	}
}
