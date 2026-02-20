package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.dominio.repositorios.IOrdenRepositorio;

public class OrdenCasoUsoImpl implements IOrdenCasoUso {

  private final IOrdenRepositorio repositorio;

  public OrdenCasoUsoImpl(IOrdenRepositorio repositorio) {
    this.repositorio = repositorio;
  }

  @Override
  public Orden crear(Orden orden) {
    return repositorio.guardar(orden);
  }

  @Override
  public Orden obtenerPorId(int idOrden) {
    return repositorio.buscarPorId(idOrden)
      .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
  }

  @Override
  public List<Orden> listarTodos() {
    return repositorio.listarTodos();
  }

  @Override
  public void eliminar(int idOrden) {
    repositorio.eliminar(idOrden);
  }
  
  @Override
  public List<Orden> listarOrdenesDisponibles() {
    return repositorio.listarOrdenesDisponibles();
  }
  
}
