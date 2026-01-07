package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.OrdenInterna;

public interface IOrdenInternaRepositorio {

	OrdenInterna guardar(OrdenInterna ordenInterna);
	
	Optional<OrdenInterna> buscarPorId(int id);
	
	List<OrdenInterna> listarTodos();
	
	void eliminar(int id);
}
