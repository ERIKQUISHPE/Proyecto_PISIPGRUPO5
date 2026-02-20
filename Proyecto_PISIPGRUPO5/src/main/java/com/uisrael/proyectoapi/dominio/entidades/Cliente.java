package com.uisrael.proyectoapi.dominio.entidades;

import java.time.LocalDateTime;

public final class Cliente {

	private final int idCliente;
	private final String nombre;
	private final String apellido;
	private final String ci;
	private final String telefono;
	private final String correo;
	private final String direccion;
	private final LocalDateTime creadoEn;
	
	public Cliente(int idCliente, String nombre, String apellido, String ci, String telefono, String correo,
			String direccion, LocalDateTime creadoEn) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.creadoEn = creadoEn;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCi() {
		return ci;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", ci=" + ci
				+ ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", creadoEn="
				+ creadoEn + "]";
	}
}
