package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IAccionReparacionCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.AccionReparacionRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.AccionReparacionResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IAccionReparacionDtoMapper;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/accionReparacion")
public class AccionReparacionControlador {
	private final IAccionReparacionCasoUso accionReparacionCasoUso;
	private final IAccionReparacionDtoMapper mapper;
	
	
	public AccionReparacionControlador(IAccionReparacionCasoUso accionReparacionCasoUso,
			IAccionReparacionDtoMapper mapper) {
		this.accionReparacionCasoUso = accionReparacionCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<AccionReparacionResponseDTO> listar() {
		return accionReparacionCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AccionReparacionResponseDTO crear(@Valid @RequestBody AccionReparacionRequestDTO request) {
		return mapper.toResponseDto(accionReparacionCasoUso.guardar(mapper.toDomain(request)));

}
}
	
