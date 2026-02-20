package com.uisrael.clienteconsumo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.response.OrdenInternaResponseDTO;
import com.uisrael.clienteconsumo.service.IOrdenInternaServicio;

@Service
public class OrdenInternaServicioImpl implements IOrdenInternaServicio {

    private final WebClient webCliente;

    public OrdenInternaServicioImpl(WebClient webCliente) {
        this.webCliente = webCliente;
    }

    @Override
    public List<OrdenInternaResponseDTO> listarDisponibles() {
        return webCliente.get()
                .uri("/ordenInterna/disponibles")
                .retrieve()
                .bodyToFlux(OrdenInternaResponseDTO.class)
                .collectList()
                .block();
    }
    
    @Override
    public List<OrdenInternaResponseDTO> listarTodas() {
        return webCliente.get()
                .uri("/ordenInterna")
                .retrieve()
                .bodyToFlux(OrdenInternaResponseDTO.class)
                .collectList()
                .block();
    }
    
    @Override
    public OrdenInternaResponseDTO buscarPorId(int idOrdenInterna) {
        return webCliente.get()
                .uri("/ordenInterna/{id}", idOrdenInterna)
                .retrieve()
                .bodyToMono(OrdenInternaResponseDTO.class)
                .block();
    }
    
    @Override
    public List<OrdenInternaResponseDTO> listarParaReparacion() {
        return webCliente.get()
                .uri("/ordenInterna/para-reparacion")
                .retrieve()
                .bodyToFlux(OrdenInternaResponseDTO.class)
                .collectList()
                .block();
    }

}
