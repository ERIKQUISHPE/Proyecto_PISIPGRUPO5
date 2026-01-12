package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.EstadoOrden;

public interface IEstadoOrdenCasoUso {
EstadoOrden guardar(EstadoOrden estadoOrden);
	
	EstadoOrden buscarPorId(int id);
	
	List<EstadoOrden> listarTodos();
	
	void eliminar(int id);

}
