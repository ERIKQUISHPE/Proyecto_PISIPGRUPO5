package com.uisrael.proyectoapi.presentacion.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProveedorResponseDTO {
	private int idProveedor;
	private String Proveedor;
	private String nombreContacto;
	private String apellidoContacto;
	private String telefono;
	private String correo;
	private String notas;
	private LocalDateTime creadoEn;
	private boolean estado;
}
