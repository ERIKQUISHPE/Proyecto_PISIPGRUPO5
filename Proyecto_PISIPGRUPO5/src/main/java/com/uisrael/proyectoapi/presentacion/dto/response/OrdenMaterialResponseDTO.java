package com.uisrael.proyectoapi.presentacion.dto.response;

import java.math.BigDecimal;	

public class OrdenMaterialResponseDTO {
	private int idOrdenMaterial;
	private int cantidad;
	private BigDecimal costoUnitario;
	private BigDecimal precioUnitario;
	
	public int getIdOrdenMaterial() {
		return idOrdenMaterial;
	}
	public void setIdOrdenMaterial(int idOrdenMaterial) {
		this.idOrdenMaterial = idOrdenMaterial;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(BigDecimal costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
}
