package com.uisrael.clienteconsumo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.request.EquipoRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.EquipoResponseDTO;
import com.uisrael.clienteconsumo.service.IEquipoServicio;

import reactor.core.publisher.Mono;

@Service
public class EquipoServicioImpl implements IEquipoServicio {

  private final WebClient webClient;
  public EquipoServicioImpl(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder
      .baseUrl("http://localhost:8080")
      .build();
  }

  @Override
  public List<EquipoResponseDTO> listarEquipo() {

    List<EquipoResponseDTO> lista = webClient.get()
      .uri("/api/equipo")
      .retrieve()
      .bodyToFlux(EquipoResponseDTO.class)
      .collectList()
      .block();

    if (lista == null) return List.of();

    return lista.stream()
      .filter(Objects::nonNull)
      .toList();
  }

  @Override
  public void crearEquipo(EquipoRequestDTO dto) {

    Integer idOrden = null;

    if (dto.getFkOrden() != null && dto.getFkOrden().getIdOrden() != null) {
      idOrden = dto.getFkOrden().getIdOrden();
    }
    else if (dto.getIdOrden() != null) {
      idOrden = dto.getIdOrden();
    }

    Map<String, Object> payload = new HashMap<>();
    payload.put("tipo", dto.getTipo());
    payload.put("marca", dto.getMarca());
    payload.put("modelo", dto.getModelo());
    payload.put("serial", dto.getSerial());
    String estado = dto.getEstadoEquipo();
    payload.put("estadoEquipo", (estado == null || estado.trim().isEmpty()) ? "ACTIVO" : estado);

    String obs = dto.getObservaciones();
    payload.put("observaciones", (obs == null || obs.trim().isEmpty()) ? "SIN OBSERVACIONES" : obs);
    payload.put("fkOrden", idOrden);

    webClient.post()
      .uri("/api/equipo")
      .bodyValue(payload)
      .retrieve()
      .onStatus(HttpStatus.BAD_REQUEST::equals, r ->
        r.bodyToMono(String.class).flatMap(body ->
          Mono.error(new RuntimeException("400 BAD REQUEST en API /api/equipo, body = " + body))
        )
      )
      .onStatus(HttpStatus.CONFLICT::equals, r ->
        r.bodyToMono(String.class).flatMap(body ->
          Mono.error(new RuntimeException("409 CONFLICT, la orden ya tiene equipo, body = " + body))
        )
      )
      .toBodilessEntity()
      .block();
  }

  @Override
  public Boolean existePorOrden(Integer idOrden) {
    try {
      Boolean resp = webClient.get()
        .uri("/api/equipo/por-orden/{idOrden}", idOrden)
        .retrieve()
        .bodyToMono(Boolean.class)
        .block();
      return resp != null && resp;
    } catch (Exception e) {
      System.err.println("Error al verificar equipo: " + e.getMessage());
      return false;
    }
  }
  @Override
  public EquipoResponseDTO buscarPorId(Integer id) {
    try {
      return webClient.get()
        .uri("/api/equipo/{id}", id)
        .retrieve()
        .bodyToMono(EquipoResponseDTO.class)
        .block();
    } catch (Exception e) {
      System.err.println("Error buscarPorId equipo: " + e.getMessage());
      return null;
    }
  }


  @Override
  public void eliminar(Integer id) {
    try {
      webClient.delete()
        .uri("/api/equipo/{id}", id)
        .retrieve()
        .toBodilessEntity()
        .block();
    } catch (Exception e) {
      System.err.println("Error eliminar equipo: " + e.getMessage());
    }
  }

  @Override
  public EquipoResponseDTO actualizar(Integer id, EquipoRequestDTO dto) {
    Integer idOrden = null;
    if (dto.getFkOrden() != null && dto.getFkOrden().getIdOrden() != null) idOrden = dto.getFkOrden().getIdOrden();
    else if (dto.getIdOrden() != null) idOrden = dto.getIdOrden();

    Map<String, Object> payload = new HashMap<>();
    payload.put("tipo", dto.getTipo());
    payload.put("marca", dto.getMarca());
    payload.put("modelo", dto.getModelo());
    payload.put("serial", dto.getSerial());
    payload.put("estadoEquipo", dto.getEstadoEquipo());
    payload.put("observaciones", dto.getObservaciones());
    payload.put("fkOrden", idOrden);

    return webClient.put()
      .uri("/api/equipo/{id}", id)
      .bodyValue(payload)
      .retrieve()
      .bodyToMono(EquipoResponseDTO.class)
      .block();
  }
  
  @Override
  public EquipoResponseDTO actualizarEquipo(Integer id, EquipoRequestDTO dto) {
      return actualizar(id, dto);
  }
 

  @Override
  public EquipoResponseDTO obtenerPorOrden(Integer idOrden) {
    return null;
  }
}
