package com.uisrael.proyectoapi.dominio.entidades;

import java.time.LocalDateTime;

public final class Entrega {

    private final int idEntrega;
    private Usuario entregadoPor;
    private String recibidoPor;
    private final LocalDateTime fechaEntrega;
    private final String notas;
    private Orden fkOrden;

	public Entrega(int idEntrega, Usuario entregadoPor, String recibidoPor, LocalDateTime fechaEntrega, String notas,
			Orden fkOrden) {
		this.idEntrega = idEntrega;
		this.entregadoPor = entregadoPor;
		this.recibidoPor = recibidoPor;
		this.fechaEntrega = fechaEntrega;
		this.notas = notas;
		this.fkOrden = fkOrden;
	}

	public Usuario getEntregadoPor() {
		return entregadoPor;
	}

	public void setEntregadoPor(Usuario entregadoPor) {
		this.entregadoPor = entregadoPor;
	}

	public String getRecibidoPor() {
		return recibidoPor;
	}

	public void setRecibidoPor(String recibidoPor) {
		this.recibidoPor = recibidoPor;
	}

	public Orden getFkOrden() {
		return fkOrden;
	}

	public void setFkOrden(Orden fkOrden) {
		this.fkOrden = fkOrden;
	}

	public int getIdEntrega() {
		return idEntrega;
	}

	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;
	}

	public String getNotas() {
		return notas;
	}

	@Override
	public String toString() {
		return "Entrega [idEntrega=" + idEntrega + ", entregadoPor=" + entregadoPor + ", recibidoPor=" + recibidoPor
				+ ", fechaEntrega=" + fechaEntrega + ", notas=" + notas + ", fkOrden=" + fkOrden + "]";
	}
}
