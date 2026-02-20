package com.uisrael.clienteconsumo.model.dto.response;

import lombok.Data;

@Data
public class OrdenInternaResponseDTO {
  private int idOrdenInterna;
  private Integer tecnicoId;
  private Integer estadoId;

  private String diagnostico;
  private String observaciones;
  private Integer idOrden;
  private String codigoOrden;
  private String textoOrden; 
  
  private String tecnicoNombre;
  private String tecnicoApellido;
}
