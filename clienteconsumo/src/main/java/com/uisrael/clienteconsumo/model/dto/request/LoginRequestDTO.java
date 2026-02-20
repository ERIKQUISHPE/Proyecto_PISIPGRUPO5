package com.uisrael.clienteconsumo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequestDTO {
	  private String usuario;
	  private String password;

}
