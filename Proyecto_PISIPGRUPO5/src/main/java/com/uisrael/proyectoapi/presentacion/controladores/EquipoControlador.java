package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IEquipoCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Equipo;
import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.presentacion.dto.request.EquipoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.EquipoResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IEquipoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/equipo")
public class EquipoControlador {

  private final IEquipoCasoUso equipoCasoUso;
  private final IOrdenCasoUso ordenCasoUso;
  private final IEquipoDtoMapper mapper;

  public EquipoControlador(IEquipoCasoUso equipoCasoUso, IEquipoDtoMapper mapper, IOrdenCasoUso ordenCasoUso) {
    this.equipoCasoUso = equipoCasoUso;
    this.mapper = mapper;
    this.ordenCasoUso = ordenCasoUso;
  }

  @GetMapping
  public List<EquipoResponseDTO> listar() {
    return equipoCasoUso.listarTodos().stream().map(mapper::toResponseDto).toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public EquipoResponseDTO crear(@Valid @RequestBody EquipoRequestDTO request) {

    if (request.getFkOrden() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "fkOrden es requerido");
    }

    Integer idOrden = request.getFkOrden();

    if (equipoCasoUso.existePorOrden(idOrden)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Esta orden ya tiene equipo");
    }

    Orden orden = ordenCasoUso.obtenerPorId(idOrden);

    Equipo dom = new Equipo(
      0,
      request.getTipo(),
      request.getMarca(),
      request.getModelo(),
      request.getSerial(),
      request.getEstadoEquipo(),
      request.getObservaciones(),
      orden
    );

    return mapper.toResponseDto(equipoCasoUso.guardar(dom));
  }

  @GetMapping("/por-orden/{idOrden}")
  public boolean existePorOrden(@PathVariable Integer idOrden) {
    return equipoCasoUso.existePorOrden(idOrden);
  }
  
@GetMapping("/{id}")
public EquipoResponseDTO buscarPorId(@PathVariable Integer id) {
 Equipo equipo = equipoCasoUso.buscarPorId(id);
 return mapper.toResponseDto(equipo);
}

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void eliminar(@PathVariable Integer id) {
 equipoCasoUso.eliminar(id);
}

@PutMapping("/{id}")
public EquipoResponseDTO actualizar(@PathVariable Integer id, @Valid @RequestBody EquipoRequestDTO request) {

 if (request.getFkOrden() == null) {
   throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "fkOrden es requerido");
 }

 Integer idOrden = request.getFkOrden();
 Orden orden = ordenCasoUso.obtenerPorId(idOrden);

 Equipo dom = new Equipo(
   id,
   request.getTipo(),
   request.getMarca(),
   request.getModelo(),
   request.getSerial(),
   request.getEstadoEquipo(),
   request.getObservaciones(),
   orden
 );

 return mapper.toResponseDto(equipoCasoUso.guardar(dom));
}

  
  
}
