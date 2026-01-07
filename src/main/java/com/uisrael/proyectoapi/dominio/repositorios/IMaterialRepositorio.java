package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Material;

public interface IMaterialRepositorio {

	Material guardar(Material material);
	
	Optional<Material> buscarPorId(int id);
	
	List<Material> listarTodos();
	
	void eliminar(int id);
}
