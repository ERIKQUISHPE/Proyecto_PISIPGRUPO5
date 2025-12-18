package com.uisrael.proyectoapi.dominio.entidades;

import java.math.BigDecimal;

public final class Material {

	private final int idMaterial;
	private final String codigoMaterial;
	private final String nombre;
	private final String descripcion;
	private final BigDecimal costoCompra;
	private final BigDecimal costoVenta;
	private final int idProveedor; // Relacion con Clase "Proveedor"
	private final Integer stock; // Puede ser null
	private final boolean estado; //true: activo - false: eliminado
	
	public Material(int idMaterial, String codigoMaterial, String nombre, String descripcion, BigDecimal costoCompra,
			BigDecimal costoVenta, int idProveedor, Integer stock, boolean estado) {
		this.idMaterial = idMaterial;
		this.codigoMaterial = codigoMaterial;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costoCompra = costoCompra;
		this.costoVenta = costoVenta;
		this.idProveedor = idProveedor;
		this.stock = stock;
		this.estado = estado;
	}

	public int getIdMaterial() {
		return idMaterial;
	}

	public String getCodigoMaterial() {
		return codigoMaterial;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public BigDecimal getCostoCompra() {
		return costoCompra;
	}

	public BigDecimal getCostoVenta() {
		return costoVenta;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public Integer getStock() {
		return stock;
	}

	public boolean isEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Materiales [idMaterial=" + idMaterial + ", codigoMaterial=" + codigoMaterial + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", costoCompra=" + costoCompra + ", costoVenta=" + costoVenta
				+ ", idProveedor=" + idProveedor + ", stock=" + stock + ", estado=" + estado + "]";
	}
}
