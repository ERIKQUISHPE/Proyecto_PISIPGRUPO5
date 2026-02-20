package com.uisrael.clienteconsumo.model.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class AccionReparacionMaterialResponseDTO {

    private int idAccionMaterial;
    private Integer idAccion;
    private Integer idMaterial;
    private int cantidad;
    private BigDecimal costoCompra;
    private BigDecimal costoVenta;
    private String materialCodigo;
    private String materialNombre;
}
