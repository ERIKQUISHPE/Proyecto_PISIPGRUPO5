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
	  public Equipo buscarPorId(int idEquipo) {
	    return repositorio.buscarPorId(idEquipo)
	      .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
	  }
	@Override
	public List<Equipo> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idEquipo) {
		repositorio.eliminar(idEquipo);
		
	}
	
	@Override
	public Boolean existePorOrden(Integer idOrden) {
	  return repositorio.existePorOrden(idOrden);
	}


}
