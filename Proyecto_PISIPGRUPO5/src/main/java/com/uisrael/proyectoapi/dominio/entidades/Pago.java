package com.uisrael.proyectoapi.dominio.entidades;

import java.math.BigDecimal;	
import java.time.LocalDateTime;

public final class Pago {

    private final int idPago;
    private final BigDecimal monto;
    private final String metodoPago;
    private final LocalDateTime fechaPago;
    private final int registradoPor;
    private Orden fkOrden;
    
	public Pago(int idPago, BigDecimal monto, String metodoPago, LocalDateTime fechaPago, int registradoPor,
			Orden fkOrden) {
		super();
		this.idPago = idPago;
		this.monto = monto;
		this.metodoPago = metodoPago;
		this.fechaPago = fechaPago;
		this.registradoPor = registradoPor;
		this.fkOrden = fkOrden;
	}

	public Orden getFkOrden() {
		return fkOrden;
	}

	public void setFkOrden(Orden fkOrden) {
		this.fkOrden = fkOrden;
	}

	public int getIdPago() {
		return idPago;
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
		return "Pago [idPago=" + idPago + ", monto=" + monto + ", metodoPago=" + metodoPago + ", fechaPago=" + fechaPago
				+ ", registradoPor=" + registradoPor + ", fkOrden=" + fkOrden + "]";
	}
}
