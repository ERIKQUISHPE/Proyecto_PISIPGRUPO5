package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IProveedorCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Proveedor;
import com.uisrael.proyectoapi.dominio.repositorios.IProveedorRepositorio;

public class ProveedorCasoUsoImpl implements IProveedorCasoUso {
	private final IProveedorRepositorio repositorio;

	public ProveedorCasoUsoImpl(IProveedorRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Proveedor guardar(Proveedor proveedor) {
		return repositorio.guardar(proveedor);
	}

	@Override
	public Proveedor buscarPorId(int idProveedor) {
		return repositorio.buscarPorId(idProveedor).orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
	}

	@Override
	public List<Proveedor> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idProveedor) {
		repositorio.eliminar(idProveedor);

	}

}
