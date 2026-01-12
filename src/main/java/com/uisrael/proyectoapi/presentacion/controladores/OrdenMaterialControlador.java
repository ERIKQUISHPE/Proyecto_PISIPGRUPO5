package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenMaterialCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.OrdenMaterialRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.OrdenMaterialResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IOrdenMaterialDtoMapper;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/ordenMaterial")
public class OrdenMaterialControlador {
	private final IOrdenMaterialCasoUso ordenMaterialCasoUso;
	private final IOrdenMaterialDtoMapper mapper;

	public OrdenMaterialControlador(IOrdenMaterialCasoUso ordenMaterialCasoUso, IOrdenMaterialDtoMapper mapper) {
		super();
		this.ordenMaterialCasoUso = ordenMaterialCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<OrdenMaterialResponseDTO> listar() {
		return ordenMaterialCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public OrdenMaterialResponseDTO crear(@Valid @RequestBody OrdenMaterialRequestDTO request) {
			return mapper.toResponseDto(ordenMaterialCasoUso.guardar(mapper.toDomain(request)));


}
}
