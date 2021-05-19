package com.sergio.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sergio.colegio.dtos.TareasDTO;
import com.sergio.colegio.entities.TareasEntity;

@Repository
public interface TareasRepository extends CrudRepository<TareasEntity, Integer> {

	@Query(value = "select new com.sergio.colegio.dtos.TareasDTO (ta.id, te.id, te.nombre, ta.titulo,ta.contenido,ta.fecha) "
			+ "FROM com.sergio.colegio.entities.TareasEntity ta JOIN com.sergio.colegio.entities.TemasEntity te "
			+ "ON ta.temas.id = te.id "
			+ "WHERE (te.id LIKE CONCAT('%',:id,'%') or :id is null) "
			+ "AND te.nombre LIKE CONCAT ('%',:temas,'%')"
			+ "AND ta.titulo LIKE CONCAT ('%',:titulo,'%')"
			+ "AND ta.contenido LIKE CONCAT ('%',:contenido,'%') "
			+ "AND ta.fecha LIKE CONCAT ('%',:fecha,'%') ")
			  List<TareasDTO>obtenerTareasPorIdNombreTemasTituloContenidoFecha(
					  @Param("id") Integer id,
					  @Param("temas") String temas,
					  @Param("titulo") String titulo,
			  		  @Param("contenido") String contenido,
					  @Param("fecha") String fecha);

	@Query(value = "select new com.sergio.colegio.dtos.TareasDTO (ta.id, te.id, te.nombre, ta.titulo,ta.contenido,ta.fecha) "
			+ "FROM com.sergio.colegio.entities.TareasEntity ta JOIN com.sergio.colegio.entities.TemasEntity te "
			+ "ON ta.temas.id = te.id "
			+ "WHERE te.nombre LIKE CONCAT ('%',:temas,'%')"
			+ "AND ta.titulo LIKE CONCAT ('%',:titulo,'%')"
			+ "AND ta.contenido LIKE CONCAT ('%',:contenido,'%') "
			+ "AND ta.fecha LIKE CONCAT ('%',:fecha,'%') ")
	List<TareasDTO> obtenerTareasPorNombreTemasTituloContenidoFecha(
			 @Param("temas") String temas,
			  @Param("titulo") String titulo,
	  		  @Param("contenido") String contenido,
			  @Param("fecha") String fecha);

}
