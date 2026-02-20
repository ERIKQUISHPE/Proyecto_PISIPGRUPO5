package com.uisrael.clienteconsumo.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uisrael.clienteconsumo.model.dto.request.PagoRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.AccionReparacionMaterialResponseDTO;
import com.uisrael.clienteconsumo.model.dto.response.OrdenResponseDTO;
import com.uisrael.clienteconsumo.model.dto.response.PagoResponseDTO;
import com.uisrael.clienteconsumo.model.dto.response.ReparacionResponseDTO;
import com.uisrael.clienteconsumo.service.IAccionReparacionMaterialServicio;
import com.uisrael.clienteconsumo.service.IOrdenServicio;
import com.uisrael.clienteconsumo.service.IPagoServicio;
import com.uisrael.clienteconsumo.service.IReparacionServicio;

@Controller
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private IPagoServicio pagoServicio;

    @Autowired
    private IOrdenServicio ordenServicio;

    @Autowired
    private IAccionReparacionMaterialServicio accionReparacionMaterialServicio;

    @Autowired
    private IReparacionServicio reparacionServicio;

    @GetMapping
    public String listar(Model model) {

        List<PagoResponseDTO> pagos = pagoServicio.listarPago();
        List<OrdenResponseDTO> ordenes = ordenServicio.listarOrden();

        java.util.Map<Integer, OrdenResponseDTO> ordenMap = new java.util.HashMap<>();
        for (OrdenResponseDTO o : ordenes) {
            ordenMap.put(o.getIdOrden(), o);
        }

        List<ReparacionResponseDTO> reparaciones = reparacionServicio.listarReparacion();

        java.util.Map<Integer, String> accionesMap = new java.util.HashMap<>();

        for (PagoResponseDTO p : pagos) {
            Integer idOrden = p.getIdOrden();
            if (idOrden == null) continue;

            String texto = reparaciones.stream()
                .filter(r -> r.getIdOrden() != null && r.getIdOrden().intValue() == idOrden.intValue())
                .map(r -> {
                    if (r.getAccionRealizada() != null && !r.getAccionRealizada().isBlank()) return r.getAccionRealizada();
                    if (r.getDescripcion() != null && !r.getDescripcion().isBlank()) return r.getDescripcion();
                    return "ACCIÓN";
                })
                .distinct()
                .reduce((a,b) -> a + ", " + b)
                .orElse("SIN ACCIONES");

            accionesMap.put(idOrden, texto);
        }

        model.addAttribute("listapago", pagos);
        model.addAttribute("ordenMap", ordenMap);
        model.addAttribute("accionesMap", accionesMap);

        return "orden/listarpago";
    }

    @GetMapping("/acciones/{idOrden}")
    @ResponseBody
    public List<ReparacionResponseDTO> accionesPorOrden(@PathVariable int idOrden) {
        return reparacionServicio.listarReparacion()
                .stream()
                .filter(r -> r.getIdOrden() != null && r.getIdOrden().intValue() == idOrden)
                .toList();
    }

    @GetMapping("/nuevo")
    public String crear(Model model) {

        List<PagoResponseDTO> pagos = pagoServicio.listarPago();
        Set<Integer> ordenesYaPagadas = new HashSet<>();

        for (PagoResponseDTO p : pagos) {
            if (p.getIdOrden() != null) {
                ordenesYaPagadas.add(p.getIdOrden());
            }
        }

        var ordenesFinalizadasNoPagadas = ordenServicio.listarOrden()
                .stream()
                .filter(o -> o.getEstadoOrden() != null && o.getEstadoOrden().toUpperCase().contains("FINALIZ"))
                .filter(o -> !ordenesYaPagadas.contains(o.getIdOrden()))
                .toList();

        model.addAttribute("listaorden", ordenesFinalizadasNoPagadas);
        model.addAttribute("pago", new PagoRequestDTO());

        model.addAttribute("modoEditar", false);

        System.out.println("PAGOS SIZE = " + pagos.size());
        pagos.forEach(p -> System.out.println(
            "PAGO idPago=" + p.getIdPago() +
            ", idOrden=" + p.getIdOrden() +
            ", codigoOrden=" + p.getCodigoOrden() +
            ", textoOrden=" + p.getTextoOrden()
        ));

        return "orden/nuevopago";
    }

    @GetMapping("/materiales/{idOrden}")
    @ResponseBody
    public List<AccionReparacionMaterialResponseDTO> materialesPorOrden(@PathVariable int idOrden) {
        return accionReparacionMaterialServicio.listarPorOrden(idOrden);
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam(required = false) Integer idPago,
                          @RequestParam Integer idOrden,
                          @RequestParam String metodoPago,
                          @RequestParam(required = false) BigDecimal manoObra,
                          @RequestParam BigDecimal totalCobrar,
                          RedirectAttributes ra) {

        try {

            if (idPago != null && idPago > 0) {

                PagoResponseDTO actual = pagoServicio.buscarPorId(idPago);
                if (actual == null) {
                    ra.addFlashAttribute("error", "No se encontró el pago para actualizar");
                    return "redirect:/pagos";
                }

                PagoRequestDTO dto = new PagoRequestDTO();
                dto.setIdPago(idPago);
                dto.setIdOrden(idOrden);
                dto.setMetodoPago(metodoPago);

                dto.setMonto(totalCobrar);

                dto.setFechaPago(actual.getFechaPago());
                dto.setRegistradoPor(actual.getRegistradoPor());

                pagoServicio.actualizarPago(idPago, dto);

                ra.addFlashAttribute("msg", "Pago actualizado correctamente");
                return "redirect:/pagos";
            }

            List<PagoResponseDTO> pagos = pagoServicio.listarPago();
            boolean yaPagada = pagos.stream()
                    .anyMatch(p -> p.getIdOrden() != null && p.getIdOrden().equals(idOrden));

            if (yaPagada) {
                ra.addFlashAttribute("error", "Esa orden ya fue cobrada, solo se puede editar o eliminar el pago");
                return "redirect:/pagos/nuevo";
            }

            PagoRequestDTO dto = new PagoRequestDTO();
            dto.setIdOrden(idOrden);
            dto.setMetodoPago(metodoPago);
            dto.setMonto(totalCobrar);
            dto.setFechaPago(LocalDateTime.now());
            dto.setRegistradoPor(1);

            pagoServicio.crearPago(dto);
            ra.addFlashAttribute("msg", "Pago guardado correctamente");
            return "redirect:/pagos";

        } catch (Exception ex) {
            ra.addFlashAttribute("error", "No se pudo guardar el pago, " + ex.getMessage());
            if (idPago != null && idPago > 0) return "redirect:/pagos/editar/" + idPago;
            return "redirect:/pagos/nuevo";
        }
    }

    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, RedirectAttributes ra) {

        try {
            PagoResponseDTO pagoActual = pagoServicio.buscarPorId(id);

            if (pagoActual == null) {
                ra.addFlashAttribute("error", "No se encontró el pago a eliminar");
                return "redirect:/pagos";
            }

            pagoServicio.eliminarPago(id);

            ra.addFlashAttribute("msg", "Pago eliminado correctamente");
            return "redirect:/pagos";

        } catch (Exception e) {
            ra.addFlashAttribute("error", "No se pudo eliminar el pago, " + e.getMessage());
            return "redirect:/pagos";
        }
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model, RedirectAttributes ra) {

        try {
            PagoResponseDTO pagoActual = pagoServicio.buscarPorId(id);

            if (pagoActual == null) {
                ra.addFlashAttribute("error", "No se encontró el pago");
                return "redirect:/pagos";
            }

            List<OrdenResponseDTO> todasLasOrdenes = ordenServicio.listarOrden();

            List<OrdenResponseDTO> ordenesFinalizadas = todasLasOrdenes.stream()
                    .filter(o -> o.getEstadoOrden() != null && o.getEstadoOrden().toUpperCase().contains("FINALIZ"))
                    .toList();

            if (pagoActual.getIdOrden() != null) {
                int idOrdenPago = pagoActual.getIdOrden();

                boolean existe = ordenesFinalizadas.stream()
                        .anyMatch(o -> o.getIdOrden() == idOrdenPago);

                if (!existe) {
                    OrdenResponseDTO ordenPago = todasLasOrdenes.stream()
                            .filter(o -> o.getIdOrden() == idOrdenPago)
                            .findFirst()
                            .orElse(null);

                    if (ordenPago != null) {
                        java.util.ArrayList<OrdenResponseDTO> tmp = new java.util.ArrayList<>(ordenesFinalizadas);
                        tmp.add(0, ordenPago);
                        ordenesFinalizadas = tmp;
                    }
                }
            }

            model.addAttribute("listaorden", ordenesFinalizadas);
            model.addAttribute("pagoEdit", pagoActual);
            model.addAttribute("modoEditar", true);

            return "orden/nuevopago";

        } catch (Exception e) {
            ra.addFlashAttribute("error", "No se pudo cargar el pago para editar");
            return "redirect:/pagos";
        }
    }
}