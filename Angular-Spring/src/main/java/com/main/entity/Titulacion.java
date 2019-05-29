package com.main.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Titulacion {

	@Id
	private String idtitulacion;
	
	private String nombre;

	
	@OneToMany(mappedBy="titulacion", cascade= CascadeType.ALL)
	private Set<Asignatura> asignatura;

	
	public Titulacion(String idtitulacion, String nombre) {
		super();
		this.idtitulacion = idtitulacion;
		this.nombre = nombre;
	}

	
	
	public Titulacion() {}



	@Override
	public String toString() {
		return "Titulacion [idtitulacion=" + idtitulacion + ", nombre=" + nombre + "]";
	}
	
	
	
}
