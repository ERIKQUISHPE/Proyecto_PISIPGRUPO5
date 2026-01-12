package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EstadoOrdenRequestDTO {
	//private  int idEstado;
	@NotBlank
    private  String nombre;

}
