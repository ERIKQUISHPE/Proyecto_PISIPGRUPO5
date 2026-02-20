package com.uisrael.clienteconsumo.service;

import java.util.List;

import com.uisrael.clienteconsumo.model.dto.request.ProveedorRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.ProveedorResponseDTO;

public interface IProveedorServicio {
	
	List<ProveedorResponseDTO> listarProveedor();

	void crearProveedor(ProveedorRequestDTO dto);
	
	ProveedorResponseDTO buscarPorId(int idProveedor);
	
	void eliminarProveedor(int idProveedor);
}

	