package com.uisrael.proyectoapi.presentacion.dto.response;

import java.time.LocalDateTime;

public class AccionReparacionResponseDTO {
	private int idAccion;
	private int tecnicoId;
	private String descripcion;
	private LocalDateTime fechaAccion;
	public int getIdAccion() {
		return idAccion;
	}
	public void setIdAccion(int idAccion) {
		this.idAccion = idAccion;
	}
	public int getTecnicoId() {
		return tecnicoId;
	}
	public void setTecnicoId(int tecnicoId) {
		this.tecnicoId = tecnicoId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDateTime getFechaAccion() {
		return fechaAccion;
	}
	public void setFechaAccion(LocalDateTime fechaAccion) {
		this.fechaAccion = fechaAccion;
	}	
}
