package com.uisrael.proyectoapi.presentacion.dto.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrdenMaterialResponseDTO {
	private int idOrdenMaterial;
	private int idOrden;
	private int idMaterial;
	private int cantidad;
	private BigDecimal costoUnitario;
	private BigDecimal precioUnitario;

}
