package com.sergio.colegio.dtos;

public class TareasDTO {
	private Integer id;	
	private Integer idTemas;
	private String nombreTema;
	private String titulo;
	private String contenido;
	private String fecha;
	public TareasDTO() {
		super();
	}
	public TareasDTO(Integer id, Integer idTemas, String nombreTema, String titulo, String contenido, String fecha) {
		super();
		this.id = id;
		this.idTemas = idTemas;
		this.nombreTema = nombreTema;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha = fecha;
	}
	public TareasDTO(Integer idTemas, String nombreTema, String titulo, String contenido, String fecha) {
		super();
		this.idTemas = idTemas;
		this.nombreTema = nombreTema;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha = fecha;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdTemas() {
		return idTemas;
	}
	public void setIdTemas(Integer idTemas) {
		this.idTemas = idTemas;
	}
	public String getNombreTema() {
		return nombreTema;
	}
	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
	
	
	

}
