package com.uisrael.proyectoapi.presentacion.dto.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MaterialResponseDTO {
	private int idMaterial;
	private String codigoMaterial;
	private String nombre;
	private String descripcion;
	private BigDecimal costoCompra;
	private BigDecimal costoVenta;
	private int idProveedor;
	private Integer stock;
	private boolean estado;

}
