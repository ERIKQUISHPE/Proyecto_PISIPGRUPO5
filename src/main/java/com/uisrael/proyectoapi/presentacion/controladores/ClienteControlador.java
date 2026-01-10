package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IClienteCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.ClienteRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.ClienteResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IClienteDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {
	//dependencias de la  arquitectura
	private final IClienteCasoUso clienteCasoUso; //casos de uso
	private final IClienteDtoMapper mapper; //mapeadores
	
	public ClienteControlador(IClienteCasoUso clienteCasoUso, IClienteDtoMapper mapper) {
		this.clienteCasoUso = clienteCasoUso;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<ClienteResponseDTO> listar() {
		return clienteCasoUso.listar().stream().map(mapper::toResponseDto).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponseDTO crear(@Valid @RequestBody ClienteRequestDTO request) {
		return mapper.toResponseDto(clienteCasoUso.crear(mapper.toDomain(request)));
	}
	
	
	//casos de uso
	//mapeadores
	//metodos
		//post
		//get
	
}
