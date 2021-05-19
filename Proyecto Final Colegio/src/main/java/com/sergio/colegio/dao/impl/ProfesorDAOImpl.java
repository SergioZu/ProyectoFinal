package com.sergio.colegio.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.colegio.dao.ProfesorDAO;
import com.sergio.colegio.dtos.ProfesorDTO;
import com.sergio.colegio.entities.ProfesorEntity;
import com.sergio.colegio.repositorios.ProfesorRepository;

@Service
public class ProfesorDAOImpl implements ProfesorDAO{

	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Override
	public List<ProfesorDTO> obtenerProfesorporIdyNombre(Integer id, String nombre, String curso) {
		
		return profesorRepository.buscaAsignaturaPorIdNombreCursoTasa(id, nombre, curso);
	}

	@Override
	public Integer insertarProfesor(Integer id, String nombre, String curso) {
	
		ProfesorEntity profesor=new ProfesorEntity(id,nombre,curso);
		 profesorRepository.save(profesor);
		 
		 return 1;
	}

	@Override
	public Integer actualizarProfesor(Integer id, String nombre, String curso) {
		
		ProfesorEntity profesor=new ProfesorEntity(id,nombre,curso);
		 profesorRepository.save(profesor);
		 
		 return 1;
	}

	@Override
	public Integer eliminarProfesor(Integer id) {
		profesorRepository.deleteById(id);
		return 1;
	}

}
