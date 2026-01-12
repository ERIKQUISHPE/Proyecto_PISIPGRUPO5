package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Cliente;

public interface IClienteCasoUso {

Cliente guardar(Cliente cliente);
	
	Cliente buscarPorId(int id);
	
	List<Cliente> listarTodos();
	
	void eliminar(int id);
}

