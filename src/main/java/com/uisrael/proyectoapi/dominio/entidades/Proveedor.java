package com.uisrael.proyectoapi.dominio.entidades;

import java.time.LocalDateTime;

public final class Proveedor {

	private final int idProveedor;
	private final String Proveedor; // Ejemplo: CompuParts S.A.
	private final String nombreContacto;
	private final String apellidoContacto;
	private final String telefono;
	private final String correo;
	private final String notas;
	private final LocalDateTime creadoEn;
	private final boolean estado; //true: activo - false: eliminado
	
	public Proveedor(int idProveedor, String proveedor, String nombreContacto, String apellidoContacto, String telefono,
			String correo, String notas, LocalDateTime creadoEn, boolean estado) {
		this.idProveedor = idProveedor;
		Proveedor = proveedor;
		this.nombreContacto = nombreContacto;
		this.apellidoContacto = apellidoContacto;
		this.telefono = telefono;
		this.correo = correo;
		this.notas = notas;
		this.creadoEn = creadoEn;
		this.estado = estado;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public String getProveedor() {
		return Proveedor;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public String getApellidoContacto() {
		return apellidoContacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public String getNotas() {
		return notas;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public boolean isEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", Proveedor=" + Proveedor + ", nombreContacto="
				+ nombreContacto + ", apellidoContacto=" + apellidoContacto + ", telefono=" + telefono + ", correo="
				+ correo + ", notas=" + notas + ", creadoEn=" + creadoEn + ", estado=" + estado + "]";
	}
}
