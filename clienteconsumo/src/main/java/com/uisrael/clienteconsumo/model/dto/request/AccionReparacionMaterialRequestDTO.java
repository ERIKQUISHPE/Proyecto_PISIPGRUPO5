package com.uisrael.clienteconsumo.model.dto.request;

import lombok.Data;

@Data
public class AccionReparacionMaterialRequestDTO {

    private Integer idAccion;
    private Integer idMaterial;
    private Integer cantidad;
}
