package com.uisrael.proyectoapi.dominio.entidades;

import java.time.LocalDateTime;

public final class AccionReparacion {

    private final int idAccion;
    private final int tecnicoId;
    private final String descripcion;
    private final LocalDateTime fechaAccion;
    
	public AccionReparacion(int idAccion, int tecnicoId, String descripcion, LocalDateTime fechaAccion) {
		this.idAccion = idAccion;
		this.tecnicoId = tecnicoId;
		this.descripcion = descripcion;
		this.fechaAccion = fechaAccion;
	}

	public int getIdAccion() {
		return idAccion;
	}

	public int getTecnicoId() {
		return tecnicoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public LocalDateTime getFechaAccion() {
		return fechaAccion;
	}

	@Override
	public String toString() {
		return "AccionReparacion [idAccion=" + idAccion + ", tecnicoId=" + tecnicoId + ", descripcion=" + descripcion
				+ ", fechaAccion=" + fechaAccion + "]";
	}
}
