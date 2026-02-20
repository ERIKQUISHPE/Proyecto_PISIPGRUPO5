package com.uisrael.proyectoapi.presentacion.dto.response;

import java.math.BigDecimal;	
import java.time.LocalDateTime;

public class OrdenResponseDTO {

	private int idOrden;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private String detalleProblema;
	private String observaciones;
	private BigDecimal totalCobro;
	private boolean pagado;
	private String estadoOrden;
	private ClienteResponseDTO fkCliente;
	private UsuarioResponseDTO fkUsuario;
	public int getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}
	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getDetalleProblema() {
		return detalleProblema;
	}
	public void setDetalleProblema(String detalleProblema) {
		this.detalleProblema = detalleProblema;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public BigDecimal getTotalCobro() {
		return totalCobro;
	}
	public void setTotalCobro(BigDecimal totalCobro) {
		this.totalCobro = totalCobro;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public String getEstadoOrden() {
		return estadoOrden;
	}
	public void setEstadoOrden(String estadoOrden) {
		this.estadoOrden = estadoOrden;
	}
	public ClienteResponseDTO getFkCliente() {
		return fkCliente;
	}
	public void setFkCliente(ClienteResponseDTO fkCliente) {
		this.fkCliente = fkCliente;
	}
	public UsuarioResponseDTO getFkUsuario() {
		return fkUsuario;
	}
	public void setFkUsuario(UsuarioResponseDTO fkUsuario) {
		this.fkUsuario = fkUsuario;
	}
}
