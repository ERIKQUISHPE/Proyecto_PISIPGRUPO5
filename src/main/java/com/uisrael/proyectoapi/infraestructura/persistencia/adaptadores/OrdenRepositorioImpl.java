package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.dominio.repositorios.IOrdenRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IOrdenJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IOrdenJpaRepositorio;

public class OrdenRepositorioImpl implements IOrdenRepositorio{

	//dependencias
	private final IOrdenJpaRepositorio jpaRepositorio;
	private final IOrdenJpaMapper entityMapper;
	
	//constructor
	public OrdenRepositorioImpl(IOrdenJpaRepositorio jpaRepositorio, IOrdenJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Orden guardar(Orden orden) {
		OrdenJpa entity= entityMapper.toEntity(orden);
		OrdenJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Orden> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Orden> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}
