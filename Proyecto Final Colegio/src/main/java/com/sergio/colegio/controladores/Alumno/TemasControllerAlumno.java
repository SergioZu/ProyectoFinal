package com.sergio.colegio.controladores.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.ComboDAO;
import com.sergio.colegio.dao.TemasDAO;

@Controller
public class TemasControllerAlumno {

	@Autowired
	private TemasDAO temaImpl;

	@Autowired
	private ComboDAO combo;

	@GetMapping(value = "listadotemasAL")
	public String formularioListadoTemas() {
		return "vistas/Alumno/temas/listadoTemas";
	}

	@PostMapping(value = "listadotemasAL")
	public String listarTemas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "nombre", required = false) String nombre, ModelMap model) {

		model.addAttribute("lista", temaImpl.obtenerTemaPorIdAsignaturaNombre(id, asignatura, nombre));
		return "vistas/Alumno/temas/listadoTemas";
	}

	
}
