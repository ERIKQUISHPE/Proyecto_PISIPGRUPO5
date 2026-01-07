package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.EstadoOrden;
import com.uisrael.proyectoapi.dominio.repositorios.IEstadoOrdenRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.EstadoOrdenJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IEstadoOrdenJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IEstadoOrdenJpaRepositorio;

public class EstadoOrdenRepositorioImpl implements IEstadoOrdenRepositorio{

	//dependencias
	private final IEstadoOrdenJpaRepositorio jpaRepositorio;
	private final IEstadoOrdenJpaMapper entityMapper;
	
	//constructor
	public EstadoOrdenRepositorioImpl(IEstadoOrdenJpaRepositorio jpaRepositorio, IEstadoOrdenJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public EstadoOrden guardar(EstadoOrden estadoOrden) {
		EstadoOrdenJpa entity= entityMapper.toEntity(estadoOrden);
		EstadoOrdenJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<EstadoOrden> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<EstadoOrden> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}
