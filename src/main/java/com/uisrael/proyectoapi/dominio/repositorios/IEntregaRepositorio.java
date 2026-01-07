package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Entrega;

public interface IEntregaRepositorio {

	Entrega guardar(Entrega entrega);
	
	Optional<Entrega> buscarPorId(int id);
	
	List<Entrega> listarTodos();
	
	void eliminar(int id);
}
