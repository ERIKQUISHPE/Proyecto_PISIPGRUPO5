package com.uisrael.proyectoapi.dominio.entidades;

import java.math.BigDecimal;

public final class OrdenMaterial {

    private final int idOrdenMaterial;
    private final int cantidad;
    private final BigDecimal costoUnitario;
    private final BigDecimal precioUnitario;
    private Orden fkOrden;
    private Material fkMaterial;
    
	public OrdenMaterial(int idOrdenMaterial, int cantidad, BigDecimal costoUnitario, BigDecimal precioUnitario,
			Orden fkOrden, Material fkMaterial) {
		super();
		this.idOrdenMaterial = idOrdenMaterial;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
		this.precioUnitario = precioUnitario;
		this.fkOrden = fkOrden;
		this.fkMaterial = fkMaterial;
	}

	public Orden getFkOrden() {
		return fkOrden;
	}

	public void setFkOrden(Orden fkOrden) {
		this.fkOrden = fkOrden;
	}

	public Material getFkMaterial() {
		return fkMaterial;
	}

	public void setFkMaterial(Material fkMaterial) {
		this.fkMaterial = fkMaterial;
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
				+ costoUnitario + ", precioUnitario=" + precioUnitario + ", fkOrden=" + fkOrden + ", fkMaterial="
				+ fkMaterial + "]";
	}
}
