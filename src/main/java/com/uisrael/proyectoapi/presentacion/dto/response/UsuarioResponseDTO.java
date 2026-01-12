package com.uisrael.proyectoapi.presentacion.dto.response;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class UsuarioResponseDTO {
	private  int idUsuario;
	private  String Usuario;
	private  String nombre;
	private  String apellido;
	private  String rol;
	private  String telefono;
	private  String correo;
	private  LocalDateTime creadoEn;
	private  boolean estado; 

}
