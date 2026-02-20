package com.uisrael.proyectoapi.presentacion.controladores;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenInternaCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IUsuarioCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Orden;

import com.uisrael.proyectoapi.presentacion.dto.request.DiagnosticoSimpleRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.request.OrdenInternaRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.OrdenInternaResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IOrdenInternaDtoMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IAccionReparacionJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IEquipoJpaRepositorio;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ordenInterna")
public class OrdenInternaControlador {

    private final IEquipoJpaRepositorio equipoJpaRepositorio;
    private final IOrdenInternaCasoUso ordenInternaCasoUso;
    private final IOrdenInternaDtoMapper mapper;
    private final IUsuarioCasoUso usuarioCasoUso;

    private final IOrdenCasoUso ordenCasoUso;

    public OrdenInternaControlador(
            IOrdenInternaCasoUso ordenInternaCasoUso,
            IOrdenInternaDtoMapper mapper,
            IEquipoJpaRepositorio equipoJpaRepositorio,
            IUsuarioCasoUso usuarioCasoUso, 
            IAccionReparacionJpaRepositorio accionRepo, 
            IOrdenCasoUso ordenCasoUso
    ) {
        this.ordenInternaCasoUso = ordenInternaCasoUso;
        this.mapper = mapper;
        this.equipoJpaRepositorio = equipoJpaRepositorio;
        this.usuarioCasoUso = usuarioCasoUso;
        this.ordenCasoUso = ordenCasoUso;
    }

    private OrdenInternaResponseDTO mapConTecnico(com.uisrael.proyectoapi.dominio.entidades.OrdenInterna o) {
        OrdenInternaResponseDTO dto = mapper.toResponseDto(o);

        try {
            int tecnicoId = dto.getTecnicoId();

            if (tecnicoId > 0) {
                var tecnico = usuarioCasoUso.buscarPorId(tecnicoId);

                if (tecnico != null) {
                    dto.setTecnicoNombre(tecnico.getNombre());
                    dto.setTecnicoApellido(tecnico.getApellido());
                }
            }
        } catch (Exception e) {
        }

        return dto;
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
    
    @GetMapping("/para-reparacion")
    public List<OrdenInternaResponseDTO> listarParaReparacion() {

        final int EN_PROCESO_ID = 2;

        return ordenInternaCasoUso.listarTodos().stream()
                .filter(oi -> oi.getFkOrden() != null)
                .filter(oi -> oi.getTecnicoId() > 0)
                .filter(oi -> oi.getEstadoId() == EN_PROCESO_ID)
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping
    public List<OrdenInternaResponseDTO> listar() {
        return ordenInternaCasoUso.listarTodos()
                .stream()
                .map(this::mapConTecnico)
                .toList();
    }

    @GetMapping("/disponibles")
    public List<OrdenInternaResponseDTO> listarDisponibles() {

        int INGRESADO_ID = 1;

        return ordenInternaCasoUso.listarTodos()
                .stream()
                .filter(o -> o.getEstadoId() == INGRESADO_ID)
                .filter(o -> o.getDiagnostico() == null || o.getDiagnostico().trim().isEmpty())
                .filter(o -> o.getFkOrden() != null
                        && equipoJpaRepositorio.existsByFkOrden_IdOrden(o.getFkOrden().getIdOrden()))
                .map(this::mapConTecnico)
                .toList();
    }
    @GetMapping("/{id}")
    public OrdenInternaResponseDTO buscar(@PathVariable int id) {
        return mapConTecnico(
                ordenInternaCasoUso.buscarPorId(id)
        );
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdenInternaResponseDTO crear(@Valid @RequestBody OrdenInternaRequestDTO request) {

        var guardado = ordenInternaCasoUso.guardar(
                mapper.toDomain(request)
        );

        return mapConTecnico(guardado);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id) {
        ordenInternaCasoUso.eliminar(id);
    }
    
    @PostMapping("/{id}/diagnostico")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarDiagnostico(@PathVariable int id,
                                   @RequestBody DiagnosticoSimpleRequestDTO dto) {

        var actual = ordenInternaCasoUso.buscarPorId(id);

        int EN_PROCESO_ID = 2;

        Integer creadoPorReq = dto.getCreadoPor();

        int creadoPorFinal = (creadoPorReq == null || creadoPorReq <= 0)
                ? actual.getTecnicoId()
                : creadoPorReq;

        var nuevo = new com.uisrael.proyectoapi.dominio.entidades.OrdenInterna(
                actual.getIdOrdenInterna(),
                actual.getTecnicoId(),
                EN_PROCESO_ID,
                dto.getDiagnostico(),
                dto.getObservaciones(),
                creadoPorFinal,
                LocalDateTime.now(),
                actual.getFkOrden()
        );

        ordenInternaCasoUso.guardar(nuevo);
        if (actual.getFkOrden() != null) {
            actualizarEstadoOrden(actual.getFkOrden().getIdOrden(), "EN PROCESO");
        }
    }
    @PutMapping("/{id}/diagnostico")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void actualizarDiagnostico(@PathVariable int id,
                                      @RequestBody DiagnosticoSimpleRequestDTO dto) {

        var actual = ordenInternaCasoUso.buscarPorId(id);

        int EN_PROCESO_ID = 2;

        Integer creadoPorReq = dto.getCreadoPor();

        int creadoPorFinal = (creadoPorReq == null || creadoPorReq <= 0)
                ? actual.getCreadoPor()
                : creadoPorReq;

        var nuevo = new com.uisrael.proyectoapi.dominio.entidades.OrdenInterna(
                actual.getIdOrdenInterna(),
                actual.getTecnicoId(),
                EN_PROCESO_ID,
                dto.getDiagnostico(),
                dto.getObservaciones(),
                creadoPorFinal,
                actual.getCreadoEn() != null
                        ? actual.getCreadoEn()
                        : LocalDateTime.now(),
                actual.getFkOrden()
        );

        ordenInternaCasoUso.guardar(nuevo);

        if (actual.getFkOrden() != null) {
            actualizarEstadoOrden(actual.getFkOrden().getIdOrden(), "EN PROCESO");
        }
    }

    @DeleteMapping("/{id}/diagnostico")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarDiagnostico(@PathVariable int id) {

        var actual = ordenInternaCasoUso.buscarPorId(id);

        int INGRESADO_ID = 1;

        var nuevo = new com.uisrael.proyectoapi.dominio.entidades.OrdenInterna(
                actual.getIdOrdenInterna(),
                actual.getTecnicoId(),
                INGRESADO_ID,
                null,
                null,
                actual.getCreadoPor(),
                actual.getCreadoEn(),
                actual.getFkOrden()
        );

        ordenInternaCasoUso.guardar(nuevo);

        if (actual.getFkOrden() != null) {
            actualizarEstadoOrden(actual.getFkOrden().getIdOrden(), "INGRESADO");
        }
    }
}
