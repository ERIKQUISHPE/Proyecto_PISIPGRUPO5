package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacion;

public interface IAccionReparacionRepositorio {

	AccionReparacion guardar(AccionReparacion accionReparacion);
	
	Optional<AccionReparacion> buscarPorId(int id);
	
	List<AccionReparacion> listarTodos();
	
	void eliminar(int id);
}
