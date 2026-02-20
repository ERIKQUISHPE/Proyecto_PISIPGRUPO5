package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EntregaRequestDTO {	
	@NotBlank
	private String notas;
	@NotNull
	private UsuarioRequestDTO  entregadoPor;
	@NotNull
	private String  recibidoPor;
	@NotNull
	private OrdenRequestDTO fkOrden;
}
