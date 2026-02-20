package com.uisrael.proyectoapi.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class OrdenInternaRequestDTO {
	
	private final int idOrdenInterna;
	@NotNull
    private  int tecnicoId;
	@NotNull
    private  int estadoId;
	
    private  String diagnostico;
	
    private  String observaciones;
	@NotNull
    private  int creadoPor;
	
    private  LocalDateTime creadoEn;

}
