package com.sergio.colegio.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.sergio.colegio.entities.AsignaturaEntity;

public interface ComboAsignaturaRepository extends CrudRepository<AsignaturaEntity, Integer> {

}
