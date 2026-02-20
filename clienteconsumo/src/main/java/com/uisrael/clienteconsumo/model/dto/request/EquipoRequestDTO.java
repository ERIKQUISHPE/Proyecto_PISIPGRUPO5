package com.uisrael.clienteconsumo.model.dto.request;

import lombok.Data;

@Data
public class EquipoRequestDTO {

	private Integer idEquipo;
	private String tipo;
    private String marca;
    private String modelo;
    private String serial;
    private String estadoEquipo;
    private String observaciones;
    private OrdenRefRequestDTO fkOrden;
    private Integer idOrden;
	
}
