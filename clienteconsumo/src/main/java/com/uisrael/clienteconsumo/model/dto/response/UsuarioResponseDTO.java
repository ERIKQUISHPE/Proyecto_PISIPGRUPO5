package com.uisrael.clienteconsumo.model.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsuarioResponseDTO {

	private Integer idUsuario;
    private String usuario;
    private String nombre;
    private String apellido;
    private String rol;
    private String telefono;
    private String correo;
    private LocalDateTime creadoEn;
    private boolean estado;
    private String password;
	
}
