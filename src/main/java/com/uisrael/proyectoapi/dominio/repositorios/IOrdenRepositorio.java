package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Orden;

public interface IOrdenRepositorio {

	Orden guardar(Orden orden);
	
	Optional<Orden> buscarPorId(int id);
	
	List<Orden> listarTodos();
	
	void eliminar(int id);
}
