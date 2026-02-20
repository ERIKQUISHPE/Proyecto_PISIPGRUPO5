package com.uisrael.clienteconsumo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.request.ReparacionRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.ReparacionResponseDTO;
import com.uisrael.clienteconsumo.service.IReparacionServicio;

@Service
public class ReparacionServicioImpl implements IReparacionServicio {

    private final WebClient webcliente;

    public ReparacionServicioImpl(WebClient webcliente) {
        this.webcliente = webcliente;
    }

    @Override
    public List<ReparacionResponseDTO> listarReparacion() {
        return webcliente.get()
                .uri("/accionReparacion")
                .retrieve()
                .bodyToFlux(ReparacionResponseDTO.class)
                .collectList()
                .block();
    }

    @Override
    public ReparacionResponseDTO crearReparacion(ReparacionRequestDTO dto) {
        return webcliente.post()
                .uri("/accionReparacion")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(ReparacionResponseDTO.class)
                .block();
    }


    @Override
    public ReparacionResponseDTO buscarPorId(int idAccion) {
        return webcliente.get()
                .uri("/accionReparacion/{id}", idAccion)
                .retrieve()
                .bodyToMono(ReparacionResponseDTO.class)
                .block();
    }

    @Override
    public void actualizarReparacion(int idAccion, ReparacionRequestDTO dto) {
        webcliente.put()
                .uri("/accionReparacion/{id}", idAccion)
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void eliminarReparacion(int idAccion) {
        webcliente.delete()
                .uri("/accionReparacion/{id}", idAccion)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
    
    @Override
    public void anularReparacion(int idAccion) {
        webcliente.put()
            .uri("/accionReparacion/anular/{id}", idAccion)
            .retrieve()
            .toBodilessEntity()
            .block();
    }

}
