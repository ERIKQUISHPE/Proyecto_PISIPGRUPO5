package com.uisrael.proyectoapi.presentacion.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class PagoRequestDTO {
	//private final int idPago;
	@NotBlank
    private  BigDecimal monto;
	@NotBlank
    private  String metodoPago;
	@NotBlank
    private  LocalDateTime fechaPago;
	@NotBlank
    private  int registradoPor;

}