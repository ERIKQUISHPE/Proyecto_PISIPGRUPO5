package com.uisrael.clienteconsumo.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PagoResponseDTO {

	private int idPago;
    private BigDecimal monto;
    private String metodoPago;
    private LocalDateTime fechaPago;
    private int registradoPor;
    private Integer idOrden;
    private String codigoOrden;
    private String textoOrden;
	
}
