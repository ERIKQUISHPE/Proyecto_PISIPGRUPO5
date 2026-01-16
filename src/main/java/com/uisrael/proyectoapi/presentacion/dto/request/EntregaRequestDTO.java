package com.uisrael.proyectoapi.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public class EntregaRequestDTO {
	//private int idEntrega;
	@NotBlank
	private int entregadoPor;
	@NotBlank
	private int recibidoPor;
	@NotBlank
	private LocalDateTime fechaEntrega;
	@NotBlank
	private String notas;
}
