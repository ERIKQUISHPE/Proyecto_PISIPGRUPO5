package com.uisrael.proyectoapi.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class ProveedorRequestDTO {
	//private final int idProveedor;
	@NotBlank
	private  String Proveedor; 
	@NotBlank
	private  String nombreContacto;
	@NotBlank
	private  String apellidoContacto;
	@NotBlank
	private  String telefono;
	@NotBlank
	private  String correo;
	@NotBlank
	private  String notas;
	@NotBlank
	private  LocalDateTime creadoEn;
	
	private  boolean estado; 
}
