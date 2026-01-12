package com.uisrael.proyectoapi.presentacion.dto.response;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class EntregaResponseDTO {
	private  int idEntrega;
    private  int idOrdenes;
    private  int entregadoPor;
    private  int recibidoPor;
    private  LocalDateTime fechaEntrega;
    private  String notas;


}
