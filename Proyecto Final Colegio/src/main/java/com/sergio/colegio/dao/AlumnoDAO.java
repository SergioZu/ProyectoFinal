package com.sergio.colegio.dao;

import java.util.List;

import com.sergio.colegio.dtos.AlumnoDTO;
import com.sergio.colegio.entities.AlumnoEntity;

public interface AlumnoDAO {
	List<AlumnoDTO> obtenerAlumnosporIdyNombre(Integer id, String nombre);
	Integer insertarAlumno(Integer id, String nombre, Integer idMunicipio, Integer famNumerosa);
	Integer actualizarAlumno(Integer id, String nombre, Integer idMunicipio, Integer famNumerosa);
	Integer eliminarAlumno(Integer id);
	boolean esFamiliaNumerosa(Integer idAlumno);
}
