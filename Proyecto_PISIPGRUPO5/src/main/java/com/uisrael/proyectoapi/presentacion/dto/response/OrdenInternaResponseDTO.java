package com.uisrael.proyectoapi.presentacion.dto.response;

import java.time.LocalDateTime;	

public class OrdenInternaResponseDTO {
	private int idOrdenInterna;
	private int tecnicoId;
	private int estadoId;
	private String diagnostico;
	private String observaciones;
	private int creadoPor;
	private LocalDateTime creadoEn;
	private Integer idOrden;
	private String codigoOrden;
	private String textoOrden;
	private String tecnicoNombre;
	private String tecnicoApellido;


	
	public int getIdOrdenInterna() {
		return idOrdenInterna;
	}
	public void setIdOrdenInterna(int idOrdenInterna) {
		this.idOrdenInterna = idOrdenInterna;
	}
	public int getTecnicoId() {
		return tecnicoId;
	}
	public void setTecnicoId(int tecnicoId) {
		this.tecnicoId = tecnicoId;
	}
	public int getEstadoId() {
		return estadoId;
	}
	public void setEstadoId(int estadoId) {
		this.estadoId = estadoId;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public int getCreadoPor() {
		return creadoPor;
	}
	public void setCreadoPor(int creadoPor) {
		this.creadoPor = creadoPor;
	}
	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}
	public Integer getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}
	public String getCodigoOrden() {
		return codigoOrden;
	}
	public void setCodigoOrden(String codigoOrden) {
		this.codigoOrden = codigoOrden;
	}
	public String getTextoOrden() {
		return textoOrden;
	}
	public void setTextoOrden(String textoOrden) {
		this.textoOrden = textoOrden;
	}
	public String getTecnicoNombre() {
		return tecnicoNombre;
	}
	public void setTecnicoNombre(String tecnicoNombre) {
		this.tecnicoNombre = tecnicoNombre;
	}
	public String getTecnicoApellido() {
		return tecnicoApellido;
	}
	public void setTecnicoApellido(String tecnicoApellido) {
		this.tecnicoApellido = tecnicoApellido;
	}
	
	
	
}
