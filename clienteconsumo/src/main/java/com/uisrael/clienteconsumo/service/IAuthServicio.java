package com.uisrael.clienteconsumo.service;

import com.uisrael.clienteconsumo.model.dto.response.LoginResponseDTO;

public interface IAuthServicio {
	LoginResponseDTO login(String usuario, String password);
}
