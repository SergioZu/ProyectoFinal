package com.sergio.colegio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sergio.colegio.dao.UsuariosDAO;

@Controller
public class UsuariosController {

	private String roles;

	@Autowired
	private UsuariosDAO usuariosDAO;

	@GetMapping(value = "login")
	public String vistaLogin(ModelMap model) {

		return "index";
	}

	@PostMapping(value = "login")
	public String distribucionRoles(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, ModelMap model) {

		roles = usuariosDAO.obtenerRolporUsernameyPassword(username, password).get(0).getRol();

		if (!username.equals("") || !password.equals("")) {
			if (roles.equals("administrador")) {
				return "vistas/menuAdministrador";
			} else if (roles.equals("alumno")) {
				return "vistas/menuAlumno";
			} else if (roles.equals("profesor")) {
				return "vistas/menuProfesor";
			}
		}
		return "index";

	}

	@GetMapping(value = "MenuA")
	public String MenuAdmin(ModelMap model) {

		return "vistas/menuAdministrador";
	}

	@GetMapping(value = "MenuP")
	public String MenuProfesor(ModelMap model) {

		return "vistas/menuProfesor";
	}

	@GetMapping(value = "MenuAL")
	public String MenuAlumno(ModelMap model) {

		return "vistas/menuAlumno";
	}
}
