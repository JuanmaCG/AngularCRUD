package com.main.entity;

import java.io.Serializable;

import javax.persistence.*;



@SuppressWarnings("serial")
@Entity

public class Profesor extends Persona implements Serializable{
	
	private String idprofesor;

	public Profesor () {}
	
	protected Profesor(String idprofesor, String dni) {
		super.setDni(dni);;
		this.idprofesor = idprofesor;
	}

	public String getIdprofesor() {
		return idprofesor;
	}

	public void setIdprofesor(String idprofesor) {
		this.idprofesor = idprofesor;
	}

	@Override
	public String toString() {
		return "Profesor [idprofesor=" + idprofesor + ", getDni()=" + getDni() + "]";
	}
	
	
}
