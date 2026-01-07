package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Prioridad;
import com.uisrael.proyectoapi.dominio.repositorios.IPrioridadRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.PrioridadJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IPrioridadJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IPrioridadJpaRepositorio;

public class PrioridadRepositorioImpl implements IPrioridadRepositorio{

	//dependencias
	private final IPrioridadJpaRepositorio jpaRepositorio;
	private final IPrioridadJpaMapper entityMapper;
	
	//constructor
	public PrioridadRepositorioImpl(IPrioridadJpaRepositorio jpaRepositorio, IPrioridadJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Prioridad guardar(Prioridad prioridad) {
		PrioridadJpa entity= entityMapper.toEntity(prioridad);
		PrioridadJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Prioridad> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Prioridad> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}
