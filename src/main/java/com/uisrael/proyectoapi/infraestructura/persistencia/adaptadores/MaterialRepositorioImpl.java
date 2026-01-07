package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Material;
import com.uisrael.proyectoapi.dominio.repositorios.IMaterialRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.MaterialJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IMaterialJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IMaterialJpaRepositorio;

public class MaterialRepositorioImpl implements IMaterialRepositorio{

	//dependencias
	private final IMaterialJpaRepositorio jpaRepositorio;
	private final IMaterialJpaMapper entityMapper;
	
	//constructor
	public MaterialRepositorioImpl(IMaterialJpaRepositorio jpaRepositorio, IMaterialJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Material guardar(Material material) {
		MaterialJpa entity= entityMapper.toEntity(material);
		MaterialJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Material> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Material> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}
