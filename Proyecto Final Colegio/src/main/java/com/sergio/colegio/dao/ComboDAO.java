package com.sergio.colegio.dao;

import java.util.List;

import com.sergio.colegio.dtos.ComboDTO;

public interface ComboDAO {
	List<ComboDTO> comboMunicipios();
	List<ComboDTO> comboAlumnos();
	List<ComboDTO> comboAsignaturas();
	List<ComboDTO> comboTemas();
}
