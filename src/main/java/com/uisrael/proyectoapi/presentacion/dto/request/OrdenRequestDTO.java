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
	@NotBlank
	private int idCliente;
	@NotBlank
	private int idPrioridad;
	@NotBlank
	private int idEstado;
	@NotBlank
	private int tecnicoAsignado;
	@NotBlank
	private LocalDateTime fechaIngreso;
	@NotBlank
	private LocalDateTime fechaSalida;
	@NotBlank
	private String detalleProblema;
	@NotBlank
	private String observaciones;
	@NotBlank
	private BigDecimal totalCobro;
	@NotBlank
	private boolean pagado;
	@NotNull // Porque fecha no es texto, @NotNull para fechas
	private LocalDateTime creadoEn;
	
	private boolean estado;
	
}
