package com.uisrael.clienteconsumo.service;

import java.util.List;	

import com.uisrael.clienteconsumo.model.dto.request.MaterialRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.MaterialResponseDTO;

public interface IMaterialServicio {

	List<MaterialResponseDTO> listarMaterial();
	
	void crearMaterial (MaterialRequestDTO dto);
	
	MaterialResponseDTO buscarPorId(int idMaterial);
	
	void eliminarMaterial(int idMaterial);
	
    MaterialResponseDTO actualizarMaterial(int idMaterial,MaterialRequestDTO dto);
}
