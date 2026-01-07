package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Proveedor;
import com.uisrael.proyectoapi.dominio.repositorios.IProveedorRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ProveedorJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IProveedorJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IProveedorJpaRepositorio;

public class ProveedorRepositorioImpl implements IProveedorRepositorio{

	//dependencias
	private final IProveedorJpaRepositorio jpaRepositorio;
	private final IProveedorJpaMapper entityMapper;
	
	//constructor
	public ProveedorRepositorioImpl(IProveedorJpaRepositorio jpaRepositorio, IProveedorJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Proveedor guardar(Proveedor proveedor) {
		ProveedorJpa entity= entityMapper.toEntity(proveedor);
		ProveedorJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Proveedor> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Proveedor> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}
