package com.sergio.colegio.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.sergio.colegio.entities.AlumnoEntity;

public interface ComboAlumnosRepository extends CrudRepository<AlumnoEntity, Integer> {

}
