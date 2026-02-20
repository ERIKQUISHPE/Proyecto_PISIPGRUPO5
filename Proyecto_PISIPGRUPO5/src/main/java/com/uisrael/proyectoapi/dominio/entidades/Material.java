package com.uisrael.proyectoapi.dominio.entidades;

import java.math.BigDecimal;

public final class Material {

	private final int idMaterial;
	private final String codigoMaterial;
	private final String nombre;
	private final String descripcion;
	private final BigDecimal costoCompra;
	private final BigDecimal costoVenta;
	private final Integer stock; 
	private final boolean estado; 
	private Proveedor fkProveedor;
	
	public Material(int idMaterial, String codigoMaterial, String nombre, String descripcion, BigDecimal costoCompra,
			BigDecimal costoVenta, Integer stock, boolean estado, Proveedor fkProveedor) {
		super();
		this.idMaterial = idMaterial;
		this.codigoMaterial = codigoMaterial;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costoCompra = costoCompra;
		this.costoVenta = costoVenta;
		this.stock = stock;
		this.estado = estado;
		this.fkProveedor = fkProveedor;
	}

	public Proveedor getFkProveedor() {
		return fkProveedor;
	}

	public void setFkProveedor(Proveedor fkProveedor) {
		this.fkProveedor = fkProveedor;
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

	public Integer getStock() {
		return stock;
	}

	public boolean isEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Material [idMaterial=" + idMaterial + ", codigoMaterial=" + codigoMaterial + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", costoCompra=" + costoCompra + ", costoVenta=" + costoVenta
				+ ", stock=" + stock + ", estado=" + estado + ", fkProveedor=" + fkProveedor
				+ "]";
	}

}
