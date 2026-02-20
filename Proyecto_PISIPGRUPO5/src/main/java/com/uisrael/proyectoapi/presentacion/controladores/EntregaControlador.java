package com.uisrael.proyectoapi.presentacion.controladores;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IEntregaCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IUsuarioCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Entrega;
import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.dominio.entidades.Usuario;
import com.uisrael.proyectoapi.presentacion.dto.request.EntregaRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.EntregaResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IEntregaDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/entrega")
public class EntregaControlador {

    private final IEntregaCasoUso entregaCasoUso;
    private final IOrdenCasoUso ordenCasoUso;
    private final IUsuarioCasoUso usuarioCasoUso;
    private final IEntregaDtoMapper mapper;

    public EntregaControlador(IEntregaCasoUso entregaCasoUso, IOrdenCasoUso ordenCasoUso,
            IUsuarioCasoUso usuarioCasoUso, IEntregaDtoMapper mapper) {
        this.entregaCasoUso = entregaCasoUso;
        this.ordenCasoUso = ordenCasoUso;
        this.usuarioCasoUso = usuarioCasoUso;
        this.mapper = mapper;
    }

    @GetMapping
    public List<EntregaResponseDTO> listar() {
        return entregaCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaResponseDTO crear(@Valid @RequestBody EntregaRequestDTO request) {

        Orden orden = ordenCasoUso.obtenerPorId(request.getFkOrden().getIdOrden());

        Usuario entregadoPor = usuarioCasoUso.buscarPorId(request.getEntregadoPor().getIdUsuario());

        Entrega dom = new Entrega(
            0,
            entregadoPor,
            request.getRecibidoPor(),
            LocalDateTime.now(),
            request.getNotas(),
            orden
        );

        return mapper.toResponseDto(entregaCasoUso.guardar(dom));
    }

    @GetMapping("/{idEntrega}")
    public EntregaResponseDTO buscarPorId(@PathVariable int idEntrega) {
        return mapper.toResponseDto(entregaCasoUso.buscarPorId(idEntrega));
    }

    @PutMapping("/{idEntrega}")
    public EntregaResponseDTO actualizar(@PathVariable int idEntrega, @Valid @RequestBody EntregaRequestDTO request) {

        Orden orden = ordenCasoUso.obtenerPorId(request.getFkOrden().getIdOrden());

        Usuario entregadoPor = usuarioCasoUso.buscarPorId(request.getEntregadoPor().getIdUsuario());

        Entrega actual = entregaCasoUso.buscarPorId(idEntrega);

        Entrega dom = new Entrega(
            idEntrega,
            entregadoPor,
            request.getRecibidoPor(),
            actual.getFechaEntrega(),
            request.getNotas(),
            orden
        );

        return mapper.toResponseDto(entregaCasoUso.guardar(dom));
    }


    @DeleteMapping("/{idEntrega}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int idEntrega) {
        entregaCasoUso.eliminar(idEntrega);
    }

}
