package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IPagoCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Pago;
import com.uisrael.proyectoapi.dominio.repositorios.IPagoRepositorio;

public class PagoCasoUsoImpl implements IPagoCasoUso {
	private final IPagoRepositorio repositorio;

	public PagoCasoUsoImpl(IPagoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Pago guardar(Pago pago) {
		return repositorio.guardar(pago);
	}

	@Override
	public Pago buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	}

	@Override
	public List<Pago> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);

	}

}
