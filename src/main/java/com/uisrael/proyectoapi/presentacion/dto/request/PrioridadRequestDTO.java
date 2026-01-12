package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PrioridadRequestDTO {
	//private final int idPrioridad;
	@NotBlank
	private  String nombre;

}
