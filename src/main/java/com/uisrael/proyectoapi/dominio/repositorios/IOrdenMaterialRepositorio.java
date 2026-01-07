package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.OrdenMaterial;

public interface IOrdenMaterialRepositorio {

	OrdenMaterial guardar(OrdenMaterial ordenMaterial);
	
	Optional<OrdenMaterial> buscarPorId(int id);
	
	List<OrdenMaterial> listarTodos();
	
	void eliminar(int id);
}