package com.uisrael.clienteconsumo.service;

import java.util.List;

import com.uisrael.clienteconsumo.model.dto.request.EntregaRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.EntregaResponseDTO;

public interface IEntregaServicio {

    List<EntregaResponseDTO> listarEntrega();

    void crearEntrega(EntregaRequestDTO dto);

    EntregaResponseDTO buscarPorId(int idEntrega);

    void eliminarEntrega(int idEntrega);

    EntregaResponseDTO actualizarEntrega(int idEntrega, EntregaRequestDTO dto);
}
