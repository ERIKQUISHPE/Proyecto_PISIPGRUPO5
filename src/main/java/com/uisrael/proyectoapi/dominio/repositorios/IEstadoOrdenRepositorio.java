package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.EstadoOrden;

public interface IEstadoOrdenRepositorio {

	EstadoOrden guardar(EstadoOrden estadoOrden);
	
	Optional<EstadoOrden> buscarPorId(int id);
	
	List<EstadoOrden> listarTodos();
	
	void eliminar(int id);
}
