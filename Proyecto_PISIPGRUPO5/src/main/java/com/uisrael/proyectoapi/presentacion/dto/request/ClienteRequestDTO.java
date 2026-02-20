package com.uisrael.proyectoapi.presentacion.dto.request;

import java.time.LocalDateTime;	

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteRequestDTO {
	
	private int idCliente; 
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	private String ci;
	@NotBlank
	private String telefono;
	@NotBlank
	private String correo;
	@NotBlank
	private String direccion;
	
	private LocalDateTime creadoEn;
	
}
