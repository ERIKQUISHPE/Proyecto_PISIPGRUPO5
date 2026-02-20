package com.uisrael.proyectoapi.presentacion.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class PagoRequestDTO {
	
	private Integer idPago;

    @NotNull
    private Integer idOrden;

    @NotNull
    @PositiveOrZero
    private BigDecimal monto;

    @NotBlank
    private String metodoPago;

    private LocalDateTime fechaPago;

    @NotNull
    @Positive
    private Integer registradoPor;
}