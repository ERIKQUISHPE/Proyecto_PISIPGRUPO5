package com.uisrael.clienteconsumo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uisrael.clienteconsumo.model.dto.request.ClienteRequestDTO;
import com.uisrael.clienteconsumo.model.dto.request.OrdenRequestDTO;
import com.uisrael.clienteconsumo.model.dto.request.UsuarioRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.ClienteResponseDTO;
import com.uisrael.clienteconsumo.model.dto.response.OrdenResponseDTO;
import com.uisrael.clienteconsumo.model.dto.response.UsuarioResponseDTO;
import com.uisrael.clienteconsumo.service.IClienteServicio;
import com.uisrael.clienteconsumo.service.IOrdenServicio;
import com.uisrael.clienteconsumo.service.IUsuarioServicio;

@Controller
@RequestMapping("/ordenes")
public class OrdenController {

  @Autowired private IOrdenServicio ordenServicio;
  @Autowired private IClienteServicio clienteServicio;
  @Autowired private IUsuarioServicio usuarioServicio;

  @GetMapping
  public String listar(Model model, @ModelAttribute("msg") String msg, @ModelAttribute("error") String error) {
    List<OrdenResponseDTO> resultado = ordenServicio.listarOrden();
    model.addAttribute("listaorden", resultado);
    return "/orden/listarorden";
  }

  @GetMapping("/nuevo")
  public String nuevo(
      @RequestParam(value = "clienteId", required = false) Integer clienteId,
      @RequestParam(value = "tecnicoId", required = false) Integer tecnicoId,
      Model model
  ) {
    cargarCombos(model);

    OrdenRequestDTO orden = new OrdenRequestDTO();
    orden.setEstadoOrden("INGRESADO");
    orden.setCodigoOrden("ORD-" + System.currentTimeMillis());
    orden.setFechaIngreso(LocalDateTime.now());

    ClienteResponseDTO clienteSel = null;
    UsuarioResponseDTO tecnicoSel = null;

    if (clienteId != null && clienteId > 0) {
      clienteSel = buscarClienteEnLista(clienteId);
      if (clienteSel != null) {
        ClienteRequestDTO c = new ClienteRequestDTO();
        c.setIdCliente(clienteSel.getIdCliente());
        orden.setFkCliente(c);
      }
    }

    if (tecnicoId != null && tecnicoId > 0) {
      tecnicoSel = buscarTecnicoEnLista(tecnicoId);
      if (tecnicoSel != null) {
        UsuarioRequestDTO u = new UsuarioRequestDTO();
        u.setIdUsuario(tecnicoSel.getIdUsuario());
        orden.setFkUsuario(u);
      }
    }

    model.addAttribute("orden", orden);
    model.addAttribute("clienteSeleccionado", clienteSel);
    model.addAttribute("tecnicoSeleccionado", tecnicoSel);

    model.addAttribute("modoEditar", false);
    model.addAttribute("returnToCliente", "/ordenes/nuevo");

    return "/orden/nuevaorden";
  }

  @GetMapping("/editar")
  public String editar(
      @RequestParam("idOrden") int idOrden,
      @RequestParam(value = "clienteId", required = false) Integer clienteId,
      @RequestParam(value = "tecnicoId", required = false) Integer tecnicoId,
      Model model,
      RedirectAttributes ra
  ) {
    cargarCombos(model);

    OrdenResponseDTO actual;
    try {
      actual = ordenServicio.buscarPorId(idOrden);
    } catch (Exception e) {
      ra.addFlashAttribute("error", "No se encontró la orden para editar");
      return "redirect:/ordenes";
    }

    if (actual == null) {
      ra.addFlashAttribute("error", "No se encontró la orden para editar");
      return "redirect:/ordenes";
    }

    OrdenRequestDTO orden = new OrdenRequestDTO();
    orden.setIdOrden(actual.getIdOrden());
    orden.setFechaIngreso(actual.getFechaIngreso());
    orden.setFechaSalida(actual.getFechaSalida());
    orden.setDetalleProblema(actual.getDetalleProblema());
    orden.setObservaciones(actual.getObservaciones());
    orden.setTotalCobro(actual.getTotalCobro());
    orden.setPagado(actual.isPagado());
    orden.setEstadoOrden(actual.getEstadoOrden());
    orden.setCodigoOrden("ORD-" + actual.getIdOrden());

    int clienteFinal = (clienteId != null && clienteId > 0)
      ? clienteId
      : (actual.getFkCliente() != null ? actual.getFkCliente().getIdCliente() : 0);

    ClienteResponseDTO clienteSel = null;
    if (clienteFinal > 0) {
      clienteSel = buscarClienteEnLista(clienteFinal);
      if (clienteSel != null) {
        ClienteRequestDTO c = new ClienteRequestDTO();
        c.setIdCliente(clienteSel.getIdCliente());
        orden.setFkCliente(c);
      }
    }

    int tecnicoFinal = (tecnicoId != null && tecnicoId > 0)
      ? tecnicoId
      : (actual.getFkUsuario() != null ? actual.getFkUsuario().getIdUsuario() : 0);

    UsuarioResponseDTO tecnicoSel = null;
    if (tecnicoFinal > 0) {
      tecnicoSel = buscarTecnicoEnLista(tecnicoFinal);
      if (tecnicoSel != null) {
        UsuarioRequestDTO u = new UsuarioRequestDTO();
        u.setIdUsuario(tecnicoSel.getIdUsuario());
        orden.setFkUsuario(u);
      }
    }

    model.addAttribute("orden", orden);
    model.addAttribute("clienteSeleccionado", clienteSel);
    model.addAttribute("tecnicoSeleccionado", tecnicoSel);

    model.addAttribute("modoEditar", true);
    model.addAttribute("returnToCliente", "/ordenes/editar?idOrden=" + idOrden);

    return "/orden/nuevaorden";
  }

  @PostMapping("/guardar")
  public String guardarOrden(@ModelAttribute("orden") OrdenRequestDTO dto, RedirectAttributes ra) {

    if (dto.getFkCliente() == null || dto.getFkCliente().getIdCliente() <= 0) {
      ra.addFlashAttribute("error", "Selecciona un cliente");
      return "redirect:/ordenes/nuevo";
    }

    if (dto.getFkUsuario() == null || dto.getFkUsuario().getIdUsuario() <= 0) {
      ra.addFlashAttribute("error", "Selecciona un técnico");
      return "redirect:/ordenes/nuevo";
    }

    try {
      if (dto.getIdOrden() > 0) {
        ordenServicio.actualizarOrden(dto.getIdOrden(), dto);
        ra.addFlashAttribute("msg", "Orden actualizada correctamente");
      } else {
        if (dto.getCodigoOrden() == null || dto.getCodigoOrden().isBlank()) {
          dto.setCodigoOrden("ORD-" + System.currentTimeMillis());
        }
        ordenServicio.crearOrden(dto);
        ra.addFlashAttribute("msg", "Orden creada correctamente");
      }
    } catch (WebClientResponseException ex) {
      ra.addFlashAttribute("error", "Error guardando la orden, " + ex.getStatusCode());
      if (dto.getIdOrden() > 0) return "redirect:/ordenes/editar?idOrden=" + dto.getIdOrden();
      return "redirect:/ordenes/nuevo";
    } catch (Exception e) {
      ra.addFlashAttribute("error", "Error guardando la orden");
      if (dto.getIdOrden() > 0) return "redirect:/ordenes/editar?idOrden=" + dto.getIdOrden();
      return "redirect:/ordenes/nuevo";
    }

    return "redirect:/ordenes";
  }

  @GetMapping("/eliminar")
  public String eliminar(@RequestParam("idOrden") int idOrden, RedirectAttributes ra) {
    try {
      ordenServicio.eliminarOrden(idOrden);
      ra.addFlashAttribute("msg", "Orden eliminada");
    } catch (WebClientResponseException ex) {
      if (ex.getStatusCode().value() == 409) {
        ra.addFlashAttribute("error", "No se puede eliminar la orden, tiene registros asociados, por ejemplo equipos");
      } else {
        ra.addFlashAttribute("error", "No se pudo eliminar la orden, " + ex.getStatusCode());
      }
    } catch (Exception e) {
      ra.addFlashAttribute("error", "No se pudo eliminar la orden");
    }
    return "redirect:/ordenes";
  }

  private void cargarCombos(Model model) {
    model.addAttribute("listarCliente", clienteServicio.listarCliente());
    model.addAttribute("listarUsuario", usuarioServicio.listarUsuario());
  }

  private ClienteResponseDTO buscarClienteEnLista(int idCliente) {
    for (ClienteResponseDTO c : clienteServicio.listarCliente()) {
      if (c.getIdCliente() == idCliente) return c;
    }
    return null;
  }

  private UsuarioResponseDTO buscarTecnicoEnLista(int idUsuario) {
    for (UsuarioResponseDTO u : usuarioServicio.listarUsuario()) {
      if (u.getIdUsuario() == idUsuario) return u;
    }
    return null;
  }

@PostMapping("/guardar-continuar")
public String guardarYContinuar(@ModelAttribute("orden") OrdenRequestDTO dto, RedirectAttributes ra) {

 if (dto.getFkCliente() == null || dto.getFkCliente().getIdCliente() <= 0) {
   ra.addFlashAttribute("error", "Selecciona un cliente");
   return "redirect:/ordenes/nuevo";
 }

 if (dto.getFkUsuario() == null || dto.getFkUsuario().getIdUsuario() <= 0) {
   ra.addFlashAttribute("error", "Selecciona un técnico");
   return "redirect:/ordenes/nuevo";
 }

 try {
   if (dto.getIdOrden() > 0) {
     ordenServicio.actualizarOrden(dto.getIdOrden(), dto);
     ra.addFlashAttribute("msg", "Orden actualizada correctamente");
     return "redirect:/ordenes";
   }

   if (dto.getCodigoOrden() == null || dto.getCodigoOrden().isBlank()) {
     dto.setCodigoOrden("ORD-" + System.currentTimeMillis());
   }

   OrdenResponseDTO creada = ordenServicio.crearOrden(dto);
   if (creada == null || creada.getIdOrden() <= 0) {
     ra.addFlashAttribute("error", "No se pudo crear la orden");
     return "redirect:/ordenes/nuevo";
   }

   ra.addFlashAttribute("msg", "Orden creada correctamente");
   return "redirect:/equipos/nuevo?ordenId=" + creada.getIdOrden();

 } catch (Exception e) {
   ra.addFlashAttribute("error", "Error guardando la orden");
   return "redirect:/ordenes/nuevo";
 }
}

}
