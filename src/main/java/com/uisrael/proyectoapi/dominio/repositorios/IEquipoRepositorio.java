package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Equipo;

public interface IEquipoRepositorio {

	Equipo guardar(Equipo equipo);
	
	Optional<Equipo> buscarPorId(int id);
	
	List<Equipo> listarTodos();
	
	void eliminar(int id);
}
