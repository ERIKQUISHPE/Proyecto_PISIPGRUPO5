package com.uisrael.clienteconsumo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.request.EntregaRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.EntregaResponseDTO;
import com.uisrael.clienteconsumo.service.IEntregaServicio;

@Service
public class EntregaServicioImpl implements IEntregaServicio {

	private final WebClient webentrega;

	public EntregaServicioImpl(WebClient webentrega) {
		this.webentrega = webentrega;
	}

	@Override
	public List<EntregaResponseDTO> listarEntrega() {
		return webentrega.get().uri("/entrega").retrieve().bodyToFlux(EntregaResponseDTO.class).collectList().block();
	}

	@Override
	public void crearEntrega(EntregaRequestDTO dto) {
		webentrega.post().uri("/entrega").bodyValue(dto).retrieve().toBodilessEntity().block();
	}

	@Override
	public EntregaResponseDTO buscarPorId(int idEntrega) {
		return webentrega.get().uri("/entrega/{id}", idEntrega).retrieve().bodyToMono(EntregaResponseDTO.class).block();
	}

	@Override
	public EntregaResponseDTO actualizarEntrega(int idEntrega, EntregaRequestDTO dto) {
		return webentrega.put().uri("/entrega/{id}", idEntrega).bodyValue(dto).retrieve().bodyToMono(EntregaResponseDTO.class).block();
	}

	@Override
	public void eliminarEntrega(int idEntrega) {
		webentrega.delete().uri("/entrega/{id}", idEntrega).retrieve().toBodilessEntity().block();
	}
}
