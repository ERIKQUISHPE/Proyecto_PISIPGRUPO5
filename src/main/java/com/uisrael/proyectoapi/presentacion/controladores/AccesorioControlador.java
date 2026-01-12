package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IAccesorioCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.AccesorioRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.AccesorioResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IAccesorioDtoMapper;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/accesorioControlador")
public class AccesorioControlador {
	private final IAccesorioCasoUso accesorioCasoUso;
	private final IAccesorioDtoMapper mapper;
	public AccesorioControlador(IAccesorioCasoUso accesorioCasoUso, IAccesorioDtoMapper mapper) {
		this.accesorioCasoUso = accesorioCasoUso;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<AccesorioResponseDTO> listar() {
		return accesorioCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AccesorioResponseDTO crear(@Valid @RequestBody AccesorioRequestDTO request) {
		return mapper.toResponseDto(accesorioCasoUso.guardar(mapper.toDomain(request)));
	}
}

