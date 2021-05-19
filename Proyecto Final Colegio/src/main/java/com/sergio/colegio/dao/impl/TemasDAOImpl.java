package com.sergio.colegio.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.colegio.dao.TemasDAO;
import com.sergio.colegio.dtos.TemasDTO;
import com.sergio.colegio.entities.AsignaturaEntity;
import com.sergio.colegio.entities.TemasEntity;
import com.sergio.colegio.repositorios.AsignaturaRepository;
import com.sergio.colegio.repositorios.TemasRepository;

@Service
public class TemasDAOImpl implements TemasDAO{

	@Autowired
	private TemasRepository temasRepository;

	@Autowired 
	private AsignaturaRepository asignaturaRepository;
	

	
	@Override
	public List<TemasDTO> obtenerTemaPorIdAsignaturaNombre(Integer idTemas, String asignatura, String nombre) {
		// TODO Auto-generated method stub
		return temasRepository.obtenerTemasPorIdNombreAsignaturaNotaFecha(idTemas, asignatura, nombre);
	}

	@Override
	public List<TemasDTO> obtenerTemaPorAsignaturaNombre(String asignatura, String nombre) {
		// TODO Auto-generated method stub
		return temasRepository.obtenerTemasPorNombreAsignaturaNotaFecha( asignatura,nombre);
	}

	@Override
	public Integer insertarTemas(Integer idTemas, Integer idAsignatura, String nombre) {
		Optional<AsignaturaEntity> asig = asignaturaRepository.findById(idAsignatura);
		AsignaturaEntity asignatura = asig.get();
		
		TemasEntity tema = new TemasEntity(idTemas,asignatura,nombre);		
		temasRepository.save(tema);
		
		return 1;  
	}

	@Override
	public Integer actualizarTemas(Integer idTemas, Integer idAsignatura, String nombre) {
		Optional<AsignaturaEntity> asig = asignaturaRepository.findById(idAsignatura);
		AsignaturaEntity asignatura = asig.get();
		
		TemasEntity tema = new TemasEntity(idTemas,asignatura,nombre);		
		temasRepository.save(tema);
		
		return 1;  
	}

	@Override
	public Integer eliminarTemas(Integer id) {
		temasRepository.deleteById(id);
		return 1;
	}

}
