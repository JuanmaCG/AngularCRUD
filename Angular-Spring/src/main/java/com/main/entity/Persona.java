package com.main.entity;

import javax.persistence.*;



//import org.springframework.transaction.annotation.Transactional;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

	@Id
	private String dni;
	private String nombre;
	private String apellido;
	private String ciudad;
	private String direccioncalle;
	private int direccionnum;
	private String telefono;
	private int varon;
	
	
	public Persona() {}
	
	public Persona(String dni, String nombre, String apellido, String ciudad, String direccioncalle,
			int direccionnum, String telefono, int varon) {
		
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.direccioncalle = direccioncalle;
		this.direccionnum = direccionnum;
		this.telefono = telefono;
		this.varon = varon;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccioncalle() {
		return direccioncalle;
	}

	public void setDireccioncalle(String direccioncalle) {
		this.direccioncalle = direccioncalle;
	}

	public int getDireccionnum() {
		return direccionnum;
	}

	public void setDireccionnum(int direccionnum) {
		this.direccionnum = direccionnum;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getVaron() {
		return varon;
	}

	public void setVaron(int varon) {
		this.varon = varon;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", ciudad=" + ciudad
				+ ", direccioncalle=" + direccioncalle + ", direccionnum=" + direccionnum + ", telefono=" + telefono
				+ ", varon=" + varon + "]";
	}
	
	
	
}
