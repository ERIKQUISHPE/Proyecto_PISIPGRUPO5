package com.uisrael.proyectoapi.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class Orden {
	
	private final int idOrden;
	private final String codigoOrden;
	private final LocalDateTime fechaIngreso;
	private final LocalDateTime fechaSalida;
	private final String detalleProblema;
	private final String observaciones;
	private final BigDecimal totalCobro;
	private final boolean pagado;
	private final LocalDateTime creadoEn;
	private final boolean estado; //true: activo - false: eliminado
	
	public Orden(int idOrden, String codigoOrden, LocalDateTime fechaIngreso, LocalDateTime fechaSalida,
			String detalleProblema, String observaciones, BigDecimal totalCobro, boolean pagado, LocalDateTime creadoEn,
			boolean estado) {
		this.idOrden = idOrden;
		this.codigoOrden = codigoOrden;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.detalleProblema = detalleProblema;
		this.observaciones = observaciones;
		this.totalCobro = totalCobro;
		this.pagado = pagado;
		this.creadoEn = creadoEn;
		this.estado = estado;
	}

	public int getIdOrden() {
		return idOrden;
	}

	public String getCodigoOrden() {
		return codigoOrden;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public String getDetalleProblema() {
		return detalleProblema;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public BigDecimal getTotalCobro() {
		return totalCobro;
	}

	public boolean isPagado() {
		return pagado;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public boolean isEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Orden [idOrden=" + idOrden + ", codigoOrden=" + codigoOrden + ", fechaIngreso=" + fechaIngreso
				+ ", fechaSalida=" + fechaSalida + ", detalleProblema=" + detalleProblema + ", observaciones="
				+ observaciones + ", totalCobro=" + totalCobro + ", pagado=" + pagado + ", creadoEn=" + creadoEn
				+ ", estado=" + estado + "]";
	}
}
