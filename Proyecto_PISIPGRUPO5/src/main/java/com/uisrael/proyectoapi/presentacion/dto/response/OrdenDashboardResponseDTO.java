package com.uisrael.proyectoapi.presentacion.dto.response;

import java.time.LocalDateTime;

public class OrdenDashboardResponseDTO {

  private int idOrden;
  private LocalDateTime fechaIngreso;
  private boolean estado;

  private int idEstado;
  private String nombreEstado;

  public int getIdOrden() { return idOrden; }
  public void setIdOrden(int idOrden) { this.idOrden = idOrden; }

  public LocalDateTime getFechaIngreso() { return fechaIngreso; }
  public void setFechaIngreso(LocalDateTime fechaIngreso) { this.fechaIngreso = fechaIngreso; }

  public boolean isEstado() { return estado; }
  public void setEstado(boolean estado) { this.estado = estado; }

  public int getIdEstado() { return idEstado; }
  public void setIdEstado(int idEstado) { this.idEstado = idEstado; }

  public String getNombreEstado() { return nombreEstado; }
  public void setNombreEstado(String nombreEstado) { this.nombreEstado = nombreEstado; }
}
