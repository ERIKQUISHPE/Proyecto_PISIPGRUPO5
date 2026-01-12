package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IMaterialCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Material;
import com.uisrael.proyectoapi.dominio.repositorios.IMaterialRepositorio;

public class MaterialCasoUsoImpl implements IMaterialCasoUso {
	private final IMaterialRepositorio repositorio;

	public MaterialCasoUsoImpl(IMaterialRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Material guardar(Material material) {
		return repositorio.guardar(material);
	}

	@Override
	public Material buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	}

	@Override
	public List<Material> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);

	}

}
