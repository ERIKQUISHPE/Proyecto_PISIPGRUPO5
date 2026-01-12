package com.uisrael.proyectoapi.presentacion.dto.response;

import lombok.Data;

@Data
public class AccesorioResponseDTO {
	private  int idAccesorio;
    private  int idEquipo;
    private  String descripcion;
    private  boolean incluido;
}
