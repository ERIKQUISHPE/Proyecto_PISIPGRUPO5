package com.uisrael.proyectoapi.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class OrdenInternaRequestDTO {
	//private final int idOrdenInterna;
	@NotBlank
    private  int tecnicoId;
	@NotBlank
    private  int estadoId;
	@NotBlank
    private  String diagnostico;
	@NotBlank
    private  String observaciones;
	@NotBlank
    private  int creadoPor;
	
    private  LocalDateTime creadoEn;

}
