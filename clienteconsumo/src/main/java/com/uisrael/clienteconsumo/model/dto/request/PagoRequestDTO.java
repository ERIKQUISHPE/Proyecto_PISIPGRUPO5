package com.uisrael.clienteconsumo.model.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PagoRequestDTO {

	private Integer idPago;
	private Integer idOrden;
    private BigDecimal monto;
    private String metodoPago;
    private LocalDateTime fechaPago;
    private Integer registradoPor;
	
}
