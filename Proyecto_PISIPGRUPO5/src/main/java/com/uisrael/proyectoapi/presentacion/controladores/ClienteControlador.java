package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IClienteCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.ClienteRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.ClienteResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IClienteDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

	private final IClienteCasoUso clienteCasoUso; 
	private final IClienteDtoMapper mapper;

	public ClienteControlador(IClienteCasoUso clienteCasoUso, IClienteDtoMapper mapper) {
		this.clienteCasoUso = clienteCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<ClienteResponseDTO> listar() {
		return clienteCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponseDTO crear(@Valid @RequestBody ClienteRequestDTO request) {
	    try {
	        return mapper.toResponseDto(clienteCasoUso.guardar(mapper.toDomain(request)));
	    } catch (DataIntegrityViolationException ex) {
	        String detalle = ex.getMostSpecificCause() != null ? ex.getMostSpecificCause().getMessage() : "";
	        detalle = detalle == null ? "" : detalle.toLowerCase();
	        if (detalle.contains("uk_cliente_ci")) {
	            throw new ResponseStatusException(HttpStatus.CONFLICT, "DUPLICADO_CI");
	        }
	        if (detalle.contains("uk_cliente_correo")) {
	            throw new ResponseStatusException(HttpStatus.CONFLICT, "DUPLICADO_CORREO");
	        }
	        throw new ResponseStatusException(HttpStatus.CONFLICT, "DUPLICADO");
	    }
	}

	@GetMapping("buscarId")
	public ClienteResponseDTO buscarPorId(int idCliente) {
		return mapper.toResponseDto(clienteCasoUso.buscarPorId(idCliente));
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@RequestParam("idCliente") int idCliente) {
		clienteCasoUso.eliminar(idCliente);
	}
}
