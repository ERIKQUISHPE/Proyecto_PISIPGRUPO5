package com.uisrael.proyectoapi.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class Orden {
	
	private final int idOrden;
	private final String codigoOrden;
	private final int idCliente;
	private final int idPrioridad;
	private final int idEstado;
	private final int tecnicoAsignado;
	private final LocalDateTime fechaIngreso;
	private final LocalDateTime fechaSalida;
	private final String detalleProblema;
	private final String observaciones;
	private final BigDecimal totalCobro;
	private final boolean pagado;
	private final LocalDateTime creadoEn;
	private final boolean estado; //true: activo - false: eliminado
	
	public Orden(int idOrden, String codigoOrden, int idCliente, int idPrioridad, int idEstado, int tecnicoAsignado,
			LocalDateTime fechaIngreso, LocalDateTime fechaSalida, String detalleProblema, String observaciones,
			BigDecimal totalCobro, boolean pagado, LocalDateTime creadoEn, boolean estado) {
		this.idOrden = idOrden;
		this.codigoOrden = codigoOrden;
		this.idCliente = idCliente;
		this.idPrioridad = idPrioridad;
		this.idEstado = idEstado;
		this.tecnicoAsignado = tecnicoAsignado;
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

	public int getIdCliente() {
		return idCliente;
	}

	public int getIdPrioridad() {
		return idPrioridad;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public int getTecnicoAsignado() {
		return tecnicoAsignado;
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
		return " [idOrden=" + idOrden + ", codigoOrden=" + codigoOrden + ", idCliente=" + idCliente
				+ ", idPrioridad=" + idPrioridad + ", idEstado=" + idEstado + ", tecnicoAsignado=" + tecnicoAsignado
				+ ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", detalleProblema="
				+ detalleProblema + ", observaciones=" + observaciones + ", totalCobro=" + totalCobro + ", pagado="
				+ pagado + ", creadoEn=" + creadoEn + ", estado=" + estado + "]";
	}
}
