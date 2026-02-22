package com.uisrael.clienteconsumo.service.impl;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.response.DashboardResumenDTO;
import com.uisrael.clienteconsumo.model.dto.response.OrdenDashboardResponseDTO;
import com.uisrael.clienteconsumo.service.IDashboardServicio;

@Service
public class DashboardServicioImpl implements IDashboardServicio {

  private final WebClient webcliente;

  public DashboardServicioImpl(WebClient webcliente) {
    this.webcliente = webcliente;
  }

  private List<OrdenDashboardResponseDTO> listarOrdenes() {
    return webcliente.get()
      .uri("/orden/dashboard")
      .retrieve()
      .bodyToFlux(OrdenDashboardResponseDTO.class)
      .collectList()
      .block();
  }

  private boolean es(OrdenDashboardResponseDTO o, String... nombres) {
    if (o.getNombreEstado() == null) return false;
    String estado = o.getNombreEstado().toUpperCase();
    for (String n : nombres) {
      if (estado.contains(n.toUpperCase())) return true;
    }
    return false;
  }

  @Override
  public DashboardResumenDTO resumen() {
    List<OrdenDashboardResponseDTO> ordenes = listarOrdenes();
    if (ordenes == null) ordenes = List.of();

    List<OrdenDashboardResponseDTO> activas = ordenes.stream()
      .filter(OrdenDashboardResponseDTO::isEstado)
      .toList();

    long ingresado = activas.stream().filter(o -> es(o, "INGRESADO")).count();
    long enProceso = activas.stream().filter(o -> es(o, "EN_PROCESO", "EN PROCESO")).count();

    long reparacion = activas.stream().filter(o -> es(o, "REPARACION", "REPARACIÓN")).count();
    long listoEntrega = activas.stream().filter(o -> es(o, "LISTO ENTREGA", "LISTO_ENTREGA")).count();

    long finalizado = activas.stream().filter(o -> es(o, "FINALIZADO")).count();
    long entregado = activas.stream().filter(o -> es(o, "ENTREGADO")).count();

    DashboardResumenDTO dto = new DashboardResumenDTO();
    dto.setPendientes(ingresado);
    dto.setDiagnostico(enProceso);
    dto.setReparacion(reparacion);
    dto.setListoEntrega(listoEntrega);
    dto.setFinalizados(finalizado);
    dto.setEntregados(entregado);
    return dto;
  }

  @Override
  public Map<String, Long> porEstado() {
    DashboardResumenDTO r = resumen();
    Map<String, Long> map = new LinkedHashMap<>();

    map.put("Ingresado", r.getPendientes());
    map.put("En proceso", r.getDiagnostico());

    // opcionales, si no quieres que salgan en gráfico, borra estas 2 líneas
    if (r.getReparacion() > 0) map.put("Reparación", r.getReparacion());
    if (r.getListoEntrega() > 0) map.put("Listo entrega", r.getListoEntrega());

    map.put("Finalizado", r.getFinalizados());
    map.put("Entregado", r.getEntregados());

    return map;
  }

  @Override
  public List<String> labelsMeses(int meses) {
    List<String> labels = new ArrayList<>();
    YearMonth actual = YearMonth.now();
    for (int i = meses - 1; i >= 0; i--) {
      YearMonth ym = actual.minusMonths(i);
      labels.add(ym.getMonth().name().substring(0, 3) + "-" + ym.getYear());
    }
    return labels;
  }

  @Override
  public List<Long> porMes(int meses) {
    List<OrdenDashboardResponseDTO> ordenes = listarOrdenes();
    if (ordenes == null) ordenes = List.of();

    Map<YearMonth, Long> contador = new LinkedHashMap<>();
    YearMonth actual = YearMonth.now();
    for (int i = meses - 1; i >= 0; i--) contador.put(actual.minusMonths(i), 0L);

    for (OrdenDashboardResponseDTO o : ordenes) {
      if (o.getFechaIngreso() == null) continue;
      YearMonth ym = YearMonth.from(o.getFechaIngreso());
      if (contador.containsKey(ym)) contador.put(ym, contador.get(ym) + 1);
    }

    return new ArrayList<>(contador.values());
  }
}