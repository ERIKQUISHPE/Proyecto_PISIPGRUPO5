package com.uisrael.clienteconsumo.model.dto.response;

import java.math.BigDecimal;

import com.uisrael.clienteconsumo.model.dto.request.ProveedorRequestDTO;

import lombok.Data;

@Data
public class MaterialResponseDTO {

	private int idMaterial;
	private String codigoMaterial;
	private String nombre;
	private String descripcion;
	private BigDecimal costoCompra;
	private BigDecimal costoVenta;
	private Integer stock; 
	private boolean estado;
	private ProveedorRequestDTO fkProveedor;
	
}
