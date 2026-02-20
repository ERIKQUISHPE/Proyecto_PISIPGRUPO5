package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionMaterialJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.MaterialJpa;
import com.uisrael.proyectoapi.infraestructura.repositorios.IAccionReparacionMaterialJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IAccionReparacionJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IMaterialJpaRepositorio;
import com.uisrael.proyectoapi.presentacion.dto.request.AccionReparacionMaterialRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.AccionReparacionMaterialResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accionReparacionMaterial")
public class AccionReparacionMaterialControlador {

    private final IAccionReparacionMaterialJpaRepositorio armRepo;
    private final IAccionReparacionJpaRepositorio accionRepo;
    private final IMaterialJpaRepositorio materialRepo;

    public AccionReparacionMaterialControlador(
            IAccionReparacionMaterialJpaRepositorio armRepo,
            IAccionReparacionJpaRepositorio accionRepo,
            IMaterialJpaRepositorio materialRepo) {

        this.armRepo = armRepo;
        this.accionRepo = accionRepo;
        this.materialRepo = materialRepo;
    }

    @GetMapping("/porAccion/{idAccion}")
    public List<AccionReparacionMaterialResponseDTO> listarPorAccion(@PathVariable int idAccion) {

        return armRepo.findByFkAccion_IdAccion(idAccion)
                .stream()
                .map(this::toResponse)
                .toList();
    }
    
    @GetMapping("/porOrden/{idOrden}")
    public List<AccionReparacionMaterialResponseDTO> listarPorOrden(@PathVariable int idOrden) {

        return armRepo.findByFkAccion_FkOrden_IdOrden(idOrden)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccionReparacionMaterialResponseDTO crear(
            @Valid @RequestBody AccionReparacionMaterialRequestDTO dto) {

        AccionReparacionJpa accion = accionRepo.findById(dto.getIdAccion())
                .orElseThrow(() -> new RuntimeException("Acción reparación no encontrada"));

        MaterialJpa material = materialRepo.findById(dto.getIdMaterial())
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));

        AccionReparacionMaterialJpa nuevo = new AccionReparacionMaterialJpa();
        nuevo.setFkAccion(accion);
        nuevo.setFkMaterial(material);
        nuevo.setCantidad(dto.getCantidad());
        nuevo.setCostoCompra(material.getCostoCompra());
        nuevo.setCostoVenta(material.getCostoVenta());

        AccionReparacionMaterialJpa guardado = armRepo.save(nuevo);

        return toResponse(guardado);
    }

    private AccionReparacionMaterialResponseDTO toResponse(AccionReparacionMaterialJpa e) {

        AccionReparacionMaterialResponseDTO r = new AccionReparacionMaterialResponseDTO();

        r.setIdAccionMaterial(e.getIdAccionMaterial());
        r.setIdAccion(e.getFkAccion() != null ? e.getFkAccion().getIdAccion() : null);
        r.setIdMaterial(e.getFkMaterial() != null ? e.getFkMaterial().getIdMaterial() : null);
        r.setCantidad(e.getCantidad());
        r.setCostoCompra(e.getCostoCompra());
        r.setCostoVenta(e.getCostoVenta());

        if (e.getFkMaterial() != null) {
            r.setMaterialCodigo(e.getFkMaterial().getCodigoMaterial());
            r.setMaterialNombre(e.getFkMaterial().getNombre());
        }

        return r;
    }


}
