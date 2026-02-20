package com.uisrael.clienteconsumo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uisrael.clienteconsumo.model.dto.request.DiagnosticoRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.DiagnosticoResponseDTO;
import com.uisrael.clienteconsumo.service.IDiagnosticoServicio;
import com.uisrael.clienteconsumo.service.IOrdenInternaServicio;
import com.uisrael.clienteconsumo.service.IOrdenServicio;
import com.uisrael.clienteconsumo.service.IUsuarioServicio;

@Controller
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private IDiagnosticoServicio diagnosticoServicio;

    @Autowired
    private IOrdenInternaServicio ordenInternaServicio;

    @Autowired
    private IOrdenServicio ordenServicio;

    @Autowired
    private IUsuarioServicio usuarioServicio; 

    @GetMapping
    public String listar(Model model,
                         @RequestParam(required = false) String msg,
                         @RequestParam(required = false) String error) {

        List<DiagnosticoResponseDTO> resultado = diagnosticoServicio.listarDiagnostico();

        for (var d : resultado) {

            try {
                if (d.getIdOrden() != null && d.getIdOrden() > 0) {
                    var ord = ordenServicio.buscarPorId(d.getIdOrden());
                    if (ord != null && ord.getEstadoOrden() != null) {
                        d.setEstadoOrden(ord.getEstadoOrden());
                    }
                }
            } catch (Exception e) {}

            try {
                if ((d.getTecnicoNombre() == null || d.getTecnicoNombre().isBlank())
                        && d.getTecnicoId() > 0) {

                    var u = usuarioServicio.buscarUsuarioPorId(d.getTecnicoId());
                    if (u != null) {
                        d.setTecnicoNombre(u.getNombre());
                        d.setTecnicoApellido(u.getApellido());
                    }
                }
            } catch (Exception e) {}
        }

        model.addAttribute("listadiagnostico", resultado);
        model.addAttribute("msg", msg);
        model.addAttribute("error", error);

        return "orden/listardiagnostico";
    }

    @GetMapping("/nuevo")
    public String crear(Model model,
                        @RequestParam(required = false) String error) {

        var disponibles = ordenInternaServicio.listarDisponibles();

        try {
            for (var o : disponibles) {
                if ((o.getTecnicoNombre() == null || o.getTecnicoNombre().isBlank())
                        && o.getTecnicoId() != null && o.getTecnicoId() > 0) {

                    var u = usuarioServicio.buscarUsuarioPorId(o.getTecnicoId());
                    if (u != null) {
                        o.setTecnicoNombre(u.getNombre());
                        o.setTecnicoApellido(u.getApellido());
                    }
                }
            }
        } catch (Exception e) {}

        model.addAttribute("listaOrdenInternaDisponible", disponibles);
        model.addAttribute("diagnostico", new DiagnosticoRequestDTO());

        model.addAttribute("idOrdenInternaEdit", null);
        model.addAttribute("tecnicoIdEdit", null);
        model.addAttribute("textoOrdenEdit", null);

        model.addAttribute("error", error);

        return "orden/nuevodiagnostico";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam(name = "idOrdenInterna", required = false) String idOrdenInternaStr,
                          @RequestParam(name = "tecnicoId", required = false) String tecnicoIdStr,
                          @RequestParam String diagnostico,
                          @RequestParam(required = false) String observaciones) {

        Integer idOrdenInterna = parseIdSeguro(idOrdenInternaStr);
        if (idOrdenInterna == null || idOrdenInterna <= 0) {
            return "redirect:/diagnosticos/nuevo?error=Seleccione+una+orden";
        }

        Integer tecnicoId = parseIdSeguro(tecnicoIdStr);

        try {
            DiagnosticoRequestDTO dto = new DiagnosticoRequestDTO();
            dto.setTecnicoId(tecnicoId != null ? tecnicoId : 0);
            dto.setEstadoId(0);
            dto.setDiagnostico(diagnostico);
            dto.setObservaciones(observaciones);
            dto.setCreadoPor(null);

            diagnosticoServicio.guardarDiagnostico(idOrdenInterna, dto);

            return "redirect:/diagnosticos?msg=Guardado+correcto";
        } catch (Exception e) {
            return "redirect:/diagnosticos/nuevo?error=No+se+pudo+guardar";
        }
    }

    @GetMapping("/editar")
    public String editar(@RequestParam String idOrdenInterna, Model model,
                         @RequestParam(required = false) String error) {

        Integer id = parseIdSeguro(idOrdenInterna);
        if (id == null || id <= 0) return "redirect:/diagnosticos?error=Id+invalido";

        DiagnosticoResponseDTO encontrado = diagnosticoServicio.buscarPorId(id);
        if (encontrado == null) return "redirect:/diagnosticos?error=No+encontrado";

        String tecNombre = encontrado.getTecnicoNombre();
        String tecApellido = encontrado.getTecnicoApellido();

        try {
            if ((tecNombre == null || tecNombre.isBlank()) && encontrado.getTecnicoId() > 0) {
                var u = usuarioServicio.buscarUsuarioPorId(encontrado.getTecnicoId());
                if (u != null) {
                    tecNombre = u.getNombre();
                    tecApellido = u.getApellido();
                }
            }
        } catch (Exception e) {}

        DiagnosticoRequestDTO dto = new DiagnosticoRequestDTO();
        dto.setDiagnostico(encontrado.getDiagnostico());
        dto.setObservaciones(encontrado.getObservaciones());
        dto.setCreadoPor(encontrado.getCreadoPor());
        dto.setTecnicoId(encontrado.getTecnicoId());
        dto.setEstadoId(encontrado.getEstadoId());

        model.addAttribute("diagnostico", dto);
        model.addAttribute("idOrdenInternaEdit", id);
        model.addAttribute("tecnicoIdEdit", encontrado.getTecnicoId());
        model.addAttribute("textoOrdenEdit", encontrado.getTextoOrden());
        model.addAttribute("tecnicoNombreEdit", tecNombre);
        model.addAttribute("tecnicoApellidoEdit", tecApellido);
        model.addAttribute("error", error);

        return "orden/nuevodiagnostico";
    }

    @PostMapping("/actualizar")
    public String actualizar(@RequestParam(name = "idOrdenInterna", required = false) String idOrdenInternaStr,
                             @RequestParam(name = "tecnicoId", required = false) String tecnicoIdStr,
                             @RequestParam String diagnostico,
                             @RequestParam(required = false) String observaciones) {

        Integer idOrdenInterna = parseIdSeguro(idOrdenInternaStr);
        if (idOrdenInterna == null || idOrdenInterna <= 0) {
            return "redirect:/diagnosticos?error=Id+invalido";
        }

        Integer tecnicoId = parseIdSeguro(tecnicoIdStr);

        try {
            DiagnosticoRequestDTO dto = new DiagnosticoRequestDTO();
            dto.setTecnicoId(tecnicoId != null ? tecnicoId : 0);
            dto.setEstadoId(0);
            dto.setDiagnostico(diagnostico);
            dto.setObservaciones(observaciones);
            dto.setCreadoPor(null);

            diagnosticoServicio.actualizarDiagnostico(idOrdenInterna, dto);

            return "redirect:/diagnosticos?msg=Actualizado+correcto";
        } catch (Exception e) {
            return "redirect:/diagnosticos?error=No+se+pudo+actualizar";
        }
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam String idOrdenInterna) {

        Integer id = parseIdSeguro(idOrdenInterna);
        if (id == null || id <= 0) return "redirect:/diagnosticos?error=Id+invalido";

        try {
            diagnosticoServicio.eliminarDiagnostico(id);
            return "redirect:/diagnosticos?msg=Eliminado+correcto";
        } catch (Exception e) {
            return "redirect:/diagnosticos?error=No+se+pudo+eliminar";
        }
    }

    private Integer parseIdSeguro(String raw) {
        if (raw == null) return null;
        String clean = raw.trim();
        if (clean.isBlank()) return null;
        clean = clean.replace(",", "").trim();
        try { return Integer.parseInt(clean); } catch (Exception e) { return null; }
    }
} 