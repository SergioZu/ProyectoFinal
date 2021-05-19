package com.sergio.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.sergio.colegio.dtos.TemasDTO;
import com.sergio.colegio.entities.TemasEntity;
@Repository
public interface TemasRepository extends CrudRepository<TemasEntity, Integer>{
	
	@Query(value = "select new com.sergio.colegio.dtos.TemasDTO (t.id, asig.id, asig.nombre, t.nombre) "
			+ "FROM com.sergio.colegio.entities.TemasEntity t JOIN com.sergio.colegio.entities.AsignaturaEntity asig "
			+ "ON t.asignaturas.id = asig.id "
			+ "WHERE (t.id LIKE CONCAT('%',:id,'%') or :id is null) "
			+ "AND asig.nombre LIKE CONCAT ('%',:asignatura,'%')"
			+ "AND t.nombre LIKE CONCAT ('%',:nombre,'%') ")
			  List<TemasDTO>obtenerTemasPorIdNombreAsignaturaNotaFecha(
					  @Param("id") Integer id,
					  @Param("asignatura") String asignatura,
					  @Param("nombre") String nombre);
	
	@Query(value = "select new com.sergio.colegio.dtos.TemasDTO (t.id, asig.id, asig.nombre, t.nombre) "
			+ "FROM com.sergio.colegio.entities.TemasEntity t JOIN com.sergio.colegio.entities.AsignaturaEntity asig "
			+ "ON t.asignaturas.id = asig.id "
			+ "WHERE asig.nombre LIKE CONCAT ('%',:asignatura,'%')"
			+ "AND t.nombre LIKE CONCAT ('%',:nombre,'%') ")
			  List<TemasDTO>obtenerTemasPorNombreAsignaturaNotaFecha(
					  @Param("asignatura") String asignatura,
					  @Param("nombre") String nombre);
	
	
	
	

}
