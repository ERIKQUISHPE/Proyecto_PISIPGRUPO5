package com.uisrael.proyectoapi.presentacion.dto.response;

import lombok.Data;

@Data
public class EquipoResponseDTO {
	private  int idEquipo;
    private  int idOrdenes;
    private  String tipo;
    private  String marca;
    private  String modelo;
    private  String serial;
    private  String estadoEquipo;
    private  String observaciones;

}
