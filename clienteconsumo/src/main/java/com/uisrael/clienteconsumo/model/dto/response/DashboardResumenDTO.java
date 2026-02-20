package com.uisrael.clienteconsumo.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResumenDTO {
  private long pendientes;
  private long diagnostico;
  private long reparacion;
  private long listoEntrega;
  private long entregadas;
}
