package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.OrdenInterna;
import com.uisrael.proyectoapi.dominio.repositorios.IOrdenInternaRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenInternaJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IOrdenInternaJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IOrdenInternaJpaRepositorio;

public class OrdenInternaRepositorioImpl implements IOrdenInternaRepositorio{

	//dependencias
	private final IOrdenInternaJpaRepositorio jpaRepositorio;
	private final IOrdenInternaJpaMapper entityMapper;
	
	//constructor
	public OrdenInternaRepositorioImpl(IOrdenInternaJpaRepositorio jpaRepositorio, IOrdenInternaJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public OrdenInterna guardar(OrdenInterna ordenInterna) {
		OrdenInternaJpa entity= entityMapper.toEntity(ordenInterna);
		OrdenInternaJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<OrdenInterna> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<OrdenInterna> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}
