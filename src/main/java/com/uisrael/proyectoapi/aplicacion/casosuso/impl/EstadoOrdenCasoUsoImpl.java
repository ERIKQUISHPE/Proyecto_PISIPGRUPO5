package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IEstadoOrdenCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.EstadoOrden;
import com.uisrael.proyectoapi.dominio.repositorios.IEstadoOrdenRepositorio;

public class EstadoOrdenCasoUsoImpl implements IEstadoOrdenCasoUso{
	private final IEstadoOrdenRepositorio repositorio;

	public EstadoOrdenCasoUsoImpl(IEstadoOrdenRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public EstadoOrden guardar(EstadoOrden estadoOrden) {
		return repositorio.guardar(estadoOrden);
	}

	@Override
	public EstadoOrden buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	}

	@Override
	public List<EstadoOrden> listarTodos() {
		return repositorio.listarTodos();
	}
	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}	

}
