package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IEntregaCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Entrega;
import com.uisrael.proyectoapi.dominio.repositorios.IEntregaRepositorio;

public class EntregaCasoUsoImpl implements IEntregaCasoUso {
	private final IEntregaRepositorio repositorio;

	public EntregaCasoUsoImpl(IEntregaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Entrega guardar(Entrega entrega) {
		return repositorio.guardar(entrega);
	}

	@Override
	public Entrega buscarPorId(int idEntrega) {
		return repositorio.buscarPorId(idEntrega).orElseThrow(() -> new RuntimeException("Entrega no encontrada"));
	}

	@Override
	public List<Entrega> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idEntrega) {
		repositorio.eliminar(idEntrega);

	}

}
