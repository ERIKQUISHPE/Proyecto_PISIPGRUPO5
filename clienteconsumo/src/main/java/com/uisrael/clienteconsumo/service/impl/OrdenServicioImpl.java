package com.uisrael.clienteconsumo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.request.OrdenRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.OrdenResponseDTO;
import com.uisrael.clienteconsumo.model.dto.response.PagoResponseDTO;
import com.uisrael.clienteconsumo.service.IOrdenServicio;

@Service
public class OrdenServicioImpl implements IOrdenServicio {

  private final WebClient webclient;

  public OrdenServicioImpl(WebClient webclient) {
    this.webclient = webclient;
  }

  @Override
  public List<OrdenResponseDTO> listarOrden() {

    List<OrdenResponseDTO> lista = webclient.get()
        .uri("/orden")
        .retrieve()
        .bodyToFlux(OrdenResponseDTO.class)
        .collectList()
        .block();

    if (lista != null) {

      for (OrdenResponseDTO orden : lista) {

        try {
          Boolean tieneEquipo = webclient.get()
              .uri("/equipo/por-orden/{idOrden}", orden.getIdOrden())
              .retrieve()
              .bodyToMono(Boolean.class)
              .block();

          orden.setTieneEquipo(tieneEquipo != null && tieneEquipo);

        } catch (Exception e) {
          orden.setTieneEquipo(false);
        }

        try {
          PagoResponseDTO pago = webclient.get()
              .uri("/pago/por-orden/{idOrden}", orden.getIdOrden())
              .retrieve()
              .bodyToMono(PagoResponseDTO.class)
              .block();

          if (pago != null) {
            orden.setMontoPago(pago.getMonto());
          } else {
            orden.setMontoPago(null);
          }

        } catch (Exception e) {
          orden.setMontoPago(null);
        }
      }
    }

    return lista;
  }

  @Override
  public OrdenResponseDTO buscarPorId(int idOrden) {
    return webclient.get()
        .uri("/orden/{id}", idOrden)
        .retrieve()
        .bodyToMono(OrdenResponseDTO.class)
        .block();
  }

  @Override
  public OrdenResponseDTO crearOrden(OrdenRequestDTO dto) {
    Map<String, Object> body = armarBody(dto);

    return webclient.post()
        .uri("/orden")
        .bodyValue(body)
        .retrieve()
        .bodyToMono(OrdenResponseDTO.class)
        .block();
  }

  @Override
  public OrdenResponseDTO actualizarOrden(int idOrden, OrdenRequestDTO dto) {
    Map<String, Object> body = armarBody(dto);

    return webclient.put()
        .uri("/orden/{id}", idOrden)
        .bodyValue(body)
        .retrieve()
        .bodyToMono(OrdenResponseDTO.class)
        .block();
  }

  @Override
  public void eliminarOrden(int idOrden) {
    webclient.delete()
        .uri("/orden/{id}", idOrden)
        .retrieve()
        .toBodilessEntity()
        .block();
  }

  private Map<String, Object> armarBody(OrdenRequestDTO dto) {
    Map<String, Object> body = new HashMap<>();

    body.put("codigoOrden", dto.getCodigoOrden());
    body.put("detalleProblema", dto.getDetalleProblema());
    body.put("observaciones", dto.getObservaciones());
    body.put("estadoOrden", dto.getEstadoOrden());
    body.put("totalCobro", dto.getTotalCobro());
    body.put("pagado", dto.isPagado());

    Integer idCliente = null;
    Integer idUsuario = null;

    if (dto.getFkCliente() != null) idCliente = dto.getFkCliente().getIdCliente();
    if (dto.getFkUsuario() != null) idUsuario = dto.getFkUsuario().getIdUsuario();

    body.put("idCliente", idCliente);
    body.put("idUsuario", idUsuario);

    return body;
  }

  @Override
  public void cambiarEstado(int idOrden, String estado) {
    webclient.put()
        .uri("/orden/{id}/estado/{estado}", idOrden, estado)
        .retrieve()
        .toBodilessEntity()
        .block();
  }

  @Override
  public void cambiarEstadoOrden(int idOrden, String estado) {
    cambiarEstado(idOrden, estado);
  }

  @Override
  public List<OrdenResponseDTO> listarOrdenDisponibles() {
    return webclient.get()
        .uri("/orden/disponibles")
        .retrieve()
        .bodyToFlux(OrdenResponseDTO.class)
        .collectList()
        .block();
  }
}