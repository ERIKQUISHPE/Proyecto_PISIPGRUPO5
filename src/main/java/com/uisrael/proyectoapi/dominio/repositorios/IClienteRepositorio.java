package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Cliente;

public interface IClienteRepositorio {

	Cliente guardar(Cliente cliente);
	
	Optional<Cliente> buscarPorId(int id);
	
	List<Cliente> listarTodos();
	
	void eliminar(int id);
}
