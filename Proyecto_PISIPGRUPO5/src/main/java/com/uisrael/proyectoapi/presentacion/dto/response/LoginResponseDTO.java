package com.uisrael.proyectoapi.presentacion.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private boolean ok;
    private Integer idUsuario;
    private String usuario;
    private String rol;
}
