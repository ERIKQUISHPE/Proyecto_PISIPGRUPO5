package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IPrioridadCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Prioridad;
import com.uisrael.proyectoapi.dominio.repositorios.IPrioridadRepositorio;

public class PrioridadCasoUsoImpl implements IPrioridadCasoUso {
	private final IPrioridadRepositorio repositorio;

	public PrioridadCasoUsoImpl(IPrioridadRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Prioridad guardar(Prioridad prioridad) {
		return repositorio.guardar(prioridad);
	}

	@Override
	public Prioridad buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	}

	@Override
	public List<Prioridad> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);

	}

}
