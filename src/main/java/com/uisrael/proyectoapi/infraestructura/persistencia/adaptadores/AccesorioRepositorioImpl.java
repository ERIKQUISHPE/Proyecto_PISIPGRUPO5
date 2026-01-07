package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Accesorio;
import com.uisrael.proyectoapi.dominio.repositorios.IAccesorioRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccesorioJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IAccesorioJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IAccesorioJpaRepositorio;

public class AccesorioRepositorioImpl implements IAccesorioRepositorio{

	//dependencias
	private final IAccesorioJpaRepositorio jpaRepositorio;
	private final IAccesorioJpaMapper entityMapper;
	
	//constructor
	public AccesorioRepositorioImpl(IAccesorioJpaRepositorio jpaRepositorio, IAccesorioJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Accesorio guardar(Accesorio accesorio) {
		AccesorioJpa entity= entityMapper.toEntity(accesorio);
		AccesorioJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Accesorio> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Accesorio> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}
