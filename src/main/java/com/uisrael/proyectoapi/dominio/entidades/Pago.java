package com.uisrael.proyectoapi.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class Pago {

    private final int idPago;
    private final int idOrdenes;
    private final BigDecimal monto;
    private final String metodoPago;
    private final LocalDateTime fechaPago;
    private final int registradoPor;

    public Pago(
            int idPago,
            int idOrdenes,
            BigDecimal monto,
            String metodoPago,
            LocalDateTime fechaPago,
            int registradoPor
    ) {
        this.idPago = idPago;
        this.idOrdenes = idOrdenes;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = fechaPago;
        this.registradoPor = registradoPor;
    }

    public int getIdPago() {
        return idPago;
    }

    public int getIdOrdenes() {
        return idOrdenes;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public int getRegistradoPor() {
        return registradoPor;
    }

    @Override
    public String toString() {
        return "Pago [idPago=" + idPago +
                ", idOrdenes=" + idOrdenes +
                ", monto=" + monto +
                ", metodoPago=" + metodoPago +
                ", fechaPago=" + fechaPago +
                ", registradoPor=" + registradoPor + "]";
    }
}
