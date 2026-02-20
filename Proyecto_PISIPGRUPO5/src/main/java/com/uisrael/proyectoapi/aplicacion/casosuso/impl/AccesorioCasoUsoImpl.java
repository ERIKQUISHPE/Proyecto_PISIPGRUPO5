package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IAccesorioCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Accesorio;
import com.uisrael.proyectoapi.dominio.repositorios.IAccesorioRepositorio;

public class AccesorioCasoUsoImpl implements IAccesorioCasoUso {
	private final IAccesorioRepositorio repositorio;

	public AccesorioCasoUsoImpl(IAccesorioRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Accesorio guardar(Accesorio accesorio) {
		return repositorio.guardar(accesorio);

	}

	@Override
	public Accesorio buscarPorId(int idAccesorio) {
		return repositorio.buscarPorId(idAccesorio).orElseThrow(() -> new RuntimeException("Accesorio no encontrado"));
	}

	@Override
	public List<Accesorio> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idAccesorio) {
		repositorio.eliminar(idAccesorio);

	}

}
