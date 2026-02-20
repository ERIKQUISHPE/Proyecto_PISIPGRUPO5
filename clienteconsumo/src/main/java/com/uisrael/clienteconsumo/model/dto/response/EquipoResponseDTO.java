package com.uisrael.clienteconsumo.model.dto.response;

import lombok.Data;

@Data
public class EquipoResponseDTO {

	private int idEquipo;
    private String tipo;
    private String marca;
    private String modelo;
    private String serial;
    private String estadoEquipo;
    private String observaciones;
    private OrdenRefResponseDTO fkOrden;
    private Integer idOrden;
	
}
