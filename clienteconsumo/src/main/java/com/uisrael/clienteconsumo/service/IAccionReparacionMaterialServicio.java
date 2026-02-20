package com.uisrael.clienteconsumo.service;

import java.util.List;
import com.uisrael.clienteconsumo.model.dto.request.AccionReparacionMaterialRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.AccionReparacionMaterialResponseDTO;

public interface IAccionReparacionMaterialServicio {

    void crearDetalle(AccionReparacionMaterialRequestDTO dto);

    List<AccionReparacionMaterialResponseDTO> listarPorAccion(int idAccion);
    
    List<AccionReparacionMaterialResponseDTO> listarPorOrden(int idOrden);
    void eliminarPorAccion(int idAccion);

}
