package com.sergio.colegio.dtos;

public class ProfesorDTO {

	private int id;
	private String nombre;
	private String curso;

	public ProfesorDTO() {
		super();
	}

	public ProfesorDTO(int id, String nombre, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
	}

	public ProfesorDTO(String nombre, String curso) {
		super();
		this.nombre = nombre;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
