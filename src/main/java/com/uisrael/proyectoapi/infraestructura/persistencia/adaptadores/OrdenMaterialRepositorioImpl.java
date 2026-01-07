package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.OrdenMaterial;
import com.uisrael.proyectoapi.dominio.repositorios.IOrdenMaterialRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenMaterialJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IOrdenMaterialJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IOrdenMaterialJpaRepositorio;

public class OrdenMaterialRepositorioImpl implements IOrdenMaterialRepositorio{

	//dependencias
	private final IOrdenMaterialJpaRepositorio jpaRepositorio;
	private final IOrdenMaterialJpaMapper entityMapper;
	
	//constructor
	public OrdenMaterialRepositorioImpl(IOrdenMaterialJpaRepositorio jpaRepositorio, IOrdenMaterialJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public OrdenMaterial guardar(OrdenMaterial ordenMaterial) {
		OrdenMaterialJpa entity= entityMapper.toEntity(ordenMaterial);
		OrdenMaterialJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<OrdenMaterial> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<OrdenMaterial> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}
