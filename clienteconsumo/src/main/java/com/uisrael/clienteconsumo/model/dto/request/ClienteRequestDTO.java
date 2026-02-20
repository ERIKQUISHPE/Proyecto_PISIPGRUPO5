package com.uisrael.clienteconsumo.model.dto.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ClienteRequestDTO {

	private int idCliente;
	private String nombre;
	private String apellido;
	private String ci;
	private String telefono;
	private String correo;
	private String direccion;
	private LocalDateTime creadoEn;
}
