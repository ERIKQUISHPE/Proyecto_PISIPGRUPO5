package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Proveedor;
import com.uisrael.proyectoapi.dominio.repositorios.IProveedorRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ProveedorJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IProveedorJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IProveedorJpaRepositorio;

public class ProveedorRepositorioImpl implements IProveedorRepositorio{

	private final IProveedorJpaRepositorio jpaRepositorio;
	private final IProveedorJpaMapper entityMapper;

	public ProveedorRepositorioImpl(IProveedorJpaRepositorio jpaRepositorio, IProveedorJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Proveedor guardar(Proveedor proveedor) {

	    ProveedorJpa entity = entityMapper.toEntity(proveedor);
	    entity.setEstado(true);
	    ProveedorJpa guardado = jpaRepositorio.save(entity);
	    return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Proveedor> buscarPorId(int idProveedor) {
		return jpaRepositorio.findById(idProveedor).map(entityMapper::toDomain);
	}

	@Override
	public List<Proveedor> listarTodos() {
	    return jpaRepositorio.findByEstadoTrue().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idProveedor) {

	    ProveedorJpa proveedor = jpaRepositorio.findById(idProveedor)
	        .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

	    proveedor.setEstado(false);
	    jpaRepositorio.save(proveedor);
	}
}
