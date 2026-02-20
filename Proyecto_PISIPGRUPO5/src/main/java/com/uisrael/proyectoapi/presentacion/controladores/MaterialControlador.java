package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IMaterialCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IProveedorCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Material;
import com.uisrael.proyectoapi.dominio.entidades.Proveedor;
import com.uisrael.proyectoapi.presentacion.dto.request.MaterialRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.MaterialResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IMaterialDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/material")
public class MaterialControlador {

    private final IMaterialCasoUso materialCasoUso;
    private final IProveedorCasoUso proveedorCasoUso;
    private final IMaterialDtoMapper mapper;

    public MaterialControlador(IMaterialCasoUso materialCasoUso, IProveedorCasoUso proveedorCasoUso,
			IMaterialDtoMapper mapper) {
		this.materialCasoUso = materialCasoUso;
		this.proveedorCasoUso = proveedorCasoUso;
		this.mapper = mapper;
	}

    @GetMapping
    public List<MaterialResponseDTO> listar() {
        return materialCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MaterialResponseDTO crear(@Valid @RequestBody MaterialRequestDTO request) {
        return mapper.toResponseDto(materialCasoUso.guardar(mapper.toDomain(request)));
    }

    @GetMapping("/{idMaterial}")
    public MaterialResponseDTO buscarPorId(@PathVariable int idMaterial) {
        return mapper.toResponseDto(materialCasoUso.buscarPorId(idMaterial));
    }

    @PutMapping("/{idMaterial}")
    public MaterialResponseDTO actualizar(@PathVariable int idMaterial,@Valid @RequestBody MaterialRequestDTO request) {

        Proveedor proveedor = proveedorCasoUso.buscarPorId(
                request.getFkProveedor().getIdProveedor()
        );
        Material dom = new Material(
                idMaterial,
                request.getCodigoMaterial(),
                request.getNombre(),
                request.getDescripcion(),
                request.getCostoCompra(),
                request.getCostoVenta(),
                request.getStock(),
                request.isEstado(),
                proveedor
        );
        return mapper.toResponseDto(materialCasoUso.guardar(dom));
    }

    @DeleteMapping("/{idMaterial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int idMaterial) {
        materialCasoUso.eliminar(idMaterial);
    }

}
