package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Material;
import com.uisrael.proyectoapi.dominio.repositorios.IMaterialRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.MaterialJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IMaterialJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IMaterialJpaRepositorio;

public class MaterialRepositorioImpl implements IMaterialRepositorio{

	private final IMaterialJpaRepositorio jpaRepositorio;
	private final IMaterialJpaMapper entityMapper;
	
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
	public Optional<Material> buscarPorId(int idMaterial) {
		return jpaRepositorio.findById(idMaterial).map(entityMapper::toDomain);
	}

	@Override
	public List<Material> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idMaterial) {
		jpaRepositorio.deleteById(idMaterial);
	}
}
