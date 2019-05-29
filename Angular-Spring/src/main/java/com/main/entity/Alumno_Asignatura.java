package com.main.entity;


import java.io.Serializable;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity(name = "alumno_asignatura")
@Table(name="alumno_asignatura")
public class Alumno_Asignatura implements Serializable{
	

	@Embeddable
	public static class Composited_pk implements Serializable {
		@ManyToOne
		@JoinColumn(name="idalumno", referencedColumnName = "idalumno")
		private Alumno idalumno;
		
		
		@ManyToOne
		@JoinColumn(name="idasignatura", referencedColumnName = "idasignatura")
		private Asignatura idasignatura;
		
		
		@Column(name="Numeromatricula")
		private int Numeromatricula;
	   
		 
		public Composited_pk() {}
		
		public Composited_pk(Alumno idalumno, Asignatura idasignatura, int numeromatricula) {
			super();
			this.idalumno = idalumno;
			this.idasignatura = idasignatura;
			this.Numeromatricula = numeromatricula;
		}
  
		@Override
		public String toString() {
			return "idalumno=" + idalumno.getIdalumno() + ", idasignatura=" + idasignatura.getIdasignatura() + ", Numeromatricula="
					+ Numeromatricula + "]";
		}

		
		
		
	}
	
	
	@EmbeddedId
	private Composited_pk pk;

	
	
	public Alumno_Asignatura() {}
	
	
	public Alumno_Asignatura( Composited_pk pk) {
		super();
		this.pk = pk;
	}


	
	
	public Composited_pk getPk() {
		return pk;
	}

	public void setPk(Composited_pk pk) {
		this.pk = pk;
	}

	@Override
	public String toString() {
		return "Alumno_Asignatura [pk=" + pk + "]";
	}

	
	
}
	
	
