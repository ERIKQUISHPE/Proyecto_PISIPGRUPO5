package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IUsuarioCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.UsuarioRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.UsuarioResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IUsuarioDtoMapper;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/usuario")
public class UsuarioControlador {
	private final IUsuarioCasoUso usuarioCasoUso;
	private final IUsuarioDtoMapper mapper;

	public UsuarioControlador(IUsuarioCasoUso usuarioCasoUso, IUsuarioDtoMapper mapper) {
		super();
		this.usuarioCasoUso = usuarioCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<UsuarioResponseDTO> listar() {
		return usuarioCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public UsuarioResponseDTO crear(@Valid @RequestBody UsuarioRequestDTO request) {
			return mapper.toResponseDto(usuarioCasoUso.guardar(mapper.toDomain(request)));

}
}
