package com.uisrael.clienteconsumo.model.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EntregaResponseDTO {

    private int idEntrega;
    private UsuarioResponseDTO entregadoPor;
    private String recibidoPor;
    private OrdenResponseDTO fkOrden;
    private LocalDateTime fechaEntrega;
    private String notas;

}
