package com.uisrael.proyectoapi.presentacion.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class OrdenMaterialRequestDTO {
	//private final int idOrdenMaterial;
	@NotBlank
    private  int idOrden;
	@NotBlank
    private  int idMaterial;
	@NotBlank
    private  int cantidad;
	@NotBlank
    private  BigDecimal costoUnitario;
	@NotBlank
    private  BigDecimal precioUnitario;

}
