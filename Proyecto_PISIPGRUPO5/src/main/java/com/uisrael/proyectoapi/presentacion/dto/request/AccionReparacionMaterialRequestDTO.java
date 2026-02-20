package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccionReparacionMaterialRequestDTO {

    @NotNull
    private Integer idAccion;

    @NotNull
    private Integer idMaterial;

    @NotNull
    private Integer cantidad;
}
