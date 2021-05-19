package com.sergio.colegio.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="temas")
public class TemasEntity {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_asignatura") 
	private AsignaturaEntity asignaturas;
	
	@Column(name = "nombre")
	private String nombre;

	
	

	public TemasEntity() {
		super();
	}



	public TemasEntity(Integer id, AsignaturaEntity asignaturas, String nombre) {
		super();
		this.id = id;
		this.asignaturas = asignaturas;
		this.nombre = nombre;
	}



	public TemasEntity(AsignaturaEntity asignaturas, String nombre) {
		super();
		this.asignaturas = asignaturas;
		this.nombre = nombre;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AsignaturaEntity getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(AsignaturaEntity asignaturas) {
		this.asignaturas = asignaturas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
