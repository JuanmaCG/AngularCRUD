package com.main.entity;

import java.io.Serializable;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity

public class Alumno extends Persona implements Serializable{

	private String idalumno;
	
	public Alumno() {}
	
	public Alumno(String idalumno, String dni) {
		super.setDni(dni);
		this.idalumno = idalumno;
	}
	
	public String getIdalumno() {
		return idalumno;
	}
	
	public void setIdalumno(String id) {
		this.idalumno = id;
	}
	
	@Override
	public String toString() {
		return "Alumno [id=" + idalumno + ", getDni()=" + getDni() + "]";
	}

	
	
}
