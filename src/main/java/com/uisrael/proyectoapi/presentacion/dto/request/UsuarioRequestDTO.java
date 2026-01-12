package com.uisrael.proyectoapi.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class UsuarioRequestDTO {
	//private final int idUsuario;
	@NotBlank
	private  String Usuario;
	@NotBlank
	private  String nombre;
	@NotBlank
	private  String apellido;
	@NotBlank
	private  String rol;
	@NotBlank
	private  String telefono;
	@NotBlank
	private  String correo;
	@NotBlank
	private  LocalDateTime creadoEn;
	
	private  boolean estado; 

}
