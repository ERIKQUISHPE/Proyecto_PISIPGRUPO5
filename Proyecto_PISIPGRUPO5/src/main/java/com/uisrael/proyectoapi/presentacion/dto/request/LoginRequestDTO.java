package com.uisrael.proyectoapi.presentacion.dto.request;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String usuario;
    private String password;
}
