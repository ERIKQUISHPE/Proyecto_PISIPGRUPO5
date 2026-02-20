package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IAccionReparacionCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenInternaCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.AccionReparacion;
import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.dominio.entidades.OrdenInterna;
import com.uisrael.proyectoapi.presentacion.dto.request.AccionReparacionRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.AccionReparacionResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IAccionReparacionDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accionReparacion")
public class AccionReparacionControlador {

    private final IAccionReparacionCasoUso accionReparacionCasoUso;
    private final IOrdenCasoUso ordenCasoUso;
    private final IAccionReparacionDtoMapper mapper;
    private final IOrdenInternaCasoUso ordenInternaCasoUso;


    public AccionReparacionControlador(IAccionReparacionCasoUso accionReparacionCasoUso,
                                      IOrdenCasoUso ordenCasoUso, IOrdenInternaCasoUso ordenInternaCasoUso, 
                                      IAccionReparacionDtoMapper mapper) {
        this.accionReparacionCasoUso = accionReparacionCasoUso;
        this.ordenCasoUso = ordenCasoUso;
        this.mapper = mapper;
        this.ordenInternaCasoUso = ordenInternaCasoUso;

    }

    private void actualizarEstadoOrden(int idOrden, String nuevoEstado) {
        if (idOrden <= 0) return;

        try {
            var actualOrden = ordenCasoUso.obtenerPorId(idOrden);

            Orden editada = new Orden(
                    actualOrden.getIdOrden(),
                    actualOrden.getFechaIngreso(),
                    actualOrden.getFechaSalida(),
                    actualOrden.getDetalleProblema(),
                    actualOrden.getObservaciones(),
                    actualOrden.getTotalCobro(),
                    actualOrden.isPagado(),
                    nuevoEstado,
                    actualOrden.getFkCliente(),
                    actualOrden.getFkUsuario()
            );

            ordenCasoUso.crear(editada);
        } catch (Exception e) {
        }
    }
    
    private void actualizarEstadoOrdenInterna(int idOrden, int nuevoEstadoId) {
        try {
            var lista = ordenInternaCasoUso.listarTodos();

            lista.stream()
                    .filter(oi -> oi.getFkOrden() != null 
                               && oi.getFkOrden().getIdOrden() == idOrden)
                    .forEach(oi -> {

                        var editada = new OrdenInterna(
                                oi.getIdOrdenInterna(),
                                oi.getTecnicoId(),
                                nuevoEstadoId,
                                oi.getDiagnostico(),
                                oi.getObservaciones(),
                                oi.getCreadoPor(),
                                oi.getCreadoEn(),
                                oi.getFkOrden()
                        );

                        ordenInternaCasoUso.guardar(editada);
                    });

        } catch (Exception e) {
        }
    }

    @GetMapping
    public List<AccionReparacionResponseDTO> listar() {
        return accionReparacionCasoUso.listarTodos()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }
    
    @GetMapping("/porOrden/{idOrden}")
    public List<AccionReparacionResponseDTO> listarPorOrden(@PathVariable int idOrden) {

        return accionReparacionCasoUso.listarTodos()
                .stream()
                .filter(a -> a.getFkOrden() != null && a.getFkOrden().getIdOrden() == idOrden)
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping("/{id}")
    public AccionReparacionResponseDTO buscar(@PathVariable int id) {
        var encontrado = accionReparacionCasoUso.buscarPorId(id);
        return mapper.toResponseDto(encontrado);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccionReparacionResponseDTO crear(@Valid @RequestBody AccionReparacionRequestDTO request) {

        Orden orden = ordenCasoUso.obtenerPorId(request.getIdOrden());

        AccionReparacion domain = new AccionReparacion(
                0,
                request.getTecnicoId(),
                request.getDescripcion(),
                request.getFechaAccion(),
                orden
        );

        var guardado = accionReparacionCasoUso.guardar(domain);

        if (orden != null) {
        	actualizarEstadoOrden(orden.getIdOrden(), "FINALIZADO");
        	actualizarEstadoOrdenInterna(orden.getIdOrden(), 3); 
        

        }

        return mapper.toResponseDto(guardado);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void actualizar(@PathVariable int id, @Valid @RequestBody AccionReparacionRequestDTO request) {

        var actual = accionReparacionCasoUso.buscarPorId(id);

        Integer idOrdenFinal = (request.getIdOrden() != null && request.getIdOrden() > 0)
                ? request.getIdOrden()
                : (actual.getFkOrden() != null ? actual.getFkOrden().getIdOrden() : null);

        if (idOrdenFinal == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falta idOrden para actualizar");
        }

        Orden orden = ordenCasoUso.obtenerPorId(idOrdenFinal);

        AccionReparacion editada = new AccionReparacion(
                id,
                request.getTecnicoId(),
                request.getDescripcion(),
                request.getFechaAccion(),
                orden
        );

        accionReparacionCasoUso.guardar(editada);

        if (orden != null) {
            actualizarEstadoOrden(orden.getIdOrden(), "FINALIZADO");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id) {

        var actual = accionReparacionCasoUso.buscarPorId(id);

        Integer idOrden = (actual.getFkOrden() != null) ? actual.getFkOrden().getIdOrden() : null;

        accionReparacionCasoUso.eliminar(id);

        if (idOrden != null && idOrden > 0) {
        	actualizarEstadoOrden(idOrden, "EN PROCESO");
        	actualizarEstadoOrdenInterna(idOrden, 2); 

        }
    }
}
