package com.uisrael.clienteconsumo.service;

import java.util.List;
import java.util.Map;

import com.uisrael.clienteconsumo.model.dto.response.DashboardResumenDTO;

public interface IDashboardServicio {
  DashboardResumenDTO resumen();
  Map<String, Long> porEstado();
  List<String> labelsMeses(int meses);
  List<Long> porMes(int meses);
}
