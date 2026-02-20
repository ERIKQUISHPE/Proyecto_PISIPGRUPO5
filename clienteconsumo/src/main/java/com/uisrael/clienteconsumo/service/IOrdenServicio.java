package com.uisrael.clienteconsumo.service;

import java.util.List;

import com.uisrael.clienteconsumo.model.dto.request.OrdenRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.OrdenResponseDTO;

public interface IOrdenServicio {
  List<OrdenResponseDTO> listarOrden();
  OrdenResponseDTO buscarPorId(int idOrden);
  OrdenResponseDTO crearOrden(OrdenRequestDTO dto);

  OrdenResponseDTO actualizarOrden(int idOrden, OrdenRequestDTO dto);
  void eliminarOrden(int idOrden);
  void cambiarEstadoOrden(int idOrden, String estado);
  
  List<OrdenResponseDTO> listarOrdenDisponibles();

}
