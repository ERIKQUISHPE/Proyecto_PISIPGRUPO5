package com.uisrael.proyectoapi.presentacion.dto.response;

import java.time.LocalDateTime;	

public class EntregaResponseDTO {
	private  int idEntrega;
    private  int entregadoPor;
    private  int recibidoPor;
    private  LocalDateTime fechaEntrega;
    private  String notas;
    
	public int getIdEntrega() {
		return idEntrega;
	}
	public void setIdEntrega(int idEntrega) {
		this.idEntrega = idEntrega;
	}
	public int getEntregadoPor() {
		return entregadoPor;
	}
	public void setEntregadoPor(int entregadoPor) {
		this.entregadoPor = entregadoPor;
	}
	public int getRecibidoPor() {
		return recibidoPor;
	}
	public void setRecibidoPor(int recibidoPor) {
		this.recibidoPor = recibidoPor;
	}
	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
}
