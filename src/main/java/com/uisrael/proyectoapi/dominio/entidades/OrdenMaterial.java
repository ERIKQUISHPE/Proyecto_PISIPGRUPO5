package com.uisrael.proyectoapi.dominio.entidades;

import java.math.BigDecimal;

public final class OrdenMaterial {

    private final int idOrdenMaterial;
    private final int cantidad;
    private final BigDecimal costoUnitario;
    private final BigDecimal precioUnitario;
    
	public OrdenMaterial(int idOrdenMaterial, int cantidad, BigDecimal costoUnitario, BigDecimal precioUnitario) {
		this.idOrdenMaterial = idOrdenMaterial;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
		this.precioUnitario = precioUnitario;
	}

	public int getIdOrdenMaterial() {
		return idOrdenMaterial;
	}

	public int getCantidad() {
		return cantidad;
	}

	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	@Override
	public String toString() {
		return "OrdenMaterial [idOrdenMaterial=" + idOrdenMaterial + ", cantidad=" + cantidad + ", costoUnitario="
				+ costoUnitario + ", precioUnitario=" + precioUnitario + "]";
	}   
}
