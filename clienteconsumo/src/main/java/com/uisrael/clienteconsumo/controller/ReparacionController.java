package com.uisrael.clienteconsumo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uisrael.clienteconsumo.model.dto.request.AccionReparacionMaterialRequestDTO;
import com.uisrael.clienteconsumo.model.dto.request.ReparacionRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.ReparacionResponseDTO;
import com.uisrael.clienteconsumo.service.IAccionReparacionMaterialServicio;
import com.uisrael.clienteconsumo.service.IMaterialServicio;
import com.uisrael.clienteconsumo.service.IOrdenInternaServicio;
import com.uisrael.clienteconsumo.service.IOrdenServicio;
import com.uisrael.clienteconsumo.service.IReparacionServicio;
import com.uisrael.clienteconsumo.service.IUsuarioServicio;

@Controller
@RequestMapping("/reparaciones")
public class ReparacionController {

    public static class MaterialEditDTO {
        private Integer idMaterial;
        private String nombre;
        private Integer cantidad;

        public MaterialEditDTO() {}

        public MaterialEditDTO(Integer idMaterial, String nombre, Integer cantidad) {
            this.idMaterial = idMaterial;
            this.nombre = nombre;
            this.cantidad = cantidad;
        }

        public Integer getIdMaterial() { return idMaterial; }
        public void setIdMaterial(Integer idMaterial) { this.idMaterial = idMaterial; }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public Integer getCantidad() { return cantidad; }
        public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    }

    @Autowired
    private IReparacionServicio reparacionServicio;

    @Autowired
    private IOrdenServicio ordenServicio;

    @Autowired
    private IOrdenInternaServicio ordenInternaServicio;

    @Autowired
    private IMaterialServicio materialServicio;

    @Autowired
    private IAccionReparacionMaterialServicio accionReparacionMaterialServicio;

    @Autowired
    private IUsuarioServicio usuarioServicio;

    @GetMapping
    public String listar(Model model) {

        List<ReparacionResponseDTO> lista = reparacionServicio.listarReparacion();

        var materiales = materialServicio.listarMaterial();
        var usuarios = usuarioServicio.listarUsuario();

        for (var r : lista) {

            try {
                if (r.getIdOrden() != null && r.getIdOrden() > 0) {
                    var ord = ordenServicio.buscarPorId(r.getIdOrden());
                    if (ord != null) {
                        r.setEstadoOrden(ord.getEstadoOrden());

                        if (r.getTextoOrden() == null || r.getTextoOrden().isBlank()) {
                            if (ord.getCodigoOrden() != null && !ord.getCodigoOrden().isBlank()) {
                                r.setTextoOrden(ord.getIdOrden() + " - " + ord.getCodigoOrden());
                            } else {
                                r.setTextoOrden("Orden #" + ord.getIdOrden());
                            }
                        }
                    }
                }
            } catch (Exception e) { }

            try {
                if (r.getIdAccion() > 0) {

                    var dets = accionReparacionMaterialServicio.listarPorAccion(r.getIdAccion());

                    if (dets != null && !dets.isEmpty()) {

                        StringBuilder sb = new StringBuilder();

                        for (int i = 0; i < dets.size(); i++) {

                            var d = dets.get(i);

                            Integer idMat = d.getIdMaterial();
                            Integer cant = d.getCantidad();

                            if (idMat == null || idMat <= 0) continue;
                            if (cant == null || cant <= 0) cant = 1;

                            String nombre = "Material ID " + idMat;

                            if (materiales != null) {
                                for (var m : materiales) {
                                    if (m != null && m.getIdMaterial() == idMat) {
                                        nombre = m.getNombre();
                                        break;
                                    }
                                }
                            }

                            if (sb.length() > 0) sb.append(", ");
                            sb.append(nombre).append(" x").append(cant);
                        }

                        String texto = sb.toString().trim();
                        r.setMaterialNombre(texto.isEmpty() ? "Sin material" : texto);

                    } else {
                        r.setMaterialNombre("Sin material");
                    }

                } else {
                    r.setMaterialNombre("Sin material");
                }
            } catch (Exception e) {
                r.setMaterialNombre("Sin material");
            }

            try {
                if (r.getTecnicoId() > 0 && usuarios != null && !usuarios.isEmpty()) {
                    var u = usuarios.stream()
                            .filter(x -> x.getIdUsuario() != null && x.getIdUsuario() == r.getTecnicoId())
                            .findFirst()
                            .orElse(null);

                    if (u != null) {
                        r.setTecnicoNombre(u.getNombre());
                        r.setTecnicoApellido(u.getApellido());
                    }
                }
            } catch (Exception e) { }
        }

        model.addAttribute("listareparaciones", lista);
        return "orden/listarreparacion";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model,
                        @RequestParam(required = false) String msg) {

        var disponibles = ordenInternaServicio.listarParaReparacion();
        if (disponibles == null || disponibles.isEmpty()) {
            disponibles = ordenInternaServicio.listarDisponibles();
        }

        var filtradas = disponibles.stream()
                .filter(oi -> oi.getIdOrden() != null && oi.getIdOrden() > 0)
                .filter(oi -> {
                    try {
                        var ord = ordenServicio.buscarPorId(oi.getIdOrden());
                        return ord != null
                                && ord.getEstadoOrden() != null
                                && ord.getEstadoOrden().trim().equalsIgnoreCase("EN PROCESO");
                    } catch (Exception e) {
                        return false;
                    }
                })
                .toList();

        try {
            for (var o : filtradas) {
                if ((o.getTecnicoNombre() == null || o.getTecnicoNombre().isBlank())
                        && o.getTecnicoId() != null && o.getTecnicoId() > 0) {

                    var u = usuarioServicio.buscarUsuarioPorId(o.getTecnicoId());
                    if (u != null) {
                        o.setTecnicoNombre(u.getNombre());
                        o.setTecnicoApellido(u.getApellido());
                    }
                }
            }
        } catch (Exception e) { }

        model.addAttribute("listaOrdenInternaDisponible", filtradas);
        model.addAttribute("reparacion", new ReparacionRequestDTO());
        model.addAttribute("listamateriales", materialServicio.listarMaterial());

        model.addAttribute("idAccionEdit", null);
        model.addAttribute("textoOrdenEdit", null);
        model.addAttribute("tecnicoIdEdit", null);

        model.addAttribute("msg", msg);

        model.addAttribute("tecnicoNombreEdit", null);
        model.addAttribute("tecnicoApellidoEdit", null);

        model.addAttribute("materialesEdit", List.of());

        return "orden/nuevareparacion";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam("idOrdenInterna") Integer idOrdenInterna,
                          @RequestParam("descripcion") String descripcion,
                          @RequestParam(name = "materialId", required = false) List<Integer> materialIds,
                          @RequestParam(name = "cantidad", required = false) List<Integer> cantidades) {

        if (idOrdenInterna == null || idOrdenInterna <= 0) {
            return "redirect:/reparaciones/nuevo?msg=Seleccione+una+orden+válida";
        }

        if (descripcion == null || descripcion.trim().isBlank()) {
            return "redirect:/reparaciones/nuevo?msg=Ingrese+la+acción+realizada";
        }

        var oi = ordenInternaServicio.buscarPorId(idOrdenInterna);
        if (oi == null) {
            return "redirect:/reparaciones/nuevo?msg=No+se+encontró+la+orden+interna";
        }

        if (oi.getIdOrden() == null || oi.getIdOrden() <= 0) {
            return "redirect:/reparaciones/nuevo?msg=La+orden+interna+no+tiene+orden+asociada";
        }

        if (oi.getTecnicoId() == null || oi.getTecnicoId() <= 0) {
            return "redirect:/reparaciones/nuevo?msg=La+orden+interna+no+tiene+técnico";
        }

        Integer idOrden = oi.getIdOrden();

        ReparacionRequestDTO dto = new ReparacionRequestDTO();
        dto.setIdOrden(idOrden);
        dto.setTecnicoId(oi.getTecnicoId());
        dto.setDescripcion(descripcion.trim());
        dto.setFechaAccion(null);
        dto.setIdMaterial(null);

        Integer idAccionObjetivo = null;

        try {
            List<ReparacionResponseDTO> reps = reparacionServicio.listarReparacion();
            for (int i = reps.size() - 1; i >= 0; i--) {
                var r = reps.get(i);
                if (r.getIdOrden() != null && r.getIdOrden().equals(idOrden)) {
                    idAccionObjetivo = r.getIdAccion();
                    break;
                }
            }
        } catch (Exception e) { }

        if (idAccionObjetivo != null && idAccionObjetivo > 0) {
            try { reparacionServicio.actualizarReparacion(idAccionObjetivo, dto); } catch (Exception e) { }
            try { accionReparacionMaterialServicio.eliminarPorAccion(idAccionObjetivo); } catch (Exception e) { }
        } else {
            reparacionServicio.crearReparacion(dto);
            try {
                List<ReparacionResponseDTO> reps = reparacionServicio.listarReparacion();
                for (int i = reps.size() - 1; i >= 0; i--) {
                    var r = reps.get(i);
                    if (r.getIdOrden() != null && r.getIdOrden().equals(idOrden)) {
                        idAccionObjetivo = r.getIdAccion();
                        break;
                    }
                }
            } catch (Exception e) { }
        }

        if (idAccionObjetivo != null && idAccionObjetivo > 0) {

            List<Integer> mats = (materialIds != null) ? materialIds : new ArrayList<>();
            List<Integer> cants = (cantidades != null) ? cantidades : new ArrayList<>();

            int n = Math.min(mats.size(), cants.size());

            for (int i = 0; i < n; i++) {
                Integer idMat = mats.get(i);
                Integer cant = cants.get(i);

                if (idMat == null || idMat <= 0) continue;
                if (cant == null || cant <= 0) cant = 1;

                AccionReparacionMaterialRequestDTO det = new AccionReparacionMaterialRequestDTO();
                det.setIdAccion(idAccionObjetivo);
                det.setIdMaterial(idMat);
                det.setCantidad(cant);

                try { accionReparacionMaterialServicio.crearDetalle(det); } catch (Exception e) { }
            }
        }

        try { ordenServicio.cambiarEstadoOrden(idOrden, "FINALIZADO"); } catch (Exception e) { }

        return "redirect:/reparaciones";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("idAccion") int idAccion, Model model) {

        ReparacionResponseDTO encontrado = reparacionServicio.buscarPorId(idAccion);
        if (encontrado == null) return "redirect:/reparaciones";

        String textoOrden = encontrado.getTextoOrden();

        if (textoOrden == null || textoOrden.isBlank()) {
            try {
                if (encontrado.getIdOrden() != null && encontrado.getIdOrden() > 0) {
                    var ord = ordenServicio.buscarPorId(encontrado.getIdOrden());
                    if (ord != null) {
                        if (ord.getCodigoOrden() != null && !ord.getCodigoOrden().isBlank()) {
                            textoOrden = ord.getIdOrden() + " - " + ord.getCodigoOrden();
                        } else {
                            textoOrden = "Orden #" + ord.getIdOrden();
                        }
                    }
                }
            } catch (Exception e) { }
        }

        if (textoOrden == null || textoOrden.isBlank()) {
            textoOrden = (encontrado.getIdOrden() != null && encontrado.getIdOrden() > 0)
                    ? ("Orden #" + encontrado.getIdOrden())
                    : "Orden seleccionada";
        }

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
        } catch (Exception e) { }

        ReparacionRequestDTO dto = new ReparacionRequestDTO();
        dto.setIdOrden(encontrado.getIdOrden());
        dto.setTecnicoId(encontrado.getTecnicoId());
        dto.setDescripcion(encontrado.getDescripcion());
        dto.setFechaAccion(encontrado.getFechaAccion());
        dto.setIdMaterial(null);

        model.addAttribute("reparacion", dto);

        model.addAttribute("idAccionEdit", idAccion);
        model.addAttribute("idOrdenEdit", encontrado.getIdOrden());
        model.addAttribute("tecnicoIdEdit", encontrado.getTecnicoId());
        model.addAttribute("textoOrdenEdit", textoOrden);

        model.addAttribute("tecnicoNombreEdit", tecNombre);
        model.addAttribute("tecnicoApellidoEdit", tecApellido);

        var listaMats = materialServicio.listarMaterial();
        model.addAttribute("listamateriales", listaMats);

        List<?> dets;
        try {
            dets = accionReparacionMaterialServicio.listarPorAccion(idAccion);
            model.addAttribute("materialesUsados", dets);
        } catch (Exception e) {
            dets = List.of();
            model.addAttribute("materialesUsados", List.of());
        }

        List<MaterialEditDTO> materialesEdit = new ArrayList<>();
        try {
            if (dets != null && !dets.isEmpty()) {
                for (Object obj : dets) {

                    Integer idMaterial = null;
                    Integer cantidad = null;

                    try { idMaterial = (Integer) obj.getClass().getMethod("getIdMaterial").invoke(obj); } catch (Exception ex) { }
                    try { cantidad  = (Integer) obj.getClass().getMethod("getCantidad").invoke(obj); } catch (Exception ex) { }

                    if (idMaterial == null || idMaterial <= 0) continue;
                    if (cantidad == null || cantidad <= 0) cantidad = 1;

                    String nombre = "Material ID " + idMaterial;

                    try {
                        for (var m : listaMats) {
                            if (m.getIdMaterial() == idMaterial) {
                                nombre = m.getNombre();
                                break;
                            }
                        }
                    } catch (Exception ex) { }

                    materialesEdit.add(new MaterialEditDTO(idMaterial, nombre, cantidad));
                }
            }
        } catch (Exception e) { }

        model.addAttribute("materialesEdit", materialesEdit);

        return "orden/nuevareparacion";
    }

    @PostMapping("/actualizar")
    public String actualizar(@RequestParam("idAccion") int idAccion,
                             @RequestParam("descripcion") String descripcion,
                             @RequestParam(name = "materialId", required = false) List<Integer> materialIds,
                             @RequestParam(name = "cantidad", required = false) List<Integer> cantidades) {

        if (idAccion <= 0) return "redirect:/reparaciones";
        if (descripcion == null || descripcion.trim().isBlank()) return "redirect:/reparaciones";

        var actual = reparacionServicio.buscarPorId(idAccion);
        if (actual == null) return "redirect:/reparaciones";

        ReparacionRequestDTO dto = new ReparacionRequestDTO();
        dto.setIdOrden(actual.getIdOrden());
        dto.setTecnicoId(actual.getTecnicoId());
        dto.setDescripcion(descripcion.trim());
        dto.setFechaAccion(null);
        dto.setIdMaterial(null);

        reparacionServicio.actualizarReparacion(idAccion, dto);

        try { accionReparacionMaterialServicio.eliminarPorAccion(idAccion); } catch (Exception e) { }

        List<Integer> mats = (materialIds != null) ? materialIds : new ArrayList<>();
        List<Integer> cants = (cantidades != null) ? cantidades : new ArrayList<>();
        int n = Math.min(mats.size(), cants.size());

        for (int i = 0; i < n; i++) {
            Integer idMat = mats.get(i);
            Integer cant = cants.get(i);

            if (idMat == null || idMat <= 0) continue;
            if (cant == null || cant <= 0) cant = 1;

            AccionReparacionMaterialRequestDTO det = new AccionReparacionMaterialRequestDTO();
            det.setIdAccion(idAccion);
            det.setIdMaterial(idMat);
            det.setCantidad(cant);

            try { accionReparacionMaterialServicio.crearDetalle(det); } catch (Exception e) { }
        }

        return "redirect:/reparaciones";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("idAccion") int idAccion) {

        try {
            var rep = reparacionServicio.buscarPorId(idAccion);

            if (rep != null && rep.getIdOrden() != null && rep.getIdOrden() > 0) {
                try { accionReparacionMaterialServicio.eliminarPorAccion(idAccion); } catch (Exception e) { }

                ReparacionRequestDTO dto = new ReparacionRequestDTO();
                dto.setIdOrden(rep.getIdOrden());
                dto.setTecnicoId(rep.getTecnicoId());
                dto.setDescripcion("");
                dto.setFechaAccion(null);
                dto.setIdMaterial(null);

                try { reparacionServicio.actualizarReparacion(idAccion, dto); } catch (Exception e) { }
                try { ordenServicio.cambiarEstadoOrden(rep.getIdOrden(), "EN PROCESO"); } catch (Exception e) { }
            }

        } catch (Exception e) { }

        return "redirect:/reparaciones";
    }
}