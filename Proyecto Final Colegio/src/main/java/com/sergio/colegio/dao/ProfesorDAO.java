package com.sergio.colegio.dao;

import java.util.List;

import com.sergio.colegio.dtos.ProfesorDTO;



public interface ProfesorDAO {
	
	List<ProfesorDTO> obtenerProfesorporIdyNombre(Integer id, String nombre,String curso);
	Integer insertarProfesor(Integer id, String nombre,String curso);
	Integer actualizarProfesor(Integer id, String nombre,String curso);
	Integer eliminarProfesor(Integer id);

}
