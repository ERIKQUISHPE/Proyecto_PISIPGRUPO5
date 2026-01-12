package com.uisrael.proyectoapi.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccionReparacionRequestDTO {
	//private int idAccion;
	@NotBlank
	private int idOrdenes;
	@NotBlank
	private int tecnicoId;
	@NotBlank
	private String descripcion;
	@NotBlank
	private LocalDateTime fechaAccion;

}
