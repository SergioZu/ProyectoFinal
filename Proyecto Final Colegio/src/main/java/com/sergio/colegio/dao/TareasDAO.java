package com.sergio.colegio.dao;

import java.util.List;

import com.sergio.colegio.dtos.TareasDTO;

public interface TareasDAO {
	
	List<TareasDTO> obtenerTemaPorIdAsignaturaNombre(Integer idTareas, String temas, String titulo,String contenido,String fecha); 
	List<TareasDTO> obtenerTemaPorAsignaturaNombre( String temas,String titulo,String contenido,String fecha); 
	Integer insertarTareas(Integer idTareas, Integer idTemas,String titulo,String contenido,String fecha);
	Integer actualizarTareas(Integer idTareas, Integer idTemas,String titulo,String contenido,String fecha);
	Integer eliminarTareas(Integer idTareas);

}
