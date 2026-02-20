package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IClienteCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Cliente;
import com.uisrael.proyectoapi.dominio.repositorios.IClienteRepositorio;

public class ClienteCasoUsoImpl implements IClienteCasoUso {
	private final IClienteRepositorio repositorio;

	public ClienteCasoUsoImpl(IClienteRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		return repositorio.guardar(cliente);
	}

	@Override
	public Cliente buscarPorId(int idCliente) {
		return repositorio.buscarPorId(idCliente).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	}

	@Override
	public List<Cliente> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idCliente) {
		repositorio.eliminar(idCliente);
		
	}
}
