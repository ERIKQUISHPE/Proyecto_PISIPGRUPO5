package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenInternaCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.OrdenInterna;
import com.uisrael.proyectoapi.dominio.repositorios.IOrdenInternaRepositorio;

public class OrdenInternaCasoUsoImpl implements IOrdenInternaCasoUso {
	private final IOrdenInternaRepositorio repositorio;

	public OrdenInternaCasoUsoImpl(IOrdenInternaRepositorio repositorio) {

		this.repositorio = repositorio;
	}

	@Override
	public OrdenInterna guardar(OrdenInterna ordenInterna) {
		return repositorio.guardar(ordenInterna);
	}

	@Override
	public OrdenInterna buscarPorId(int idOrdenInterna) {
		return repositorio.buscarPorId(idOrdenInterna).orElseThrow(() -> new RuntimeException("Orden Interna no encontrado"));
	}

	@Override
	public List<OrdenInterna> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idOrdenInterna) {
		repositorio.eliminar(idOrdenInterna);

	}

}
