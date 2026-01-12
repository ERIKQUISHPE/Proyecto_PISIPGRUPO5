package com.uisrael.proyectoapi.presentacion.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
@Data
public class PagoResponseDTO {
	private  int idPago;
    private  int idOrdenes;
    private  BigDecimal monto;
    private  String metodoPago;
    private  LocalDateTime fechaPago;
    private  int registradoPor;

}
