package com.uisrael.clienteconsumo.service;

import java.util.List;

import com.uisrael.clienteconsumo.model.dto.request.DiagnosticoRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.DiagnosticoResponseDTO;

public interface IDiagnosticoServicio {

	  List<DiagnosticoResponseDTO> listarDiagnostico();
	  DiagnosticoResponseDTO buscarPorId(int idOrdenInterna);
	  void guardarDiagnostico(int idOrdenInterna, DiagnosticoRequestDTO dto);
	  void actualizarDiagnostico(int idOrdenInterna, DiagnosticoRequestDTO dto);
	  void eliminarDiagnostico(int idOrdenInterna);
}