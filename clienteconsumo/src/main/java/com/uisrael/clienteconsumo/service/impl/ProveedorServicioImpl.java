package com.uisrael.clienteconsumo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.request.ProveedorRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.ProveedorResponseDTO;
import com.uisrael.clienteconsumo.service.IProveedorServicio;

@Service
public class ProveedorServicioImpl implements IProveedorServicio {

	private final WebClient webproveedor;

	public ProveedorServicioImpl(WebClient webproveedor) {
		this.webproveedor = webproveedor;
	}

	@Override
	public List<ProveedorResponseDTO> listarProveedor() {
		return webproveedor.get().uri("/proveedor").retrieve().bodyToFlux(ProveedorResponseDTO.class).collectList()
				.block();
	}

	@Override
	public void crearProveedor(ProveedorRequestDTO dto) {
		webproveedor.post().uri("/proveedor").bodyValue(dto).retrieve().toBodilessEntity().block();

	}

	@Override
	public ProveedorResponseDTO buscarPorId(int idProveedor) {
		return webproveedor.get().uri("/proveedor/buscarId").retrieve().bodyToFlux(ProveedorResponseDTO.class)
				.blockFirst();
	}
	  @Override
	  public void eliminarProveedor(int idProveedor) {
	    webproveedor.delete()
	      .uri(uriBuilder -> uriBuilder
	        .path("/proveedor")
	        .queryParam("idProveedor", idProveedor)
	        .build())
	      .retrieve()
	      .toBodilessEntity()
	      .block();
	  }
}