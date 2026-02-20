package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacion;
import com.uisrael.proyectoapi.dominio.repositorios.IAccionReparacionRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IAccionReparacionJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IAccionReparacionJpaRepositorio;

public class AccionReparacionRepositorioImpl implements IAccionReparacionRepositorio {

	private final IAccionReparacionJpaRepositorio jpaRepositorio;
	private final IAccionReparacionJpaMapper entityMapper;

	public AccionReparacionRepositorioImpl(IAccionReparacionJpaRepositorio jpaRepositorio,IAccionReparacionJpaMapper mapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = mapper;
	}

	@Override
	public AccionReparacion guardar(AccionReparacion accionReparacion) {
		AccionReparacionJpa entity = entityMapper.toEntity(accionReparacion);
		AccionReparacionJpa guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<AccionReparacion> buscarPorId(int idAcionReparacion) {
		return jpaRepositorio.findById(idAcionReparacion).map(entityMapper::toDomain);
	}

	@Override
	public List<AccionReparacion> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idAcionReparacion) {
		jpaRepositorio.deleteById(idAcionReparacion);
	}
}
