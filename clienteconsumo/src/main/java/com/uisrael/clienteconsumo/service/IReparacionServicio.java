package com.uisrael.clienteconsumo.service;

import java.util.List;

import com.uisrael.clienteconsumo.model.dto.request.ReparacionRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.ReparacionResponseDTO;

public interface IReparacionServicio {

    List<ReparacionResponseDTO> listarReparacion();

    ReparacionResponseDTO crearReparacion(ReparacionRequestDTO dto);

    ReparacionResponseDTO buscarPorId(int idAccion);

    void actualizarReparacion(int idAccion, ReparacionRequestDTO dto);

    void eliminarReparacion(int idAccion);
    
    void anularReparacion(int idAccion);

    
}
