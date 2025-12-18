package com.uisrael.proyectoapi.dominio.entidades;

import java.math.BigDecimal;

public final class OrdenMaterial {

    private final int idOrdenMaterial;
    private final int idOrden;
    private final int idMaterial;
    private final int cantidad;
    private final BigDecimal costoUnitario;
    private final BigDecimal precioUnitario;

    public OrdenMaterial(int idOrdenMaterial, int idOrden, int idMaterial, int cantidad,
                         BigDecimal costoUnitario, BigDecimal precioUnitario) {
        this.idOrdenMaterial = idOrdenMaterial;
        this.idOrden = idOrden;
        this.idMaterial = idMaterial;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.precioUnitario = precioUnitario;
    }

    public int getIdOrdenMaterial() {
        return idOrdenMaterial;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public int getIdMaterial() {
        return idMaterial;
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
        return "OrdenMaterial [idOrdenMaterial=" + idOrdenMaterial +
                ", idOrden=" + idOrden +
                ", idMaterial=" + idMaterial +
                ", cantidad=" + cantidad +
                ", costoUnitario=" + costoUnitario +
                ", precioUnitario=" + precioUnitario + "]";
    }
}
