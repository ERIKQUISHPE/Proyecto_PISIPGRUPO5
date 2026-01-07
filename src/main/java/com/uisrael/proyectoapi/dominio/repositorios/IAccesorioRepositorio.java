package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Accesorio;

public interface IAccesorioRepositorio {

	Accesorio guardar(Accesorio accesorio);
	
	Optional<Accesorio> buscarPorId(int id);
	
	List<Accesorio> listarTodos();
	
	void eliminar(int id);
}
