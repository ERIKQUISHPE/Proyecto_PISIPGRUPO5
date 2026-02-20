package com.uisrael.proyectoapi.dominio.entidades;

import java.math.BigDecimal;

public final class AccionReparacionMaterial {

    private final int idAccionMaterial;
    private final int cantidad;
    private final BigDecimal costoCompra;
    private final BigDecimal costoVenta;

    private AccionReparacion fkAccion;
    private Material fkMaterial;

    public AccionReparacionMaterial(
            int idAccionMaterial,
            int cantidad,
            BigDecimal costoCompra,
            BigDecimal costoVenta,
            AccionReparacion fkAccion,
            Material fkMaterial) {

        this.idAccionMaterial = idAccionMaterial;
        this.cantidad = cantidad;
        this.costoCompra = costoCompra;
        this.costoVenta = costoVenta;
        this.fkAccion = fkAccion;
        this.fkMaterial = fkMaterial;
    }

    public int getIdAccionMaterial() { return idAccionMaterial; }
    public int getCantidad() { return cantidad; }
    public BigDecimal getCostoCompra() { return costoCompra; }
    public BigDecimal getCostoVenta() { return costoVenta; }

    public AccionReparacion getFkAccion() { return fkAccion; }
    public void setFkAccion(AccionReparacion fkAccion) { this.fkAccion = fkAccion; }

    public Material getFkMaterial() { return fkMaterial; }
    public void setFkMaterial(Material fkMaterial) { this.fkMaterial = fkMaterial; }
}
