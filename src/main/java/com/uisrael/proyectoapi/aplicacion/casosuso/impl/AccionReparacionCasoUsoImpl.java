package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IAccionReparacionCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.AccionReparacion;
import com.uisrael.proyectoapi.dominio.repositorios.IAccionReparacionRepositorio;

public class AccionReparacionCasoUsoImpl implements IAccionReparacionCasoUso {
	private final IAccionReparacionRepositorio repositorio;

	public AccionReparacionCasoUsoImpl(IAccionReparacionRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public AccionReparacion guardar(AccionReparacion accionReparacion) {
		return repositorio.guardar(accionReparacion);
	}

	@Override
	public AccionReparacion buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	}

	@Override
	public List<AccionReparacion> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);

	}

}
