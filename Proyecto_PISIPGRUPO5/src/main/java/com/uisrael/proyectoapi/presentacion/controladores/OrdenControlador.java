package com.uisrael.proyectoapi.presentacion.controladores;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenInternaCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Cliente;
import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.dominio.entidades.OrdenInterna;
import com.uisrael.proyectoapi.dominio.entidades.Usuario;
import com.uisrael.proyectoapi.dominio.repositorios.IClienteRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IUsuarioRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.projection.IOrdenDashboardProjection;
import com.uisrael.proyectoapi.infraestructura.repositorios.IAccionReparacionJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IEntregaJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IEquipoJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IOrdenInternaJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IOrdenJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IOrdenMaterialJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IPagoJpaRepositorio;
import com.uisrael.proyectoapi.presentacion.dto.request.OrdenRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.OrdenResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IOrdenDtoMapper;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/orden")
public class OrdenControlador {

  private final IOrdenCasoUso ordenCasoUso;
  private final IOrdenInternaCasoUso ordenInternaCasoUso;

  private final IOrdenDtoMapper mapper;
  private final IOrdenJpaRepositorio ordenJpaRepositorio;

  private final IClienteRepositorio clienteRepositorio;
  private final IUsuarioRepositorio usuarioRepositorio;
  private final IEquipoJpaRepositorio equipoJpaRepositorio;
  private final IEntregaJpaRepositorio entregaJpaRepositorio;
  private final IPagoJpaRepositorio pagoJpaRepositorio;
  private final IOrdenMaterialJpaRepositorio ordenMaterialJpaRepositorio;
  private final IOrdenInternaJpaRepositorio ordenInternaJpaRepositorio;
  private final IAccionReparacionJpaRepositorio accionReparacionJpaRepositorio;

  public OrdenControlador(
      IOrdenCasoUso ordenCasoUso,
      IOrdenInternaCasoUso ordenInternaCasoUso,
      IOrdenDtoMapper mapper,
      IOrdenJpaRepositorio ordenJpaRepositorio,
      IClienteRepositorio clienteRepositorio,
      IUsuarioRepositorio usuarioRepositorio,
      IEquipoJpaRepositorio equipoJpaRepositorio,
      IEntregaJpaRepositorio entregaJpaRepositorio,
      IPagoJpaRepositorio pagoJpaRepositorio,
      IOrdenMaterialJpaRepositorio ordenMaterialJpaRepositorio,
      IOrdenInternaJpaRepositorio ordenInternaJpaRepositorio,
      IAccionReparacionJpaRepositorio accionReparacionJpaRepositorio
  ) {
    this.ordenCasoUso = ordenCasoUso;
    this.ordenInternaCasoUso = ordenInternaCasoUso;

    this.mapper = mapper;
    this.ordenJpaRepositorio = ordenJpaRepositorio;

    this.clienteRepositorio = clienteRepositorio;
    this.usuarioRepositorio = usuarioRepositorio;
    this.equipoJpaRepositorio = equipoJpaRepositorio;
    this.entregaJpaRepositorio = entregaJpaRepositorio;
    this.pagoJpaRepositorio = pagoJpaRepositorio;
    this.ordenMaterialJpaRepositorio = ordenMaterialJpaRepositorio;
    this.ordenInternaJpaRepositorio = ordenInternaJpaRepositorio;
    this.accionReparacionJpaRepositorio = accionReparacionJpaRepositorio;
  }

  @GetMapping
  public List<OrdenResponseDTO> listar() {
    return ordenCasoUso.listarTodos()
      .stream()
      .map(mapper::toResponseDto)
      .toList();
  }

  @GetMapping("/{id}")
  public OrdenResponseDTO obtener(@PathVariable("id") int id) {
    Orden orden = ordenCasoUso.obtenerPorId(id);
    return mapper.toResponseDto(orden);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OrdenResponseDTO crear(@RequestBody OrdenRequestDTO request) {

    if (request.getIdCliente() == null || request.getIdUsuario() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Faltan idCliente o idUsuario en el request");
    }

    Cliente cliente = clienteRepositorio.buscarPorId(request.getIdCliente())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente no existe"));

    Usuario usuario = usuarioRepositorio.buscarPorId(request.getIdUsuario())
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario no existe"));

    String estado = (request.getEstadoOrden() == null || request.getEstadoOrden().isBlank())
      ? "INGRESADO"
      : request.getEstadoOrden();

    boolean pagado = (request.getPagado() != null) ? request.getPagado() : false;

    BigDecimal total = (request.getTotalCobro() != null) ? request.getTotalCobro() : BigDecimal.ZERO;

    String detalle = (request.getDetalleProblema() == null || request.getDetalleProblema().isBlank())
      ? "Sin detalle"
      : request.getDetalleProblema();

    String obs = (request.getObservaciones() == null || request.getObservaciones().isBlank())
      ? "N/A"
      : request.getObservaciones();

    Orden orden = new Orden(
      0,
      null,
      null,
      detalle,
      obs,
      total,
      pagado,
      estado,
      cliente,
      usuario
    );

    Orden guardada = ordenCasoUso.crear(orden);

    int ESTADO_INGRESADO_ID = 1;

    OrdenInterna oi = new OrdenInterna(
      0,
      request.getIdUsuario(),       
      ESTADO_INGRESADO_ID,
      null,                        
      null,                         
      request.getIdUsuario(),        
      LocalDateTime.now(),
      guardada
    );

    ordenInternaCasoUso.guardar(oi);

    return mapper.toResponseDto(guardada);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public OrdenResponseDTO actualizar(@PathVariable("id") int id, @RequestBody OrdenRequestDTO request) {

    Orden actual = ordenCasoUso.obtenerPorId(id);

    Integer idCliente = (request.getIdCliente() != null) ? request.getIdCliente()
      : (actual.getFkCliente() != null ? actual.getFkCliente().getIdCliente() : null);

    Integer idUsuario = (request.getIdUsuario() != null) ? request.getIdUsuario()
      : (actual.getFkUsuario() != null ? actual.getFkUsuario().getIdUsuario() : null);

    if (idCliente == null || idUsuario == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Faltan idCliente o idUsuario para actualizar");
    }

    Cliente cliente = clienteRepositorio.buscarPorId(idCliente)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente no existe"));

    Usuario usuario = usuarioRepositorio.buscarPorId(idUsuario)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario no existe"));

    String estado = (request.getEstadoOrden() == null || request.getEstadoOrden().isBlank())
      ? actual.getEstadoOrden()
      : request.getEstadoOrden();

    boolean pagado = (request.getPagado() != null) ? request.getPagado() : actual.isPagado();

    BigDecimal total = (request.getTotalCobro() != null) ? request.getTotalCobro() : actual.getTotalCobro();

    String detalle = (request.getDetalleProblema() == null || request.getDetalleProblema().isBlank())
      ? actual.getDetalleProblema()
      : request.getDetalleProblema();

    String obs = (request.getObservaciones() == null || request.getObservaciones().isBlank())
      ? actual.getObservaciones()
      : request.getObservaciones();

    Orden editada = new Orden(
      id,
      actual.getFechaIngreso(),
      actual.getFechaSalida(),
      detalle,
      obs,
      total,
      pagado,
      estado,
      cliente,
      usuario
    );

    Orden guardada = ordenCasoUso.crear(editada);
    return mapper.toResponseDto(guardada);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Transactional
  public void eliminar(@PathVariable int id) {

    try {
      accionReparacionJpaRepositorio.deleteByFkOrden_IdOrden(id);
      ordenInternaJpaRepositorio.deleteByFkOrden_IdOrden(id);
      ordenMaterialJpaRepositorio.deleteByFkOrden_IdOrden(id);
      pagoJpaRepositorio.deleteByFkOrden_IdOrden(id);
      entregaJpaRepositorio.deleteByFkOrden_IdOrden(id);
      equipoJpaRepositorio.deleteByFkOrden_IdOrden(id);

      ordenCasoUso.eliminar(id);

    } catch (DataIntegrityViolationException e) {
      throw new ResponseStatusException(
        HttpStatus.CONFLICT,
        "No se pudo eliminar por integridad, revisa relaciones"
      );
    }
  }

  @GetMapping("/dashboard")
  public List<IOrdenDashboardProjection> dashboardOrdenes() {
    return ordenJpaRepositorio.dashboardOrdenes();
  }
  
  @PutMapping("/{id}/estado/{estado}")
  @ResponseStatus(HttpStatus.OK)
  public void cambiarEstado(@PathVariable("id") int id,
                            @PathVariable("estado") String estado) {

      Orden actual = ordenCasoUso.obtenerPorId(id);

      String nuevoEstado = (estado == null || estado.isBlank())
              ? actual.getEstadoOrden()
              : estado;

      Orden editada = new Orden(
              id,
              actual.getFechaIngreso(),
              actual.getFechaSalida(),
              actual.getDetalleProblema(),
              actual.getObservaciones(),
              actual.getTotalCobro(),
              actual.isPagado(),
              nuevoEstado,
              actual.getFkCliente(),
              actual.getFkUsuario()
      );

      ordenCasoUso.crear(editada);
  }

  @GetMapping("/disponibles")
  public List<OrdenResponseDTO> listarDisponibles() {
    return ordenCasoUso.listarOrdenesDisponibles()
        .stream()
        .map(mapper::toResponseDto)
        .toList();
  }
  
}
