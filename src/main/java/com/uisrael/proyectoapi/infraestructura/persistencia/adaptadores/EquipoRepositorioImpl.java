package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Equipo;
import com.uisrael.proyectoapi.dominio.repositorios.IEquipoRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.EquipoJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IEquipoJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IEquipoJpaRepositorio;

public class EquipoRepositorioImpl implements IEquipoRepositorio{

	//dependencias
	private final IEquipoJpaRepositorio jpaRepositorio;
	private final IEquipoJpaMapper entityMapper;
	
	//constructor
	public EquipoRepositorioImpl(IEquipoJpaRepositorio jpaRepositorio, IEquipoJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Equipo guardar(Equipo equipo) {
		EquipoJpa entity= entityMapper.toEntity(equipo);
		EquipoJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Equipo> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Equipo> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}
