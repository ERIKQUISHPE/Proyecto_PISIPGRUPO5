package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IEquipoCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.EquipoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.EquipoResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IEquipoDtoMapper;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/equipo")
public class EquipoControlador {
	private final IEquipoCasoUso equipoCasoUso;
	private final IEquipoDtoMapper mapper;

	public EquipoControlador(IEquipoCasoUso equipoCasoUso, IEquipoDtoMapper mapper) {
		this.equipoCasoUso = equipoCasoUso;
		this.mapper = mapper;
	}


	@GetMapping
	public List<EquipoResponseDTO> listar() {
		return equipoCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public EquipoResponseDTO crear(@Valid @RequestBody EquipoRequestDTO request) {
			return mapper.toResponseDto(equipoCasoUso.guardar(mapper.toDomain(request)));

}
}
