package com.uisrael.clienteconsumo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.request.MaterialRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.MaterialResponseDTO;
import com.uisrael.clienteconsumo.service.IMaterialServicio;

@Service
public class MaterialServicioImpl implements IMaterialServicio {

	private final WebClient webmaterial;

	public MaterialServicioImpl(WebClient webmaterial) {

		this.webmaterial = webmaterial;
	}
	@Override
	public List<MaterialResponseDTO> listarMaterial() {
		return webmaterial.get().uri("/material").retrieve().bodyToFlux(MaterialResponseDTO.class).collectList()
				.block();
	}

	@Override
	public void crearMaterial(MaterialRequestDTO dto) {
		webmaterial.post().uri("/material").bodyValue(dto).retrieve().toBodilessEntity().block();

	}

	@Override
	public MaterialResponseDTO buscarPorId(int idMaterial) {
	    return webmaterial.get().uri("/material/{id}", idMaterial).retrieve().bodyToMono(MaterialResponseDTO.class).block();
	}

	@Override
	public MaterialResponseDTO actualizarMaterial(int idMaterial, MaterialRequestDTO dto) {
	    return webmaterial.put().uri("/material/{id}", idMaterial).bodyValue(dto).retrieve().bodyToMono(MaterialResponseDTO.class).block();
	}

	@Override
	public void eliminarMaterial(int idMaterial) {
		webmaterial.delete().uri("/material/{id}", idMaterial).retrieve().toBodilessEntity().block();
	}


}
