package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.dominio.repositorios.IOrdenRepositorio;

public class OrdenCasoUsoImpl implements IOrdenCasoUso{
	
	private final IOrdenRepositorio repositorio;
	
	public OrdenCasoUsoImpl(IOrdenRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Orden crear(Orden orden) {
		return repositorio.guardar(orden);
	}

	@Override
	public Orden obtenerPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Orden no encontrado"));
	}

	@Override
	public List<Orden> listar() {
		return repositorio.listarTodos();
	}
	
	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}
}
