package com.uisrael.clienteconsumo.service;

import java.util.List;
import com.uisrael.clienteconsumo.model.dto.response.OrdenInternaResponseDTO;

public interface IOrdenInternaServicio {
    List<OrdenInternaResponseDTO> listarDisponibles();
    List<OrdenInternaResponseDTO> listarTodas();
    OrdenInternaResponseDTO buscarPorId(int idOrdenInterna);
    List<OrdenInternaResponseDTO> listarParaReparacion();

}
