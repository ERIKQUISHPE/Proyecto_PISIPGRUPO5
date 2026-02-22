package com.uisrael.clienteconsumo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uisrael.clienteconsumo.model.dto.request.EntregaRequestDTO;
import com.uisrael.clienteconsumo.model.dto.request.OrdenRequestDTO;
import com.uisrael.clienteconsumo.model.dto.request.UsuarioRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.EntregaResponseDTO;
import com.uisrael.clienteconsumo.model.dto.response.OrdenResponseDTO;
import com.uisrael.clienteconsumo.model.dto.response.UsuarioResponseDTO;
import com.uisrael.clienteconsumo.service.IEntregaServicio;
import com.uisrael.clienteconsumo.service.IOrdenServicio;
import com.uisrael.clienteconsumo.service.IUsuarioServicio;

@Controller
@RequestMapping("/entregas")
public class EntregaController {

  @Autowired
  private IEntregaServicio entregaServicio;

  @Autowired
  private IOrdenServicio ordenServicio;

  @Autowired
  private IUsuarioServicio usuarioServicio;

  @GetMapping
  public String listar(Model model) {
    List<EntregaResponseDTO> resultado = entregaServicio.listarEntrega();
    model.addAttribute("listaentrega", resultado);
    return "orden/listarentrega";
  }

  @GetMapping("/nuevo")
  public String crear(Model model) {
    List<OrdenResponseDTO> ordenes = ordenServicio.listarOrdenDisponibles();
    List<UsuarioResponseDTO> usuarios = usuarioServicio.listarUsuario();

    EntregaRequestDTO entrega = new EntregaRequestDTO();
    entrega.setFkOrden(new OrdenRequestDTO());
    entrega.setEntregadoPor(new UsuarioRequestDTO());

    model.addAttribute("entrega", entrega);
    model.addAttribute("listaorden", ordenes);
    model.addAttribute("listausuario", usuarios);
    model.addAttribute("fecha", "Se genera al guardar la entrega");
    return "orden/nuevaentrega";
  }

  @PostMapping("/guardar")
  public String guardarEntrega(@ModelAttribute("entrega") EntregaRequestDTO dto, Model model) {

    if (dto.getFkOrden().getIdOrden() == 0
        || dto.getEntregadoPor().getIdUsuario() == 0
        || dto.getRecibidoPor() == null
        || dto.getRecibidoPor().trim().isEmpty()) {

      model.addAttribute("error", "Debe seleccionar Orden, Entregado por y escribir Recibido por");
      model.addAttribute("entrega", dto);
      model.addAttribute("listaorden", ordenServicio.listarOrdenDisponibles());
      model.addAttribute("listausuario", usuarioServicio.listarUsuario());
      model.addAttribute("fecha", "Se genera al guardar la entrega"); 
      return "orden/nuevaentrega";
    }

    if (dto.getIdEntrega() > 0) {
      entregaServicio.actualizarEntrega(dto.getIdEntrega(), dto);
    } else {
      entregaServicio.crearEntrega(dto);
    }

    int idOrden = dto.getFkOrden().getIdOrden();
    ordenServicio.cambiarEstado(idOrden, "ENTREGADO"); 

    return "redirect:/entregas";
  }

  @GetMapping("/editar")
  public String editar(@RequestParam int idEntrega, Model model) {
    EntregaResponseDTO entregaResp = entregaServicio.buscarPorId(idEntrega);

    EntregaRequestDTO entrega = new EntregaRequestDTO();
    entrega.setIdEntrega(idEntrega);
    entrega.setNotas(entregaResp.getNotas());

    if (entregaResp.getFkOrden() != null) {
      OrdenRequestDTO orden = new OrdenRequestDTO();
      orden.setIdOrden(entregaResp.getFkOrden().getIdOrden());
      entrega.setFkOrden(orden);
    } else {
      entrega.setFkOrden(new OrdenRequestDTO());
    }

    if (entregaResp.getEntregadoPor() != null) {
      UsuarioRequestDTO admin = new UsuarioRequestDTO();
      admin.setIdUsuario(entregaResp.getEntregadoPor().getIdUsuario());
      entrega.setEntregadoPor(admin);
    } else {
      entrega.setEntregadoPor(new UsuarioRequestDTO());
    }

    entrega.setRecibidoPor(entregaResp.getRecibidoPor() != null ? entregaResp.getRecibidoPor() : "");

    model.addAttribute("entrega", entrega);

    model.addAttribute("listaorden", ordenServicio.listarOrdenDisponibles());

    model.addAttribute("listausuario", usuarioServicio.listarUsuario());
    model.addAttribute("fecha", "Se genera al guardar la entrega");
    return "orden/nuevaentrega";
  }

  @PostMapping("/actualizar/{id}")
  public String actualizar(@PathVariable int id, @ModelAttribute("entrega") EntregaRequestDTO dto) {
    entregaServicio.actualizarEntrega(id, dto);

    if (dto.getFkOrden() != null && dto.getFkOrden().getIdOrden() > 0) {
      ordenServicio.cambiarEstado(dto.getFkOrden().getIdOrden(), "ENTREGADO");
    }

    return "redirect:/entregas";
  }

  @GetMapping("/eliminar")
  public String eliminar(@RequestParam int idEntrega) {
    entregaServicio.eliminarEntrega(idEntrega);
    return "redirect:/entregas";
  }
}