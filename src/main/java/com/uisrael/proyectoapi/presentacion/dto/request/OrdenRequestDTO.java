package com.uisrael.proyectoapi.presentacion.dto.request;

import java.math.BigDecimal;	
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
	
@Data
public class OrdenRequestDTO {

	// private int idOrdenes; porque trabaja en FJPA
	@NotBlank
	private String codigoOrden;
	
	private LocalDateTime fechaIngreso;
	
	private LocalDateTime fechaSalida;
	@NotBlank
	private String detalleProblema;
	@NotBlank
	private String observaciones;
	@NotNull
	private BigDecimal totalCobro;

	private boolean pagado;
	
	private LocalDateTime creadoEn;
	
	private boolean estado;
	
}
