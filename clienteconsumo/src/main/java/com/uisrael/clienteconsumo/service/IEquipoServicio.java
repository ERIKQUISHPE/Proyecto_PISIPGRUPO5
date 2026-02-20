package com.uisrael.clienteconsumo.service;

import java.util.List;

import com.uisrael.clienteconsumo.model.dto.request.EquipoRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.EquipoResponseDTO;


public interface IEquipoServicio {

	  List<EquipoResponseDTO> listarEquipo();

	  void crearEquipo(EquipoRequestDTO dto);

	  EquipoResponseDTO buscarPorId(Integer id);

	  void eliminar(Integer id);

	  Boolean existePorOrden(Integer idOrden);

	  EquipoResponseDTO obtenerPorOrden(Integer idOrden);

	  EquipoResponseDTO actualizar(Integer id, EquipoRequestDTO dto);
	  
	  EquipoResponseDTO actualizarEquipo(Integer id, EquipoRequestDTO dto);


	}