package com.uisrael.proyectoapi.dominio.entidades;

import java.time.LocalDateTime;

public final class Usuario {

	private final int idUsuario;
	private final String usuario; 
	private final String nombre;
	private final String apellido;
	private final String rol;
	private final String telefono;
	private final String correo;
	private final LocalDateTime creadoEn;
	private final boolean estado; 
	private final String passwordHash;
	
	public Usuario(int idUsuario, String usuario, String nombre, String apellido, String rol, String telefono,
			String correo, LocalDateTime creadoEn, boolean estado, String passwordHash) {
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
		this.telefono = telefono;
		this.correo = correo;
		this.creadoEn = creadoEn;
		this.estado = estado;
		this.passwordHash = passwordHash;
	}



	public int getIdUsuario() {
		return idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getRol() {
		return rol;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public boolean isEstado() {
		return estado;
	}
	
	
	public String getPasswordHash() {
		return passwordHash;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario + ", nombre=" + nombre + ", apellido="
				+ apellido + ", rol=" + rol + ", telefono=" + telefono + ", correo=" + correo + ", creadoEn=" + creadoEn
				+ ", estado=" + estado + ", passwordHash=" + passwordHash + "]";
	}
}
