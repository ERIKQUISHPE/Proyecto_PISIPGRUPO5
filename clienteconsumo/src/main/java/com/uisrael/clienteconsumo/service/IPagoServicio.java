package com.uisrael.clienteconsumo.service;

import java.util.List;
import com.uisrael.clienteconsumo.model.dto.request.PagoRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.PagoResponseDTO;

public interface IPagoServicio {

    List<PagoResponseDTO> listarPago();

    void crearPago(PagoRequestDTO dto);

    PagoResponseDTO buscarPorId(int idPago);

    void actualizarPago(int idPago, PagoRequestDTO dto);
    
    void eliminarPago(int idPago);
}