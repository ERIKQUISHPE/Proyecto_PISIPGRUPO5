package com.uisrael.clienteconsumo.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrdenResponseDTO {

  private int idOrden;
  private String codigoOrden; 
  private LocalDateTime fechaIngreso;
  private LocalDateTime fechaSalida;
  private String detalleProblema;
  private String observaciones;
  private BigDecimal totalCobro;
  private boolean pagado;
  private String estadoOrden;
  private boolean tieneEquipo;

  private ClienteResponseDTO fkCliente;   
  private UsuarioResponseDTO fkUsuario;   
  private BigDecimal montoPago;
}
