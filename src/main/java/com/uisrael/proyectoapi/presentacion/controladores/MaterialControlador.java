package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IMaterialCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.MaterialRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.MaterialResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IMaterialDtoMapper;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/material")
public class MaterialControlador {
	private final IMaterialCasoUso materialCasoUso;
	private final IMaterialDtoMapper mapper;
	public MaterialControlador(IMaterialCasoUso materialCasoUso, IMaterialDtoMapper mapper) {
		this.materialCasoUso = materialCasoUso;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<MaterialResponseDTO> listar() {
		return materialCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public MaterialResponseDTO crear(@Valid @RequestBody MaterialRequestDTO request) {
			return mapper.toResponseDto(materialCasoUso.guardar(mapper.toDomain(request)));

}
}
