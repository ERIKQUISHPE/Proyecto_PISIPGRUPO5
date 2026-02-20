package com.uisrael.clienteconsumo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.clienteconsumo.model.dto.response.DashboardResumenDTO;
import com.uisrael.clienteconsumo.service.IDashboardServicio;

@Controller
public class DashboardController {

  private final IDashboardServicio dashboardServicio;

  public DashboardController(IDashboardServicio dashboardServicio) {
    this.dashboardServicio = dashboardServicio;
  }

  @GetMapping("/dashboard")
  public String ver(Model model) {
    DashboardResumenDTO resumen = dashboardServicio.resumen();
    Map<String, Long> porEstado = dashboardServicio.porEstado();
    List<String> mesLabels = dashboardServicio.labelsMeses(6);
    List<Long> mesValues = dashboardServicio.porMes(6);

    model.addAttribute("resumen", resumen);
    model.addAttribute("estadoLabels", porEstado.keySet());
    model.addAttribute("estadoValues", porEstado.values());
    model.addAttribute("mesLabels", mesLabels);
    model.addAttribute("mesValues", mesValues);

    return "dashboard/dashboard";
  }
}
