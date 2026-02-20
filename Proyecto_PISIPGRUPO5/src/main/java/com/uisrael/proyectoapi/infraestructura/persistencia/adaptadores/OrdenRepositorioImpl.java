package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.dominio.repositorios.IOrdenRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IOrdenJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IOrdenJpaRepositorio;

public class OrdenRepositorioImpl implements IOrdenRepositorio {
	private final IOrdenJpaRepositorio jpaRepositorio;
	private final IOrdenJpaMapper entityMapper;

	public OrdenRepositorioImpl(IOrdenJpaRepositorio jpaRepositorio, IOrdenJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Orden guardar(Orden orden) {
		OrdenJpa entity = entityMapper.toEntity(orden);

		if (entity.getIdOrden() == 0) {
			entity.setEstadoOrden("INGRESADO");
		}

		OrdenJpa guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);

	}

	@Override
	public Optional<Orden> buscarPorId(int idOrden) {
		return jpaRepositorio.findById(idOrden).map(entityMapper::toDomain);
	}

	@Override
	public List<Orden> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idOrden) {
		jpaRepositorio.deleteById(idOrden);
	}

	@Override
	public List<Orden> listarOrdenesDisponibles() {
		return jpaRepositorio.listarOrdenesDisponibles().stream().map(entityMapper::toDomain).toList();
	}
}
