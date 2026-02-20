package com.uisrael.clienteconsumo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.request.ClienteRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.ClienteResponseDTO;
import com.uisrael.clienteconsumo.service.IClienteServicio;

@Service
public class ClienteServicioImpl implements IClienteServicio{
	
	private final WebClient webcliente;
	
	public ClienteServicioImpl(WebClient webcliente) {
		
		this.webcliente = webcliente;
	}
	

	@Override
	public List<ClienteResponseDTO> listarCliente() {
		return webcliente.get().uri("/clientes").retrieve().bodyToFlux(ClienteResponseDTO.class).collectList().block();
	}
	

	@Override
	public void crearCliente(ClienteRequestDTO dto) {
		webcliente.post().uri("/clientes").bodyValue(dto).retrieve().toBodilessEntity().block();
		
	}
	

	@Override
	public ClienteResponseDTO buscarPorId(int idCliente) {
		return webcliente.get().uri("/cliente/buscarId").retrieve().bodyToFlux(ClienteResponseDTO.class).blockFirst();
	}


	  @Override
	  public void eliminarCliente(int idCliente) {
	    webcliente.delete()
	      .uri(uriBuilder -> uriBuilder
	        .path("/clientes")
	        .queryParam("idCliente", idCliente)
	        .build())
	      .retrieve()
	      .toBodilessEntity()
	      .block();
	  }
	
}
