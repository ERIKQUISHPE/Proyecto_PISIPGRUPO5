package com.uisrael.clienteconsumo.model.dto.request;

import java.math.BigDecimal;	
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrdenRequestDTO {
    private int idOrden;
    private String codigoOrden; 
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private String detalleProblema;
    private String observaciones;
    private BigDecimal totalCobro;
    private boolean pagado;
    private String estadoOrden;
    private ClienteRequestDTO fkCliente; 
    private UsuarioRequestDTO fkUsuario; 
    private BigDecimal costoEstimado;
}