package com.uisrael.proyectoapi.presentacion.dto.response;

import java.math.BigDecimal;	

public class MaterialResponseDTO {
	private int idMaterial;
	private String codigoMaterial;
	private String nombre;
	private String descripcion;
	private BigDecimal costoCompra;
	private BigDecimal costoVenta;
	private Integer stock;
	private boolean estado;
	
	public int getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}
	public String getCodigoMaterial() {
		return codigoMaterial;
	}
	public void setCodigoMaterial(String codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getCostoCompra() {
		return costoCompra;
	}
	public void setCostoCompra(BigDecimal costoCompra) {
		this.costoCompra = costoCompra;
	}
	public BigDecimal getCostoVenta() {
		return costoVenta;
	}
	public void setCostoVenta(BigDecimal costoVenta) {
		this.costoVenta = costoVenta;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
