package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IProveedorCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.ProveedorRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.ProveedorResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IProveedorDtoMapper;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/proveedor")
public class ProveedorControlador {
	private final IProveedorCasoUso proveedorCasoUso;
	private final IProveedorDtoMapper mapper;

	public ProveedorControlador(IProveedorCasoUso proveedorCasoUso, IProveedorDtoMapper mapper) {
		super();
		this.proveedorCasoUso = proveedorCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<ProveedorResponseDTO> listar() {
		return proveedorCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public ProveedorResponseDTO crear(@Valid @RequestBody ProveedorRequestDTO request) {
			return mapper.toResponseDto(proveedorCasoUso.guardar(mapper.toDomain(request)));
	}
	
	@GetMapping("buscarId")
	public ProveedorResponseDTO buscarPorId(int idProveedor) {
		return mapper.toResponseDto(proveedorCasoUso.buscarPorId(idProveedor));
	}
	
	@DeleteMapping
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void eliminar(@RequestParam("idProveedor") int idProveedor) {
		proveedorCasoUso.eliminar(idProveedor);
	  }
}
