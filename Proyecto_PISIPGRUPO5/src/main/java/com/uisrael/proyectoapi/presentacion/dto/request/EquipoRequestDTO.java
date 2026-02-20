package com.uisrael.proyectoapi.presentacion.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EquipoRequestDTO {
	
	private Integer idEquipo;
	@NotBlank
    private  String tipo;
	@NotBlank
    private  String marca;
	@NotBlank
    private  String modelo;
	@NotBlank
    private  String serial;
	
	@NotNull
	private Integer fkOrden;
	
	@NotBlank
    private  String estadoEquipo;
	@NotBlank
    private  String observaciones;
	

}
