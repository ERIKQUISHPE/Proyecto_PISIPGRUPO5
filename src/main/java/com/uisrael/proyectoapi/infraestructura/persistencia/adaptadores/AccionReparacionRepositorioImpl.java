package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacion;
import com.uisrael.proyectoapi.dominio.repositorios.IAccionReparacionRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IAccionReparacionJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IAccionReparacionJpaRepositorio;

public class AccionReparacionRepositorioImpl implements IAccionReparacionRepositorio{

	//dependencias
	private final IAccionReparacionJpaRepositorio jpaRepositorio;
	private final IAccionReparacionJpaMapper entityMapper;
	
	//constructor
	public AccionReparacionRepositorioImpl(IAccionReparacionJpaRepositorio jpaRepositorio, IAccionReparacionJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public AccionReparacion guardar(AccionReparacion accionReparacion) {
		AccionReparacionJpa entity= entityMapper.toEntity(accionReparacion);
		AccionReparacionJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<AccionReparacion> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<AccionReparacion> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}

