package com.uisrael.clienteconsumo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uisrael.clienteconsumo.model.dto.request.EquipoRequestDTO;
import com.uisrael.clienteconsumo.model.dto.request.OrdenRefRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.EquipoResponseDTO;
import com.uisrael.clienteconsumo.model.dto.response.OrdenResponseDTO;
import com.uisrael.clienteconsumo.service.IEquipoServicio;
import com.uisrael.clienteconsumo.service.IOrdenServicio;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

  @Autowired
  private IEquipoServicio equipoServicio;

  @Autowired
  private IOrdenServicio ordenServicio;

  @GetMapping
  public String listar(Model model) {
    List<EquipoResponseDTO> resultado = equipoServicio.listarEquipo();
    model.addAttribute("listaequipo", resultado);
    return "equipo/listarequipo";
  }
  @GetMapping("/nuevo")
  public String crear(@RequestParam(value = "ordenId", required = false) Integer ordenId, Model model) {

    if (ordenId == null) {
      return "redirect:/ordenes";
    }

    EquipoRequestDTO equipo = new EquipoRequestDTO();
    equipo.setIdOrden(ordenId);
    model.addAttribute("ordenFijada", true);
    List<OrdenResponseDTO> ordenes = ordenServicio.listarOrden();
    model.addAttribute("listaorden", ordenes);

    model.addAttribute("equipo", equipo);

    return "equipo/nuevoequipo";
  }

  @PostMapping("/guardar")
  public String guardar(@ModelAttribute("equipo") EquipoRequestDTO dto, Model model) {
    if (dto.getIdOrden() != null) {
      OrdenRefRequestDTO ref = new OrdenRefRequestDTO();
      ref.setIdOrden(dto.getIdOrden());
      dto.setFkOrden(ref);
    }
    String serialNuevo = (dto.getSerial() == null) ? "" : dto.getSerial().trim();
    if (!serialNuevo.isEmpty()) {
      List<EquipoResponseDTO> equipos = equipoServicio.listarEquipo();
      for (EquipoResponseDTO e : equipos) {
        String serialExistente = (e.getSerial() == null) ? "" : e.getSerial().trim();
        if (dto.getIdEquipo() == null || e.getIdEquipo() != dto.getIdEquipo()) {
            if (!serialExistente.isEmpty() && serialExistente.equalsIgnoreCase(serialNuevo)) {
                model.addAttribute("errorSerial", "Este SN ya está registrado");
                model.addAttribute("equipo", dto);
                model.addAttribute("ordenFijada", true);
                List<OrdenResponseDTO> ordenes = ordenServicio.listarOrden();
                model.addAttribute("listaorden", ordenes);
                return "equipo/nuevoequipo";
              }
        	}
          }
        }
    if (dto.getIdEquipo() != null && dto.getIdEquipo() > 0) {
      equipoServicio.actualizarEquipo(dto.getIdEquipo(), dto);
      return "redirect:/equipos";
    }
    equipoServicio.crearEquipo(dto);
    return "redirect:/ordenes";
  }

  @GetMapping("/por-orden/{idOrden}")
  public Boolean existeEquipoPorOrden(@PathVariable Integer idOrden) {
    return equipoServicio.existePorOrden(idOrden);
  }
  
  @GetMapping("/editar/{id}")
  public String editar(@PathVariable Integer id, Model model) {

      EquipoResponseDTO equipo = equipoServicio.buscarPorId(id);

      if (equipo == null) {
          return "redirect:/equipos";
      }

      EquipoRequestDTO dto = new EquipoRequestDTO();

      dto.setIdEquipo(equipo.getIdEquipo());
      dto.setTipo(equipo.getTipo());
      dto.setMarca(equipo.getMarca());
      dto.setModelo(equipo.getModelo());
      dto.setSerial(equipo.getSerial());
      dto.setEstadoEquipo(equipo.getEstadoEquipo());
      dto.setObservaciones(equipo.getObservaciones());
      if (equipo.getFkOrden() != null) {
          dto.setIdOrden(equipo.getFkOrden().getIdOrden());
      }

      model.addAttribute("equipo", dto);
      model.addAttribute("ordenFijada", true);

      return "equipo/nuevoequipo";
  }
  
  @GetMapping("/eliminar/{id}")
  public String eliminar(@PathVariable Integer id) {
      equipoServicio.eliminar(id);
      return "redirect:/equipos";
  }



}
