package com.uisrael.clienteconsumo.service;

import java.util.List;	

import com.uisrael.clienteconsumo.model.dto.request.ClienteRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.ClienteResponseDTO;

public interface IClienteServicio {

	List<ClienteResponseDTO> listarCliente();
	
	void crearCliente(ClienteRequestDTO dto);
	
	ClienteResponseDTO buscarPorId(int idCliente);
	
	void eliminarCliente(int idCliente);
}
