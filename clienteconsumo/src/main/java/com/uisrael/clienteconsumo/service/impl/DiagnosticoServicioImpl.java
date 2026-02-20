package com.uisrael.clienteconsumo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.request.DiagnosticoRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.DiagnosticoResponseDTO;
import com.uisrael.clienteconsumo.service.IDiagnosticoServicio;

@Service
public class DiagnosticoServicioImpl implements IDiagnosticoServicio {

  private final WebClient web;

  public DiagnosticoServicioImpl(WebClient webcliente) {
    this.web = webcliente;
  }

  @Override
  public List<DiagnosticoResponseDTO> listarDiagnostico() {
    return web.get()
      .uri("/ordenInterna")
      .retrieve()
      .bodyToFlux(DiagnosticoResponseDTO.class)
      .collectList()
      .block();
  }

  @Override
  public DiagnosticoResponseDTO buscarPorId(int idOrdenInterna) {
    return web.get()
      .uri("/ordenInterna/{id}", idOrdenInterna)
      .retrieve()
      .bodyToMono(DiagnosticoResponseDTO.class)
      .block();
  }

  @Override
  public void guardarDiagnostico(int idOrdenInterna, DiagnosticoRequestDTO dto) {
    web.post()
      .uri("/ordenInterna/{id}/diagnostico", idOrdenInterna)
      .bodyValue(dto)
      .retrieve()
      .toBodilessEntity()
      .block();
  }

  @Override
  public void actualizarDiagnostico(int idOrdenInterna, DiagnosticoRequestDTO dto) {
    web.put()
      .uri("/ordenInterna/{id}/diagnostico", idOrdenInterna)
      .bodyValue(dto)
      .retrieve()
      .toBodilessEntity()
      .block();
  }

  @Override
  public void eliminarDiagnostico(int idOrdenInterna) {
    web.delete()
      .uri("/ordenInterna/{id}/diagnostico", idOrdenInterna)
      .retrieve()
      .toBodilessEntity()
      .block();
  }
}
