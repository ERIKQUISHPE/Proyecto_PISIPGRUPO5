package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenInternaCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.OrdenInternaRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.OrdenInternaResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IOrdenInternaDtoMapper;


import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/ordenInterna")
public class OrdenInternaControlador {
	private final IOrdenInternaCasoUso ordenInternaCasoUso;
	private final IOrdenInternaDtoMapper mapper;
	
	
	public OrdenInternaControlador(IOrdenInternaCasoUso ordenInternaCasoUso, IOrdenInternaDtoMapper mapper) {
		super();
		this.ordenInternaCasoUso = ordenInternaCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<OrdenInternaResponseDTO> listar() {
		return ordenInternaCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public OrdenInternaResponseDTO crear(@Valid @RequestBody OrdenInternaRequestDTO request) {
			return mapper.toResponseDto(ordenInternaCasoUso.guardar(mapper.toDomain(request)));

}
}

