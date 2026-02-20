package com.uisrael.clienteconsumo.model.dto.response;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class DiagnosticoResponseDTO {
	   private int idOrdenInterna;
	    private int tecnicoId;
	    private int estadoId;
	    private String diagnostico;
	    private String observaciones;
	    private Integer creadoPor;
	    private LocalDateTime creadoEn;
	    private String tecnicoNombre;
	    private String tecnicoApellido;
	    private Integer idOrden;
	    private String codigoOrden;
	    private String textoOrden;
	    private String estadoOrden;


}
