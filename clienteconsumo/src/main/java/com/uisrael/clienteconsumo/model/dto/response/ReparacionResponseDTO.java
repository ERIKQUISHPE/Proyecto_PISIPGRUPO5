package com.uisrael.clienteconsumo.model.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReparacionResponseDTO {

    private int idAccion;
    private int tecnicoId;
    private String descripcion;
    private LocalDateTime fechaAccion;
    private String accionRealizada;
    private Integer idOrden;
    private String textoOrden;
    private String tecnicoNombre;
    private String tecnicoApellido;
    private String estadoOrden;
    private Integer idMaterial;
    private String materialNombre;
}
