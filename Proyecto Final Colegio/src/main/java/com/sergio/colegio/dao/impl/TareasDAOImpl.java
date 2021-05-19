package com.sergio.colegio.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.colegio.dao.TareasDAO;
import com.sergio.colegio.dtos.TareasDTO;
import com.sergio.colegio.entities.TareasEntity;
import com.sergio.colegio.entities.TemasEntity;
import com.sergio.colegio.repositorios.TareasRepository;
import com.sergio.colegio.repositorios.TemasRepository;

@Service
public class TareasDAOImpl implements TareasDAO{
	

	@Autowired
	private TareasRepository tareasRepository;
	

	@Autowired
	private TemasRepository temasRepository;


	@Override
	public List<TareasDTO> obtenerTemaPorIdAsignaturaNombre(Integer idTareas, String temas, String titulo,
			String contenido, String fecha) {
		// TODO Auto-generated method stub
		return tareasRepository.obtenerTareasPorIdNombreTemasTituloContenidoFecha(idTareas, temas, titulo, contenido, fecha);
	}


	@Override
	public List<TareasDTO> obtenerTemaPorAsignaturaNombre(String temas, String titulo, String contenido, String fecha) {
		// TODO Auto-generated method stub
		return tareasRepository.obtenerTareasPorNombreTemasTituloContenidoFecha(temas, titulo, contenido, fecha);
	}


	@Override
	public Integer insertarTareas(Integer idTareas, Integer idTemas, String titulo, String contenido, String fecha) {
		if (fecha == "") {
			Date cDate = new Date();
		    fecha = new SimpleDateFormat("yyyy-MM-dd").format(cDate);
		}
		
		Optional<TemasEntity> tema = temasRepository.findById(idTemas);
		TemasEntity temas = tema.get();
		
		TareasEntity tareas = new TareasEntity(idTareas,temas,titulo,contenido,fecha);		
		tareasRepository.save(tareas);
		
		return 1;  
	}


	@Override
	public Integer actualizarTareas(Integer idTareas, Integer idTemas, String titulo, String contenido, String fecha) {
		Optional<TemasEntity> tema = temasRepository.findById(idTemas);
		TemasEntity temas = tema.get();
		
		TareasEntity tareas = new TareasEntity(idTareas,temas,titulo,contenido,fecha);		
		tareasRepository.save(tareas);
		
		return 1; 
	}


	@Override
	public Integer eliminarTareas(Integer idTareas) {
		tareasRepository.deleteById(idTareas);
		return 1;
	}



}
