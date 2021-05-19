package com.sergio.colegio.dao;

import java.util.List;

import com.sergio.colegio.dtos.TemasDTO;


public interface TemasDAO {
	
	List<TemasDTO> obtenerTemaPorIdAsignaturaNombre(Integer idTemas, String asignatura, String nombre); 
	List<TemasDTO> obtenerTemaPorAsignaturaNombre( String asignatura,String nombre); 
	Integer insertarTemas(Integer idTemas, Integer idAsignatura,String nombre);
	Integer actualizarTemas(Integer idTemas, Integer idAsignatura,String nombre);
	Integer eliminarTemas(Integer id);

}
