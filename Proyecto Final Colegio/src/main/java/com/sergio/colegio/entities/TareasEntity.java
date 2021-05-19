package com.sergio.colegio.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tareas")
public class TareasEntity {


	@Id
	@Column(name = "id")
	private Integer id;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_temas") 
	private TemasEntity temas;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "contenido")
	private String contenido;
	
	@Column(name = "fecha")
	private String fecha;

	public TareasEntity() {
		super();
	}

	public TareasEntity(Integer id, TemasEntity temas, String titulo, String contenido, String fecha) {
		super();
		this.id = id;
		this.temas = temas;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha = fecha;
	}

	public TareasEntity(TemasEntity temas, String titulo, String contenido, String fecha) {
		super();
		this.temas = temas;
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

	public TemasEntity getTemas() {
		return temas;
	}

	public void setTemas(TemasEntity temas) {
		this.temas = temas;
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
