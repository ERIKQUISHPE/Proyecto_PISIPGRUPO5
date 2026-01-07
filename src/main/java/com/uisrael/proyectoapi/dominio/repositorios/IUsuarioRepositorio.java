package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Usuario;

public interface IUsuarioRepositorio {

	Usuario guardar(Usuario usuario);
	
	Optional<Usuario> buscarPorId(int id);
	
	List<Usuario> listarTodos();
	
	void eliminar(int id);
}
