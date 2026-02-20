package com.uisrael.clienteconsumo.model.dto.request;


import lombok.Data;
@Data
public class DiagnosticoRequestDTO {
   private int tecnicoId;
    private int estadoId;
    private String diagnostico;
    private String observaciones;
    private Integer creadoPor;
}
