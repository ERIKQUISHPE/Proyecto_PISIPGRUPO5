package com.uisrael.proyectoapi.presentacion.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class MaterialRequestDTO {
	//private final int idMaterial;
	@NotBlank
	private  String codigoMaterial;
	@NotBlank
	private  String nombre;
	@NotBlank
	private  String descripcion;
	@NotBlank
	private  BigDecimal costoCompra;
	@NotBlank
	private  BigDecimal costoVenta;
	@NotBlank
	private  Integer stock; 
	
	private  boolean estado; 

}
