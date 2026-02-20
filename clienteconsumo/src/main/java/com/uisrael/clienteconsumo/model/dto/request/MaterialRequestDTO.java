
package com.uisrael.clienteconsumo.model.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MaterialRequestDTO {

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
