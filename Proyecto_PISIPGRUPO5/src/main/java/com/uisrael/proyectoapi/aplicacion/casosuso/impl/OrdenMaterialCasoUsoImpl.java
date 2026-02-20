package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenMaterialCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.OrdenMaterial;
import com.uisrael.proyectoapi.dominio.repositorios.IOrdenMaterialRepositorio;

public class OrdenMaterialCasoUsoImpl implements IOrdenMaterialCasoUso {
	private final IOrdenMaterialRepositorio repositorio;

	public OrdenMaterialCasoUsoImpl(IOrdenMaterialRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public OrdenMaterial guardar(OrdenMaterial ordenMaterial) {
		return repositorio.guardar(ordenMaterial);
	}

	@Override
	public OrdenMaterial buscarPorId(int idOrdenMaterial) {
		return repositorio.buscarPorId(idOrdenMaterial).orElseThrow(() -> new RuntimeException("Orden Material no encontrado"));
	}

	@Override
	public List<OrdenMaterial> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idOrdenMaterial) {
		repositorio.eliminar(idOrdenMaterial);

	}

}
