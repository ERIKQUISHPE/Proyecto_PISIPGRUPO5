package com.uisrael.clienteconsumo.model.dto.request;

import lombok.Data;
import java.time.LocalDateTime;
	@Data

	public class ReparacionRequestDTO {

		private int tecnicoId;
		private String descripcion;
		private Integer idOrden;
		private LocalDateTime fechaAccion;
	    private String accionRealizada;
	    private Integer idMaterial;
	 
	
	}

