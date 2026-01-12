package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IEntregaCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.EntregaRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.EntregaResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IEntregaDtoMapper;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/entrega")
public class EntregaControlador {
	private final IEntregaCasoUso entregaCasoUso;
	private final IEntregaDtoMapper mapper;

	public EntregaControlador(IEntregaCasoUso entregaCasoUso, IEntregaDtoMapper mapper) {
		super();
		this.entregaCasoUso = entregaCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<EntregaResponseDTO> listar() {
		return entregaCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaResponseDTO crear(@Valid @RequestBody EntregaRequestDTO request) {
		return mapper.toResponseDto(entregaCasoUso.guardar(mapper.toDomain(request)));

}
}
