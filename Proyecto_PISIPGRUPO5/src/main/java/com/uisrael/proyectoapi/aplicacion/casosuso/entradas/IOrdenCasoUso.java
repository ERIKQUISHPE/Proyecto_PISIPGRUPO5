package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Orden;

public interface IOrdenCasoUso {

  Orden crear(Orden orden);

  Orden obtenerPorId(int idOrden);

  List<Orden> listarTodos();

  void eliminar(int idOrden);
  
  List<Orden> listarOrdenesDisponibles();
}
