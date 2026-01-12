package com.uisrael.proyectoapi.presentacion.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AccionReparacionResponseDTO {
	private int idAccion;
	private int idOrdenes;
	private int tecnicoId;
	private String descripcion;
	private LocalDateTime fechaAccion;
}
