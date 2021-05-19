package com.sergio.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sergio.colegio.dtos.ProfesorDTO;
import com.sergio.colegio.entities.ProfesorEntity;
@Repository
public interface ProfesorRepository extends CrudRepository<ProfesorEntity, Integer>{
	@Query(value = "select new com.sergio.colegio.dtos.ProfesorDTO (p.id, p.nombre, p.curso) "
			+ "FROM com.sergio.colegio.entities.ProfesorEntity p "
			+ "WHERE (p.id LIKE CONCAT('%',:id,'%') or :id is null) "
			+ "AND p.nombre LIKE CONCAT ('%',:nombre,'%') "
			+ "AND p.curso LIKE CONCAT ('%',:curso,'%' ) ")
			  List<ProfesorDTO>buscaAsignaturaPorIdNombreCursoTasa(
					  @Param("id") Integer id,
					  @Param("nombre") String nombre,
					  @Param("curso") String curso);
}
