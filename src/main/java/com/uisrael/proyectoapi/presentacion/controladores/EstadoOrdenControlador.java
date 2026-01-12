package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IEstadoOrdenCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.EstadoOrdenRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.EstadoOrdenResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IEstadoOrdenDtoMapper;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/estadoOrden")
public class EstadoOrdenControlador {
	private final IEstadoOrdenCasoUso estadoOrdenCasoUso;
	private final IEstadoOrdenDtoMapper mapper;

	public EstadoOrdenControlador(IEstadoOrdenCasoUso estadoOrdenCasoUso, IEstadoOrdenDtoMapper mapper) {
		this.estadoOrdenCasoUso = estadoOrdenCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<EstadoOrdenResponseDTO> listar() {
		return estadoOrdenCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public EstadoOrdenResponseDTO crear(@Valid @RequestBody EstadoOrdenRequestDTO request) {
			return mapper.toResponseDto(estadoOrdenCasoUso.guardar(mapper.toDomain(request)));

}
}
	