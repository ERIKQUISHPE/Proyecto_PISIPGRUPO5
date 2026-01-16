package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EquipoRequestDTO {
	//private final int idEquipo;
	@NotBlank
    private  String tipo;
	@NotBlank
    private  String marca;
	@NotBlank
    private  String modelo;
	@NotBlank
    private  String serial;
	@NotBlank
    private  String estadoEquipo;
	@NotBlank
    private  String observaciones;

}
