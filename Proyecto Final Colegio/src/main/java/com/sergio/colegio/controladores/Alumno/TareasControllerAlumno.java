package com.sergio.colegio.controladores.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.ComboDAO;
import com.sergio.colegio.dao.TareasDAO;

@Controller
public class TareasControllerAlumno {

	@Autowired
	private TareasDAO tareasImpl;

	@Autowired
	private ComboDAO combo;

	@GetMapping(value = "listadotareasAL")
	public String formularioListadoTareas() {
		return "vistas/Alumno/tareas/listadoTareas";
	}

	@PostMapping(value = "listadotareasAL")
	public String listarTareas(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "titulo") String titulo,
			@RequestParam(value = "tema", required = false) String tema,
			@RequestParam(value = "contenido", required = false) String contenido,
			@RequestParam(value = "fecha", required = false) String fecha,ModelMap model) {

		model.addAttribute("lista", tareasImpl.obtenerTemaPorIdAsignaturaNombre(id, tema, titulo, contenido, fecha));
		return "vistas/Alumno/tareas/listadoTareas";
	}

}
