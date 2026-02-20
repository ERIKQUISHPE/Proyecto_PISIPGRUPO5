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
	public AccionReparacion buscarPorId(int idAccionReparacion) {
		return repositorio.buscarPorId(idAccionReparacion).orElseThrow(() -> new RuntimeException("Accion Reparacion no encontrada"));
	}

	@Override
	public List<AccionReparacion> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idAccionReparacion) {
		repositorio.eliminar(idAccionReparacion);

	}

}
