package com.main.entity;


import javax.persistence.*;

 

@Entity
public class Asignatura {
	
	public Asignatura () {}
	@Id
	private String idasignatura;
	
	@ManyToOne
	@JoinColumn(name = "idprofesor",referencedColumnName = "idprofesor")
	private Profesor profesor;
	
	@ManyToOne
	@JoinColumn(name = "idtitulacion", referencedColumnName= "idtitulacion")
	private Titulacion titulacion;
	
	

	public Asignatura(String idasignatura, Profesor profesor, Titulacion titulacion) {
		super();
		this.idasignatura = idasignatura;
		this.profesor = profesor;
		this.titulacion = titulacion;
	}

	public String getIdasignatura() {
		return idasignatura;
	}

	public void setIdasignatura(String idasignatura) {
		this.idasignatura = idasignatura;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}



	@Override
	public String toString() {
		return "Asignatura [idasignatura=" + idasignatura + ", profesor=" + profesor + ", titulacion=" + titulacion + "]";
	}
	
	
	
	
}
