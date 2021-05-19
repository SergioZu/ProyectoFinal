package com.sergio.colegio.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.colegio.dao.UsuariosDAO;
import com.sergio.colegio.dtos.TemasDTO;
import com.sergio.colegio.dtos.UsuariosDTO;
import com.sergio.colegio.repositorios.UsuariosRepository;
@Service
public class UsuarioDAOImpl implements UsuariosDAO{

	@Autowired
	private UsuariosRepository usuariosRepository;
	@Override
	public List<UsuariosDTO> obtenerRolporUsernameyPassword(String username, String password) {
		// TODO Auto-generated method stub
		return usuariosRepository.obtenerRolPorUsernamePassword(username, password);
	}

}
