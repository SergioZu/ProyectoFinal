package com.sergio.colegio.dao;

import java.util.List;

import com.sergio.colegio.dtos.TemasDTO;
import com.sergio.colegio.dtos.UsuariosDTO;

public interface UsuariosDAO {
	List<UsuariosDTO>  obtenerRolporUsernameyPassword(String username, String password);
}
