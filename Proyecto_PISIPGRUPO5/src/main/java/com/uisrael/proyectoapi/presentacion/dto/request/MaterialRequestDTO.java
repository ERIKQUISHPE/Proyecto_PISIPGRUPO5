package com.uisrael.proyectoapi.presentacion.dto.request;

import java.math.BigDecimal;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
@Data
public class MaterialRequestDTO {
	
	private int idMaterial;
	@NotBlank
	private  String codigoMaterial;
	@NotBlank
	private  String nombre;
	@NotBlank
	private  String descripcion;
	@NotNull
	private  BigDecimal costoCompra;
	@NotNull
	private  BigDecimal costoVenta;
	@PositiveOrZero
	private  Integer stock; 
	
	private  boolean estado; 
	@NotNull
	private ProveedorRequestDTO fkProveedor;

}
