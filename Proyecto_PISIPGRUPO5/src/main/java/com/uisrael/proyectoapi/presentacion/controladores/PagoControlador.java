package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IPagoCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.dominio.entidades.Pago;
import com.uisrael.proyectoapi.presentacion.dto.request.PagoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.PagoResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IPagoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pago")
public class PagoControlador {

    private final IPagoCasoUso pagoCasoUso;
    private final IPagoDtoMapper mapper;
    private final IOrdenCasoUso ordenCasoUso;

    public PagoControlador(IPagoCasoUso pagoCasoUso, IPagoDtoMapper mapper, IOrdenCasoUso ordenCasoUso) {
        this.pagoCasoUso = pagoCasoUso;
        this.mapper = mapper;
        this.ordenCasoUso = ordenCasoUso;
    }

    @GetMapping
    public List<PagoResponseDTO> listar() {
        return pagoCasoUso.listarTodos()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PagoResponseDTO crear(@Valid @RequestBody PagoRequestDTO request) {

        Orden orden = ordenCasoUso.obtenerPorId(request.getIdOrden());

        Pago pago = new Pago(
                0,
                request.getMonto(),
                request.getMetodoPago(),
                request.getFechaPago(),
                request.getRegistradoPor(),
                orden
        );

        return mapper.toResponseDto(pagoCasoUso.guardar(pago));
    }

    @GetMapping("/{id}")
    public PagoResponseDTO buscarPorId(@PathVariable int id) {
        return mapper.toResponseDto(pagoCasoUso.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public PagoResponseDTO actualizar(@PathVariable int id, @Valid @RequestBody PagoRequestDTO request) {

        Pago actual = pagoCasoUso.buscarPorId(id);

        Orden orden = ordenCasoUso.obtenerPorId(request.getIdOrden());

        var fecha = (request.getFechaPago() != null) ? request.getFechaPago() : actual.getFechaPago();

        int registradoPor = (request.getRegistradoPor() != null)
                ? request.getRegistradoPor()
                : actual.getRegistradoPor();

        Pago pago = new Pago(
                id,
                request.getMonto(),
                request.getMetodoPago(),
                fecha,
                registradoPor,
                orden
        );

        return mapper.toResponseDto(pagoCasoUso.guardar(pago));
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id) {
        pagoCasoUso.eliminar(id);
    }
    
    @GetMapping("/por-orden/{idOrden}")
    public ResponseEntity<PagoResponseDTO> buscarPorOrden(@PathVariable int idOrden) {

      return pagoCasoUso.buscarPorOrden(idOrden)
          .map(p -> ResponseEntity.ok(mapper.toResponseDto(p)))
          .orElseGet(() -> ResponseEntity.noContent().build()); 
    }
    
}