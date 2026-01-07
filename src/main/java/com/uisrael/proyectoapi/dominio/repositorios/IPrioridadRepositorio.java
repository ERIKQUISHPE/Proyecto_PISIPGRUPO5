package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Prioridad;

public interface IPrioridadRepositorio {

	Prioridad guardar(Prioridad prioridad);
	
	Optional<Prioridad> buscarPorId(int id);
	
	List<Prioridad> listarTodos();
	
	void eliminar(int id);
}
