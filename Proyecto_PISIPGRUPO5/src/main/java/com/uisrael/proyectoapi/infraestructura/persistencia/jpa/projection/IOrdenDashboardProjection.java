package com.uisrael.proyectoapi.infraestructura.persistencia.jpa.projection;

import java.time.LocalDateTime;

public interface IOrdenDashboardProjection {
  Integer getIdOrden();
  LocalDateTime getFechaIngreso();
  Integer getIdEstado();
  String getNombreEstado();
  Boolean getEstado();
}
