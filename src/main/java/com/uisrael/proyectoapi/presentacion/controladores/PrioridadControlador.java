package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IPrioridadCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.PrioridadRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.PrioridadResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IPrioridadDtoMapper;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/prioridad")
public class PrioridadControlador {
	private final IPrioridadCasoUso prioridadCasoUso;
	private final IPrioridadDtoMapper mapper;

	public PrioridadControlador(IPrioridadCasoUso prioridadCasoUso, IPrioridadDtoMapper mapper) {
		super();
		this.prioridadCasoUso = prioridadCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<PrioridadResponseDTO> listar() {
		return prioridadCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public PrioridadResponseDTO crear(@Valid @RequestBody PrioridadRequestDTO request) {
			return mapper.toResponseDto(prioridadCasoUso.guardar(mapper.toDomain(request)));


}
}
