package com.uisrael.proyectoapi.presentacion.dto.response;

import java.math.BigDecimal;	
import java.time.LocalDateTime;

public class PagoResponseDTO {
	private  int idPago;
    private  BigDecimal monto;
    private  String metodoPago;
    private  LocalDateTime fechaPago;
    private  int registradoPor;
    
	public int getIdPago() {
		return idPago;
	}
	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public LocalDateTime getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}
	public int getRegistradoPor() {
		return registradoPor;
	}
	public void setRegistradoPor(int registradoPor) {
		this.registradoPor = registradoPor;
	}
}
