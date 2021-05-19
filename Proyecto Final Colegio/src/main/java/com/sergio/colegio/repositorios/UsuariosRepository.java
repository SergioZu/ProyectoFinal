package com.sergio.colegio.repositorios;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sergio.colegio.dtos.TemasDTO;
import com.sergio.colegio.dtos.UsuariosDTO;
import com.sergio.colegio.entities.UsuariosEntity;

@Repository
public interface UsuariosRepository extends CrudRepository<UsuariosEntity, Integer>{

	
	@Query(value = "select new com.sergio.colegio.dtos.UsuariosDTO (u.rol) "
			+ "FROM com.sergio.colegio.entities.UsuariosEntity u "
			+ "WHERE u.username LIKE CONCAT ('%',:username,'%')"
			+ "AND u.password LIKE CONCAT ('%',:password,'%') ")
	 		List<UsuariosDTO> obtenerRolPorUsernamePassword(
					  @Param("username") String username,
					  @Param("password") String password);
}
