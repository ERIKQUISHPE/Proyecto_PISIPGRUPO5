package com.uisrael.proyectoapi.presentacion.dto.response;

import java.time.LocalDateTime;	

public class EntregaResponseDTO {
	  private int idEntrega;
	  private LocalDateTime fechaEntrega;
	  private String notas;
	  private UsuarioResponseDTO entregadoPor;
	  private String recibidoPor;
	  private OrdenResponseDTO fkOrden;
	  public int getIdEntrega() {
		  return idEntrega;
	  }
	  public void setIdEntrega(int idEntrega) {
		  this.idEntrega = idEntrega;
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
	  public UsuarioResponseDTO getEntregadoPor() {
		  return entregadoPor;
	  }
	  public void setEntregadoPor(UsuarioResponseDTO entregadoPor) {
		  this.entregadoPor = entregadoPor;
	  }
	 
	  public String getRecibidoPor() {
		return recibidoPor;
	}
	  public void setRecibidoPor(String recibidoPor) {
		  this.recibidoPor = recibidoPor;
	  }
	  public OrdenResponseDTO getFkOrden() {
		  return fkOrden;
	  }
	  public void setFkOrden(OrdenResponseDTO fkOrden) {
		  this.fkOrden = fkOrden;
	  }
    
}
