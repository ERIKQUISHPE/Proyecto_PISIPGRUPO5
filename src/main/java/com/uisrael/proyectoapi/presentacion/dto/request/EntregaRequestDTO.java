package com.uisrael.proyectoapi.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EntregaRequestDTO {
	//private int idEntrega;
	@NotNull
	private int entregadoPor;
	@NotNull
	private int recibidoPor;
	
	private LocalDateTime fechaEntrega;
	@NotBlank
	private String notas;
}
