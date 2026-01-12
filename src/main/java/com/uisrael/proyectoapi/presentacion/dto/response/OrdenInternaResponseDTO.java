package com.uisrael.proyectoapi.presentacion.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrdenInternaResponseDTO {
	private int idOrdenInterna;
	private int idOrdenes;
	private int tecnicoId;
	private int estadoId;
	private String diagnostico;
	private String observaciones;
	private int creadoPor;
	private LocalDateTime creadoEn;

}
