package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.OrdenRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.OrdenResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IOrdenDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenControlador {
	//dependencias de la  arquitectura
	private final IOrdenCasoUso ordenCasoUso; //casos de uso
	private final IOrdenDtoMapper mapper; //mapeadores
	
	public OrdenControlador(IOrdenCasoUso ordenCasoUso, IOrdenDtoMapper mapper) {
		this.ordenCasoUso = ordenCasoUso;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<OrdenResponseDTO> listar() {
		return ordenCasoUso.listar().stream().map(mapper::toResponseDto).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdenResponseDTO crear(@Valid @RequestBody OrdenRequestDTO request) {
		return mapper.toResponseDto(ordenCasoUso.crear(mapper.toDomain(request)));
	}
}
