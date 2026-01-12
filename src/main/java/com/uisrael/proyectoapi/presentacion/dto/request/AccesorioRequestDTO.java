package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccesorioRequestDTO {

    //private  int idAccesorio;
    @NotBlank
    private  int idEquipo;
    @NotBlank
    private  String descripcion;
    
    private  boolean incluido;

}
