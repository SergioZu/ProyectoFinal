package com.sergio.colegio.dao;

import java.util.List;



import com.sergio.colegio.dtos.NotaDTO;

public interface NotaDAO {
	List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(Integer idAlumno, String nombre, String asignatura, Double nota, String fecha); 
	List<NotaDTO> obtenerNotaPorNombreAsignaturaFecha(String nombre, String asignatura, String fecha); 
	Integer insertarNota(Integer idAlumno, Integer idAsignatura, Double nota, String fecha);
	Integer actualizarNota(Integer idNota, Integer idAlumno, Integer idAsignatura, Double nota, String fecha);
	Integer eliminarNota(Integer id);
}
