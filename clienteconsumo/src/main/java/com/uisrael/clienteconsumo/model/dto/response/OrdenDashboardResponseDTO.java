package com.uisrael.clienteconsumo.model.dto.response;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdenDashboardResponseDTO {
  private int idOrden;
  private LocalDateTime fechaIngreso;
  private int idEstado;
  private String nombreEstado;
  private boolean estado;
  private boolean pagado;
}