package com.uisrael.clienteconsumo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.request.AccionReparacionMaterialRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.AccionReparacionMaterialResponseDTO;
import com.uisrael.clienteconsumo.service.IAccionReparacionMaterialServicio;

@Service
public class AccionReparacionMaterialServicioImpl implements IAccionReparacionMaterialServicio {

    private final WebClient webClient;

    public AccionReparacionMaterialServicioImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public void crearDetalle(AccionReparacionMaterialRequestDTO dto) {

        webClient.post()
                .uri("/accionReparacionMaterial") 
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public List<AccionReparacionMaterialResponseDTO> listarPorAccion(int idAccion) {

        return webClient.get()
                .uri("/accionReparacionMaterial/porAccion/{idAccion}", idAccion)
                .retrieve()
                .bodyToFlux(AccionReparacionMaterialResponseDTO.class)
                .collectList()
                .block();
    }
    
    @Override
    public List<AccionReparacionMaterialResponseDTO> listarPorOrden(int idOrden) {

        return webClient.get()
                .uri("/accionReparacionMaterial/porOrden/{idOrden}", idOrden)
                .retrieve()
                .bodyToFlux(AccionReparacionMaterialResponseDTO.class)
                .collectList()
                .block();
    }
    
    @Override
    public void eliminarPorAccion(int idAccion) {
        webClient.delete()
                .uri("/accionReparacionMaterial/porAccion/{idAccion}", idAccion)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

}
