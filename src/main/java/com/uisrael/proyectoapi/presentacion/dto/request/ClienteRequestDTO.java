package com.uisrael.proyectoapi.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClienteRequestDTO {
	
	//private int idCliente; porque trabaja en FJPA
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
	//@NotNull // Porque fecha no es texto, @NotNull para fechas
	//private LocalDateTime creadoEn;

	private boolean estado;
	
}
