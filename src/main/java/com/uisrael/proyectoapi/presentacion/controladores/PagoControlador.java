package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IPagoCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.PagoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.PagoResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IPagoDtoMapper;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/pago")
public class PagoControlador {
	private final IPagoCasoUso pagoCasoUso;
	private final IPagoDtoMapper mapper;

	public PagoControlador(IPagoCasoUso pagoCasoUso, IPagoDtoMapper mapper) {
		this.pagoCasoUso = pagoCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<PagoResponseDTO> listar() {
		return pagoCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public PagoResponseDTO crear(@Valid @RequestBody PagoRequestDTO request) {
			return mapper.toResponseDto(pagoCasoUso.guardar(mapper.toDomain(request)));


}
}
