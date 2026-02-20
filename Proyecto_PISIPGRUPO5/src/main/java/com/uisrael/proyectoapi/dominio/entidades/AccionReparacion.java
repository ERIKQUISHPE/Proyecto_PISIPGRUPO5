package com.uisrael.proyectoapi.dominio.entidades;

import java.time.LocalDateTime;

public final class AccionReparacion {

    private final int idAccion;
    private final int tecnicoId;
    private final String descripcion;
    private final LocalDateTime fechaAccion;
    private Orden fkOrden;
    
	public AccionReparacion(int idAccion, int tecnicoId, String descripcion, LocalDateTime fechaAccion, Orden fkOrden) {
		super();
		this.idAccion = idAccion;
		this.tecnicoId = tecnicoId;
		this.descripcion = descripcion;
		this.fechaAccion = fechaAccion;
		this.fkOrden = fkOrden;
	}

	public Orden getFkOrden() {
		return fkOrden;
	}

	public void setFkOrden(Orden fkOrden) {
		this.fkOrden = fkOrden;
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
				+ ", fechaAccion=" + fechaAccion + ", fkOrden=" + fkOrden + "]";
	}
}
