package com.uisrael.proyectoapi.presentacion.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrdenRequestDTO {
  private int idOrden;
  @NotBlank
  private String codigoOrden;

  @NotBlank
  private String detalleProblema;

  @NotBlank
  private String observaciones;

  @NotBlank
  private String estadoOrden;

  @NotNull
  private Boolean pagado;

  @NotNull
  private BigDecimal totalCobro;

  @NotNull
  private Integer idCliente;

  @NotNull
  private Integer idUsuario;
}
