package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IEquipoCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Equipo;
import com.uisrael.proyectoapi.dominio.repositorios.IEquipoRepositorio;

public class EquipoCasoUsoImpl implements IEquipoCasoUso{
	private final IEquipoRepositorio repositorio;

	public EquipoCasoUsoImpl(IEquipoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Equipo guardar(Equipo equipo) {
		return repositorio.guardar(equipo);
	}

	@Override
	public Equipo buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	}

	@Override
	public List<Equipo> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

}
