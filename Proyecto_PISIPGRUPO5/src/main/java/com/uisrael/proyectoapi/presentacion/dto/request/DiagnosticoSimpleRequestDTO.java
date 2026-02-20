package com.uisrael.proyectoapi.presentacion.dto.request;

import lombok.Data;

@Data
public class DiagnosticoSimpleRequestDTO {
    private String diagnostico;
    private String observaciones;
    private Integer creadoPor;
}
