package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IClienteCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Cliente;
import com.uisrael.proyectoapi.dominio.repositorios.IClienteRepositorio;

public class ClienteCasoUsoImpl implements IClienteCasoUso{
	
	private final IClienteRepositorio repositorio;
	
	public ClienteCasoUsoImpl(IClienteRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Cliente crear(Cliente cliente) {
		return repositorio.guardar(cliente);
	}

	@Override
	public Cliente obtenerPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	}

	@Override
	public List<Cliente> listar() {
		return repositorio.listarTodos();
	}
	
	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}
}
