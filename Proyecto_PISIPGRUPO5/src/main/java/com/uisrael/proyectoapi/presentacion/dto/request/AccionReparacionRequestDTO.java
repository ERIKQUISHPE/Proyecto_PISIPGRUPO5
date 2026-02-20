package com.uisrael.proyectoapi.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccionReparacionRequestDTO {

    private int idAccion;

    @NotNull
    private Integer idOrden; 

    @NotNull
    private int tecnicoId;

    @NotBlank
    private String descripcion;

    private LocalDateTime fechaAccion;
}
