package com.uisrael.clienteconsumo.model.dto.request;

import lombok.Data;

@Data
public class EntregaRequestDTO {
	private int idEntrega;
    private UsuarioRequestDTO entregadoPor;
    private String recibidoPor;
    private OrdenRequestDTO fkOrden;
    private String notas;

}
