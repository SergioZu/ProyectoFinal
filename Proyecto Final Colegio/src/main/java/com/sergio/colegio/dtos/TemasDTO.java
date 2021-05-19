package com.sergio.colegio.dtos;

public class TemasDTO {
	private Integer id;	
	private Integer idAsignatura;
	private String nombreAsignatura;
	private String nombre;
	
	
	public TemasDTO(Integer id, Integer idAsignatura, String nombreAsignatura, String nombre) {
		super();
		this.id = id;
		this.idAsignatura = idAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.nombre = nombre;
	}
	
	
	
	
	public TemasDTO(Integer idAsignatura, String nombreAsignatura, String nombre) {
		super();
		this.idAsignatura = idAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.nombre = nombre;
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdAsignatura() {
		return idAsignatura;
	}
	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
