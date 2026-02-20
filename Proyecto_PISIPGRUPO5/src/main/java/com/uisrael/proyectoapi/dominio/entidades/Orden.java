package com.uisrael.proyectoapi.dominio.entidades;

import java.math.BigDecimal;	
import java.time.LocalDateTime;

public final class Orden {
	
	private final int idOrden;
	private final LocalDateTime fechaIngreso;
	private final LocalDateTime fechaSalida;
	private final String detalleProblema;
	private final String observaciones;
	private final BigDecimal totalCobro;
	private final boolean pagado;
	private final String estadoOrden;
	private Cliente fkCliente;
	private Usuario fkUsuario;
	
	public Orden(int idOrden, LocalDateTime fechaIngreso, LocalDateTime fechaSalida, String detalleProblema,
			String observaciones, BigDecimal totalCobro, boolean pagado, String estadoOrden,
			Cliente fkCliente, Usuario fkUsuario) {
		this.idOrden = idOrden;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.detalleProblema = detalleProblema;
		this.observaciones = observaciones;
		this.totalCobro = totalCobro;
		this.pagado = pagado;
		this.estadoOrden = estadoOrden;
		this.fkCliente = fkCliente;
		this.fkUsuario = fkUsuario;
	}

	public Cliente getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(Cliente fkCliente) {
		this.fkCliente = fkCliente;
	}

	public Usuario getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(Usuario fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public int getIdOrden() {
		return idOrden;
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

	public String getEstadoOrden() {
		return estadoOrden;
	}

	@Override
	public String toString() {
		return "Orden [idOrden=" + idOrden + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida
				+ ", detalleProblema=" + detalleProblema + ", observaciones=" + observaciones + ", totalCobro="
				+ totalCobro + ", pagado=" + pagado + ", estadoOrden=" + estadoOrden
				+ ", fkCliente=" + fkCliente + ", fkUsuario=" + fkUsuario + "]";
	}
}
