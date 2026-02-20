package com.uisrael.clienteconsumo.model.dto.response;

import lombok.Data;

@Data
public class LoginResponseDTO {
	
	  private boolean ok;
	  private Integer idUsuario;
	  private String usuario;
	  private String rol;

}
