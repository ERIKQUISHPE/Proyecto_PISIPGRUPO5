package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Entrega;
import com.uisrael.proyectoapi.dominio.repositorios.IEntregaRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.EntregaJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IEntregaJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IEntregaJpaRepositorio;

public class EntregaRepositorioImpl implements IEntregaRepositorio{

	//dependencias
	private final IEntregaJpaRepositorio jpaRepositorio;
	private final IEntregaJpaMapper entityMapper;
	
	//constructor
	public EntregaRepositorioImpl(IEntregaJpaRepositorio jpaRepositorio, IEntregaJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Entrega guardar(Entrega entrega) {
		EntregaJpa entity= entityMapper.toEntity(entrega);
		EntregaJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Entrega> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Entrega> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}
